package com.reechauto.cloud.news.service.privilege;

import java.util.List;
import javax.transaction.Transactional;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.reechauto.cloud.news.bean.req.privilege.MenuDelRequest;
import com.reechauto.cloud.news.entity.SysMenu;
import com.reechauto.cloud.news.entity.SysMenuExample;
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
	public void delMenu(MenuDelRequest req) {
		log.info("删除当前菜单以及下级菜单");
		SysMenu sysMenu = this.sysMenuMapper.selectByPrimaryKey(req.getId());
		if (sysMenu == null) {
			throw new RuntimeException("不存在的菜单ID'" + req.getId() + "'");
		}
		sysMenu.setStatus("N");;
		this.sysMenuMapper.updateByPrimaryKeySelective(sysMenu);
		delMenuByParentId(req.getId());
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
}
