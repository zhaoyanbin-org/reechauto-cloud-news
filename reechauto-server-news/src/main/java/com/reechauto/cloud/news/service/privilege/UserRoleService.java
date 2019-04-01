package com.reechauto.cloud.news.service.privilege;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import com.reechauto.cloud.common.resp.ResponseData;
import com.reechauto.cloud.news.bean.user.User;
import com.reechauto.cloud.news.entity.SysRole;
import com.reechauto.cloud.news.entity.SysUserRole;
import com.reechauto.cloud.news.entity.SysUserRoleExample;
import com.reechauto.cloud.news.entity.UserDetails;
import com.reechauto.cloud.news.entity.UserDetailsExample;
import com.reechauto.cloud.news.entity.UserDetailsExample.Criteria;
import com.reechauto.cloud.news.mapper.SysRoleMapper;
import com.reechauto.cloud.news.mapper.SysUserRoleMapper;
import com.reechauto.cloud.news.mapper.UserDetailsMapper;

@Service
public class UserRoleService {

	@Autowired
	private UserDetailsMapper userDetailsMapper;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;
	@Autowired
	private SysRoleMapper sysRoleMapper;
	
	public ResponseData queryUsers(Long userId,Integer start,Integer pageNum) {
		UserDetailsExample example = new UserDetailsExample();
		Criteria criteria = example.createCriteria();
		if (userId!=null) {
			criteria.andUserIdEqualTo(userId);
		}
		Long total = userDetailsMapper.countByExample(example);
		example.setOffset(pageNum);
		example.setLimitStart(start);
		List<UserDetails> list = userDetailsMapper.selectByExample(example);
		List<User> nList = new ArrayList<User>();
		if (CollectionUtils.isNotEmpty(list)) {
			for(UserDetails userDetails:list) {
				User user = new User();
				BeanUtils.copyProperties(userDetails, user);
				String sql = "SELECT r.* from sys_user_role s,sys_role r where s.user_id = ? and s.role_id = r.role_id ";
				RowMapper<SysRole> rowMapper = new BeanPropertyRowMapper<SysRole>(SysRole.class);
				List<SysRole> list1 = this.jdbcTemplate.query(sql, rowMapper, user.getUserId());
				user.setRoles(list1);
				nList.add(user);
			}
		}
		return ResponseData.ok().data(nList).data("total", total);
	}
	
	@Transactional
	public void setRoles(Long userId,Long setter,String roleIds) {
		delUserRole(userId);
		UserDetails userDetails = userDetailsMapper.selectByPrimaryKey(userId);
		if (userDetails==null) {
			throw new RuntimeException("userId错误，对应的user不存在");
		}
		String[] roleIds1 = roleIds.split(",");
		for(int i = 0;i<roleIds1.length;i++) {
			String roleId = roleIds1[i];
			SysRole sysRole = sysRoleMapper.selectByPrimaryKey(roleId);
			if (sysRole==null) {
				throw new RuntimeException("roleId错误，对应的role不存在");
			}
			SysUserRole record = new SysUserRole();
			record.setRoleId(roleId);
			record.setUserId(userId);
			record.setCreateBy(setter);
			record.setCreateTime(new Date());
			sysUserRoleMapper.insert(record);
		}
		
	}
	
	public boolean delUserRole(Long userId) {
		SysUserRoleExample example = new SysUserRoleExample();
		com.reechauto.cloud.news.entity.SysUserRoleExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		return sysUserRoleMapper.deleteByExample(example)>0;
	}
}
