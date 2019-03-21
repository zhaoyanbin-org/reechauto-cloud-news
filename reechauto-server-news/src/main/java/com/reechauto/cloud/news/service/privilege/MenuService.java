package com.reechauto.cloud.news.service.privilege;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.reechauto.cloud.news.bean.menu.SysMenuBean;
import com.reechauto.cloud.news.entity.SysMenu;
import com.reechauto.cloud.news.entity.SysMenuExample;
import com.reechauto.cloud.news.entity.SysMenuExample.Criteria;
import com.reechauto.cloud.news.mapper.SysMenuMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MenuService {
    @Autowired
	private SysMenuMapper sysMenuMapper;
	

	/**
	 * 删除当前菜单以及下级菜单
	 * @param req
	 */
	@Transactional
	public void delMenu(Integer id) {
		log.info("删除当前菜单以及下级菜单");
		SysMenu sysMenu = this.sysMenuMapper.selectByPrimaryKey(id);
		if (sysMenu == null) {
			throw new RuntimeException("不存在的菜单ID'" + id + "'");
		}
		sysMenu.setStatus("N");;
		this.sysMenuMapper.updateByPrimaryKeySelective(sysMenu);
		delMenuByParentId(id);
	}
	/**
	 * 根据父ID删除菜单
	 * @param pId
	 */
	@Transactional
	public void delMenuByParentId(Integer pId) {
		log.info("删除下级菜单");
		SysMenuExample example = new SysMenuExample();
		example.createCriteria().andPIdEqualTo(pId);
		List<SysMenu> menuList = this.sysMenuMapper.selectByExample(example);
		if (CollectionUtils.isNotEmpty(menuList)) {
			menuList.forEach(item -> {
				SysMenu sysMenu = this.sysMenuMapper.selectByPrimaryKey(item.getId());
				sysMenu.setStatus("N");;
				this.sysMenuMapper.updateByPrimaryKeySelective(sysMenu);
				delMenuByParentId(item.getId());
			});
		}
	}
	
	/**
	 * 根据pId查询所有的子菜单
	 * @param req
	 * @return
	 */
	public List<SysMenuBean> queryMenuByParentId(int pId) {
		List<SysMenuBean> list = new ArrayList<SysMenuBean>();
		SysMenuExample example = new SysMenuExample();
		Criteria criteria = example.createCriteria();
		criteria.andPIdEqualTo(pId);
		criteria.andStatusEqualTo("Y");
		example.setOrderByClause(" sort ASC");
		List<SysMenu> menuList = this.sysMenuMapper.selectByExample(example);
		if (CollectionUtils.isNotEmpty(menuList)) {
			menuList.forEach(item -> {
				SysMenuBean bean = new SysMenuBean();
				BeanUtils.copyProperties(item, bean);
				List<SysMenuBean> childMenu = queryMenuByParentId(item.getId());
				bean.setChildMenu(childMenu);
				list.add(bean);
			});
		}
		return list;
	}
	
	private Integer getMenuId(int pId) {
		if (pId <= 0) {
			pId = 0;
		}
		SysMenuExample example = new SysMenuExample();
		example.createCriteria().andPIdEqualTo(pId);
		example.setOrderByClause(" id desc");
		List<SysMenu> list = this.sysMenuMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(list)) {
			// 没有子组织,父组织Id后加10;
			if (pId == 0) {
				return 10;
			} else {
				return Integer.valueOf(pId + "10");
			}
		}
		return list.get(0).getId() + 1;
	}
	private int queryMenuName(String menuName) {
		SysMenuExample example = new SysMenuExample();
		example.createCriteria().andNameEqualTo(menuName);
		return (int) this.sysMenuMapper.countByExample(example);
	}
	/**
	 * 新增菜单
	 * @param pId
	 * @param pCode
	 * @param name
	 * @param url
	 * @param isMenu
	 * @param sort
	 * @return
	 */
	public boolean addMenu(Integer pId,String pCode,String name,String url,Integer isMenu,Integer sort) {
		log.info("添加菜单");
		int n = queryMenuName(name.trim());
		if (n > 0) {
			throw new RuntimeException("菜单名'" + name + "'已被占用");
		}
		SysMenu record = new SysMenu();
		Integer id = getMenuId(pId);
		if (pId <= 0) {
			
			// 第一级组织
			record.setStatus("Y");
			record.setId(id);
			record.setName(name);
			record.setpId(0);
			record.setpCode("0");
			record.setLevel(1);
			record.setSort(sort);
			record.setCode("menus_"+id);
			if (StringUtils.isNotBlank(url)) {
				record.setUrl(url);
			}
			record.setIsMenu(isMenu);
		} else {
			// 查询上一级组织
			SysMenu parent = this.sysMenuMapper.selectByPrimaryKey(pId);
			if (parent == null) {
				throw new RuntimeException("不存在的上级菜单ID'" + pId + "'");
			}
			int level = parent.getLevel() + 1;
			record.setStatus("Y");
			record.setId(id);
			record.setName(name);
			record.setpId(pId);
			record.setpCode(pCode);
			record.setLevel(level);
			record.setSort(sort);
			String code = parent.getCode()+"_"+Integer.toString(id).substring(Integer.toString(id).length()-2,Integer.toString(id).length());
			record.setCode(code);
			if (StringUtils.isNotBlank(url)) {
				record.setUrl(url);
			}
			record.setIsMenu(isMenu);
		}
		return this.sysMenuMapper.insertSelective(record) > 0;
	}
    /**
     * 修改菜单
     * @param id
     * @param name
     * @param url
     * @param isMenu
     * @param sort
     * @return
     */
	public boolean updateMenu(Integer id,String name,String url,Integer isMenu,Integer sort) {
		SysMenu record = new SysMenu();
		record.setId(id);
		if (StringUtils.isNotBlank(name)) {
			record.setName(name);
		}
		if (StringUtils.isNotBlank(url)) {
			record.setUrl(url);
		}
		if (isMenu!=null) {
			record.setIsMenu(isMenu);
		}
		if (sort!=null) {
			record.setSort(sort);
		}
		return sysMenuMapper.updateByPrimaryKeySelective(record)>0;
	}
}
