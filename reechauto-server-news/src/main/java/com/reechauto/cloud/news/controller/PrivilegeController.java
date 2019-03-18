package com.reechauto.cloud.news.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.reechauto.cloud.common.resp.ResponseData;
import com.reechauto.cloud.news.bean.req.MenusQueryRequest;
import com.reechauto.cloud.news.bean.req.RolesQueryRequest;
import com.reechauto.cloud.news.entity.SysMenu;
import com.reechauto.cloud.news.entity.SysRole;
import com.reechauto.cloud.news.service.privilege.PrivilegeService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/privilege")
public class PrivilegeController {
	@Autowired
	private PrivilegeService privilegeService;

	/**
	 * 根据用户ID查询角色
	 * @param req
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/roles/queryByUserId", method = RequestMethod.POST)
	public ResponseData queryRoles(@Valid RolesQueryRequest req, BindingResult result) {
		log.info("查询角色");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(result.getAllErrors());
		}
		List<SysRole> list = privilegeService.queryRoleByUserId(req.getUserId());
		return ResponseData.ok().data(list);
	}
	
	/**
	 * 根据用户ID查询权限菜单
	 * @param req
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/menus/queryByUserId", method = RequestMethod.POST)
	public ResponseData queryPrivilege(@Valid MenusQueryRequest req, BindingResult result) {
		log.info("查询用户对应的菜单权限");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(result.getAllErrors());
		}
		List<SysMenu> list = privilegeService.queryPrivilege(req.getUserId());
		return ResponseData.ok().data(list);
	}
	

}
