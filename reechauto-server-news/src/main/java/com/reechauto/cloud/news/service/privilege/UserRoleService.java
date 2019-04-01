package com.reechauto.cloud.news.service.privilege;

import java.util.ArrayList;
import java.util.List;
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
import com.reechauto.cloud.news.entity.UserDetails;
import com.reechauto.cloud.news.entity.UserDetailsExample;
import com.reechauto.cloud.news.entity.UserDetailsExample.Criteria;
import com.reechauto.cloud.news.mapper.UserDetailsMapper;

@Service
public class UserRoleService {

	@Autowired
	private UserDetailsMapper userDetailsMapper;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
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
}
