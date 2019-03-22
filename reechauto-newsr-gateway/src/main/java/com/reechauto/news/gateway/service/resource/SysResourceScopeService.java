package com.reechauto.news.gateway.service.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

@Service
public class SysResourceScopeService {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<SysResourceScope> queryResourceScopse() {
		String sql = "SELECT * FROM sys_resource_scope ";
		RowMapper<SysResourceScope> rowMapper = new BeanPropertyRowMapper<SysResourceScope>(SysResourceScope.class);
		List<SysResourceScope> list = this.jdbcTemplate.query(sql, rowMapper);
		return list;
	}
}
