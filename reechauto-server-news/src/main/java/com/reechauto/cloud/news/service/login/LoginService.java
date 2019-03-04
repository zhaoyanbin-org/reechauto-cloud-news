package com.reechauto.cloud.news.service.login;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.reechauto.cloud.common.resp.ResponseData;
import com.reechauto.cloud.common.utils.date.DateUtil;
import com.reechauto.cloud.news.entity.SysMenu;
import com.reechauto.cloud.news.entity.SysResourceScope;
import com.reechauto.cloud.news.entity.SysResourceScopeExample;
import com.reechauto.cloud.news.entity.SysRole;
import com.reechauto.cloud.news.entity.UserDetails;
import com.reechauto.cloud.news.mapper.SysResourceScopeMapper;
import com.reechauto.cloud.news.mapper.UserDetailsMapper;

@Service
public class LoginService {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private UserDetailsMapper userDetailsMapper;
	@Autowired
	private SysResourceScopeMapper sysResourceScopeMapper;
	
	/**
	 * 每次登录时更新用户信息
	 * @param userId
	 * @param nickName
	 * @param realName
	 * @param account
	 * @param mobile
	 * @param email
	 * @param idcard
	 * @param sex
	 * @param birthday
	 * @param imgUrl
	 * @param city
	 * @return
	 */
	public ResponseData loginUser(Long userId,String nickName,String realName,String account,String mobile,String email,String idcard,String sex,String birthday,String imgUrl,String city) {
		UserDetails user = initUser(userId,nickName,realName,account,mobile,email,idcard,sex,birthday,imgUrl,city);
		ResponseData ret = ResponseData.ok();
		ret.data("userInfo", user);
		return ret;
	}
	
	private UserDetails initUser(Long userId,String nickName,String realName,String account,String mobile,String email,String idcard,String sex,String birthday,String imgUrl,String city) {
		UserDetails user = this.userDetailsMapper.selectByPrimaryKey(userId);
		if(user==null) {
			user= new UserDetails();
			user.setUserId(userId);
			user.setNickName(nickName);
			user.setRealName(realName);
			user.setAccount(account);
			user.setMobile(mobile);
			user.setEmail(email);
			user.setIdcard(idcard);
			user.setSex(sex);
			user.setBirthday(StringUtils.isBlank(birthday)?null:(DateUtil.convert2Date(birthday, "yyyy-MM-dd HH:mm:ss")));
			user.setImgUrl(imgUrl);
			user.setCity(city);
		  this.userDetailsMapper.insertSelective(user);	
		}
		else {
			user.setUserId(userId);
			user.setNickName(nickName);
			user.setRealName(realName);
			user.setAccount(account);
			user.setMobile(mobile);
			user.setEmail(email);
			user.setIdcard(idcard);
			user.setSex(sex);
			user.setBirthday(StringUtils.isBlank(birthday)?null:(DateUtil.convert2Date(birthday, "yyyy-MM-dd HH:mm:ss")));
			user.setImgUrl(imgUrl);
			user.setCity(city);
			user.setModifyTime(new Date());
			this.userDetailsMapper.updateByPrimaryKeySelective(user);
		}
		return user;
	}
	
	/**
	 * 查询角色
	 * @param userId
	 * @return
	 */
	public List<SysRole> queryRoleByUserId(Long userId) {
		String sql = "SELECT a.* FROM sys_role a,sys_user_role b WHERE a.status='Y' AND a.role_id=b.role_id AND b.user_id=?";		
		RowMapper<SysRole> rowMapper = new BeanPropertyRowMapper<SysRole>(SysRole.class);
		List<SysRole> list = this.jdbcTemplate.query(sql, rowMapper,userId);
		return list;
	}
	
	/**
	 * 查询授权的菜单
	 * @param userId
	 * @return
	 */
	public List<SysMenu>  queryPrivilege(Long userId){
		String sql="SELECT * FROM sys_menu t WHERE t.status='Y' AND EXISTS (SELECT 1 FROM (SELECT a.menu_id FROM sys_privilege a,sys_user_role b,sys_role c WHERE a.role_id=b.role_id AND b.role_id=c.role_id AND c.status='Y' AND b.user_id=?)m WHERE t.id=m.menu_id)  ORDER BY t.sort ASC";
		RowMapper<SysMenu> rowMapper = new BeanPropertyRowMapper<SysMenu>(SysMenu.class);
		List<SysMenu> list = this.jdbcTemplate.query(sql, rowMapper,userId);
		return list;
	}
	
	/**
	 * 查询微服务的授权
	 * @return
	 */
	public List<SysResourceScope> queryResourceScopse(){
		SysResourceScopeExample example=new SysResourceScopeExample();
		return sysResourceScopeMapper.selectByExample(example);
	}
	
}
