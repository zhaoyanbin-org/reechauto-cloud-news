package com.reechauto.cloud.news.service.privilege;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.reechauto.cloud.news.bean.menu.LeftMenuBean;
import com.reechauto.cloud.news.entity.SysMenu;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MainMenuService {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 查询登录用户左侧菜单树
	 * @param userId
	 * @return
	 */
	public List<LeftMenuBean> queryMainLeft(Long userId) {
		log.info("加载左侧树");
		List<SysMenu> list = queryPrivilege(userId);
		List<LeftMenuBean> leftList = getUserLeftMenu(0L, list);
		return leftList;
	}

	/**
	 * 根据list集合查询树
	 * @param pid
	 * @param list
	 * @return
	 */
	private List<LeftMenuBean> getUserLeftMenu(Long pid, List<SysMenu> list) {
		List<LeftMenuBean> lmlist = new ArrayList<LeftMenuBean>();
		List<SysMenu> fl = list.stream().filter(item -> item.getpId() == pid).collect(Collectors.toList());
		if (CollectionUtils.isNotEmpty(fl)) {
			fl.forEach(item -> {
				LeftMenuBean lmb = new LeftMenuBean();
				BeanUtils.copyProperties(item, lmb);
				List<LeftMenuBean> child = getUserLeftMenu(item.getId(), list);
				lmb.setChild(child);
				lmlist.add(lmb);
			});
		}
		return lmlist;
	}

	/**
	 * 查询当前用户的权限集合
	 * @param userId
	 * @return
	 */
	public List<SysMenu> queryPrivilege(Long userId) {
		String sql = "SELECT DISTINCT m.* FROM ( SELECT b.menu_id FROM sys_user_role a,sys_privilege b WHERE a.role_id=b.role_id AND a.user_id=? ) t ,sys_menu m WHERE t.menu_id=m.id AND m.status='Y' AND m.type<>3 ORDER BY m.level ASC,m.sort ASC";
		RowMapper<SysMenu> rowMapper = new BeanPropertyRowMapper<SysMenu>(SysMenu.class);
		List<SysMenu> list = this.jdbcTemplate.query(sql, rowMapper, userId);
		return list;
	}
}
