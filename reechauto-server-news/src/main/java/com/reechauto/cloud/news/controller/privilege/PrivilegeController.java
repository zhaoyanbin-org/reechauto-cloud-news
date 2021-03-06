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
import com.reechauto.cloud.news.bean.req.privilege.MenusQueryRequest;
import com.reechauto.cloud.news.bean.req.privilege.PrivilegeAddRequest;
import com.reechauto.cloud.news.bean.req.privilege.PrivilegeQueryRequest;
import com.reechauto.cloud.news.bean.req.privilege.RolesQueryRequest;
import com.reechauto.cloud.news.entity.SysMenu;
import com.reechauto.cloud.news.entity.SysRole;
import com.reechauto.cloud.news.service.privilege.PrivilegeService;
import com.reechauto.cloud.news.utils.ErrorsUtil;
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
			return ResponseData.argumentsError().data(ErrorsUtil.fieldError2Map(result.getFieldErrors()));
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
			return ResponseData.argumentsError().data(ErrorsUtil.fieldError2Map(result.getFieldErrors()));
		}
		List<SysMenu> list = privilegeService.queryPrivilege(req.getUserId());
		return ResponseData.ok().data(list);
	}
	/**
	 * 新增角色--菜单权限
	 * @param req
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ResponseData addPrivilege(@Valid PrivilegeAddRequest req, BindingResult result) {
		log.info("新增角色--菜单权限");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(ErrorsUtil.fieldError2Map(result.getFieldErrors()));
		}
		privilegeService.addPrivilege(req.getRoleId(),req.getMenuIds(),req.getUserId());
		return ResponseData.ok();
	}
	
	/**
	 * 查询一个角色对应的所有菜单权限
	 * @param req
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "queryMenusByRoleId", method = RequestMethod.POST)
	public ResponseData queryMenusByRoleId(@Valid PrivilegeQueryRequest req, BindingResult result) {
		log.info("查询一个角色对应的所有菜单权限 ");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(ErrorsUtil.fieldError2Map(result.getFieldErrors()));
		}
		List<SysMenuBean> list = privilegeService.queryMenusByRoleId(req.getRoleId());
		
		return ResponseData.ok().data(list);
	}

}
