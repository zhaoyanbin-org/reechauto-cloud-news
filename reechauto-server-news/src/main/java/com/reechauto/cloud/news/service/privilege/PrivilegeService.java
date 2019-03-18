package com.reechauto.cloud.news.service.privilege;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import com.reechauto.cloud.news.entity.SysMenu;
import com.reechauto.cloud.news.entity.SysRole;

@Service
public class PrivilegeService {
	@Autowired
	private JdbcTemplate jdbcTemplate;


	/**
	 * 查询角色
	 * 
	 * @param userId
	 * @return
	 */
	public List<SysRole> queryRoleByUserId(Long userId) {
		String sql = "SELECT a.* FROM sys_role a,sys_user_role b WHERE a.status='Y' AND a.role_id=b.role_id AND b.user_id=?";
		RowMapper<SysRole> rowMapper = new BeanPropertyRowMapper<SysRole>(SysRole.class);
		List<SysRole> list = this.jdbcTemplate.query(sql, rowMapper, userId);
		return list;
	}

	/**
	 * 查询授权的菜单
	 * 
	 * @param userId
	 * @return
	 */
	public List<SysMenu> queryPrivilege(Long userId) {
		String sql = "SELECT * FROM sys_menu t WHERE t.status='Y' AND EXISTS (SELECT 1 FROM (SELECT a.menu_id FROM sys_privilege a,sys_user_role b,sys_role c WHERE a.role_id=b.role_id AND b.role_id=c.role_id AND c.status='Y' AND b.user_id=?)m WHERE t.id=m.menu_id)  ORDER BY t.sort ASC";
		RowMapper<SysMenu> rowMapper = new BeanPropertyRowMapper<SysMenu>(SysMenu.class);
		List<SysMenu> list = this.jdbcTemplate.query(sql, rowMapper, userId);
		return list;
	}
	


}
