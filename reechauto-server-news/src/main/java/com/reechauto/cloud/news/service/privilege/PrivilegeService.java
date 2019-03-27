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
import com.reechauto.cloud.news.bean.menu.MenuId;
import com.reechauto.cloud.news.bean.menu.SysMenuBean;
import com.reechauto.cloud.news.entity.SysMenu;
import com.reechauto.cloud.news.entity.SysPrivilege;
import com.reechauto.cloud.news.entity.SysPrivilegeExample;
import com.reechauto.cloud.news.entity.SysPrivilegeExample.Criteria;
import com.reechauto.cloud.news.entity.SysRole;
import com.reechauto.cloud.news.mapper.SysMenuMapper;
import com.reechauto.cloud.news.mapper.SysPrivilegeMapper;
import com.reechauto.cloud.news.mapper.SysRoleMapper;

@Service
public class PrivilegeService {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private SysPrivilegeMapper sysPrivilegeMapper;
	@Autowired
	private SysMenuMapper sysMenuMapper;
	@Autowired
	private SysRoleMapper sysRoleMapper;
	@Autowired
	private MenuService menuService;

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
		String sql = "SELECT * FROM sys_menu t WHERE t.status='Y' AND t.type='3' AND EXISTS (SELECT 1 FROM (SELECT a.menu_id FROM sys_privilege a,sys_user_role b,sys_role c WHERE a.role_id=b.role_id AND b.role_id=c.role_id AND c.status='Y' AND b.user_id=?)m WHERE t.id=m.menu_id)  ORDER BY t.sort ASC";
		RowMapper<SysMenu> rowMapper = new BeanPropertyRowMapper<SysMenu>(SysMenu.class);
		List<SysMenu> list = this.jdbcTemplate.query(sql, rowMapper, userId);
		return list;
	}

	/**
	 * 新增角色--菜单权限
	 * 
	 * @param roleId
	 * @param menuId
	 * @param userId
	 * @return
	 */
	@Transactional
	public void addPrivilege(String roleId, String menuIds, Long userId) {
		delPrivileges(roleId);
		SysRole sysRole = sysRoleMapper.selectByPrimaryKey(roleId);
		if (sysRole == null) {
			throw new RuntimeException("roleId错误，对应的role不存在");
		}
		String[] menuIds1 = menuIds.split(",");
		for (int i = 0; i < menuIds1.length; i++) {
			Long menuId = Long.parseLong(menuIds1[i]);
			SysMenu sysMenu = sysMenuMapper.selectByPrimaryKey(menuId);
			if (sysMenu == null) {
				throw new RuntimeException("menuId错误，对应的menu不存在");
			}
			
			SysPrivilege record = new SysPrivilege();
			record.setRoleId(roleId);
			record.setMenuId(menuId);
			record.setCreateBy(userId);
			record.setCreateTime(new Date());
			sysPrivilegeMapper.insert(record);
		}
	}

	

	/**
	 * 查询某角色对应的所有菜单
	 * 
	 * @param roleId
	 * @return
	 */
	public ResponseData queryMenusByRoleId(int pId, String roleId) {
		List<SysMenuBean> allList = menuService.queryMenuByParentId(0L);
		String sql = "SELECT t.menu_id FROM sys_privilege t,sys_menu m WHERE t.role_id = ? and t.menu_id = m.id and m.status = 'Y' ";
		RowMapper<MenuId> rowMapper = new BeanPropertyRowMapper<MenuId>(MenuId.class);
		List<MenuId> menuIdList = this.jdbcTemplate.query(sql, rowMapper, roleId);
		return ResponseData.ok().data("allList", allList).data("menuIdList", menuIdList);
	}

	/**
	 * 根据pId查询某角色所有的子菜单
	 * @param req
	 * @return
	 */
	public List<SysMenuBean> queryMenuByParentId(Long pId,String roleId) {
		List<SysMenuBean> list = new ArrayList<SysMenuBean>();
		/*SysMenuExample example = new SysMenuExample();
		com.reechauto.cloud.news.entity.SysMenuExample.Criteria criteria = example.createCriteria();
		criteria.andPIdEqualTo(pId);
		criteria.andStatusEqualTo("Y");
		example.setOrderByClause(" sort ASC");
		List<SysMenu> menuList = this.sysMenuMapper.selectByExample(example);*/
		String sql = "SELECT m.* FROM sys_privilege t,sys_menu m WHERE t.role_id = ? and t.menu_id = m.id and m.status = 'Y' and m.p_id = ?";
		RowMapper<SysMenu> rowMapper = new BeanPropertyRowMapper<SysMenu>(SysMenu.class);
		List<SysMenu> menuList = this.jdbcTemplate.query(sql, rowMapper, roleId,pId);
		if (CollectionUtils.isNotEmpty(menuList)) {
			menuList.forEach(item -> {
				SysMenuBean bean = new SysMenuBean();
				BeanUtils.copyProperties(item, bean);
				List<SysMenuBean> childMenu = queryMenuByParentId(item.getId(), roleId);
				bean.setChildMenu(childMenu);
				list.add(bean);
			});
		}
		return list;
	}

	/**
	 * 删除某角色对应的所有菜单权限
	 * 
	 * @param roleId
	 * @param menuId
	 * @return
	 */
	public boolean delPrivileges(String roleId) {
		SysPrivilegeExample example = new SysPrivilegeExample();
		Criteria criteria = example.createCriteria();
		criteria.andRoleIdEqualTo(roleId.trim());
		return sysPrivilegeMapper.deleteByExample(example) > 0;
	}

}
