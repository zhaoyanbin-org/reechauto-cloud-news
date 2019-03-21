package com.reechauto.cloud.news.controller.privilege;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.reechauto.cloud.common.resp.ResponseData;
import com.reechauto.cloud.news.bean.menu.SysMenuBean;
import com.reechauto.cloud.news.bean.req.privilege.MenuAddRequest;
import com.reechauto.cloud.news.bean.req.privilege.MenuDelRequest;
import com.reechauto.cloud.news.bean.req.privilege.MenuQueryByParentIdRequest;
import com.reechauto.cloud.news.bean.req.privilege.MenuUpdateRequest;
import com.reechauto.cloud.news.service.privilege.MenuService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private MenuService menuService;
	/**
	 * 根据id删除菜单及子菜单
	 * @param req
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	public ResponseData delMenuById(@Valid MenuDelRequest req, BindingResult result) {
		log.info("根据id删除菜单及其子菜单");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(result.getAllErrors());
		}
		menuService.delMenu(req.getId());
		return ResponseData.ok();
	}
	/**
	 * 根据父id查询所有的子菜单
	 * @param req
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/queryMenuByParentId", method = RequestMethod.POST)
	public ResponseData queryMenuByParentId(@Valid MenuQueryByParentIdRequest req, BindingResult result) {
		log.info(" 根据父id查询所有的子菜单");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(result.getAllErrors());
		}
		List<SysMenuBean> list = menuService.queryMenuByParentId(req.getpId());
		return ResponseData.ok().data(list);
	}
	/**
	 * 新增菜单
	 * @param req
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseData addMenu(@Valid MenuAddRequest req, BindingResult result) {
		log.info("新增菜单");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(result.getAllErrors());
		}
		boolean flag = menuService.addMenu(req.getpId(),req.getpCode(),req.getName(),req.getUrl(),req.getIsMenu(),req.getSort());
		if (!flag) {
			throw new RuntimeException("新增菜单失败");
		}
		return ResponseData.ok();
	}
	/**
	 * 修改菜单
	 * @param req
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseData updateMenu(@Valid MenuUpdateRequest req, BindingResult result) {
		log.info("修改菜单");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(result.getAllErrors());
		}
		boolean flag = menuService.updateMenu(req.getId(),req.getName(),req.getUrl(),req.getIsMenu(),req.getSort());
		if (!flag) {
			throw new RuntimeException("修改菜单失败");
		}
		return ResponseData.ok();
	}
}
