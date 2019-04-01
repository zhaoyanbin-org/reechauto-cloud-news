package com.reechauto.cloud.news.controller.privilege;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.reechauto.cloud.common.resp.ResponseData;
import com.reechauto.cloud.news.bean.req.privilege.RoleAddRequest;
import com.reechauto.cloud.news.bean.req.privilege.RoleDeleteRequest;
import com.reechauto.cloud.news.bean.req.privilege.RoleQueryRequest;
import com.reechauto.cloud.news.bean.req.privilege.RoleUpdateRequest;
import com.reechauto.cloud.news.service.privilege.RoleService;
import com.reechauto.cloud.news.utils.ErrorsUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	/**
	 * 查询所有角色
	 * @return
	 */
	@RequestMapping(value = "/queryAll", method = RequestMethod.POST)
	public ResponseData queryRoles() {
		log.info("查询所有角色");
		ResponseData resp = roleService.queryAllRoles();
		return resp;
	}
	
	/**
	 * 根据条件查询角色
	 * @param req
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/query", method = RequestMethod.POST)
	public ResponseData queryRoles(@Valid RoleQueryRequest req, BindingResult result) {
		log.info("根据条件查询角色");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(ErrorsUtil.fieldError2Map(result.getFieldErrors()));
		}
		ResponseData resp = roleService.queryRoles(req.getRoleId(),req.getRoleName(),req.getStart(),req.getPageNum());
		return resp;
	}
	
	/**
	 * 修改角色
	 * @param req
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseData updateRole(@Valid RoleUpdateRequest req, BindingResult result) {
		log.info("修改角色");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(ErrorsUtil.fieldError2Map(result.getFieldErrors()));
		}
		boolean flag = roleService.updateRole(req.getRoleId(),req.getRoleName(),req.getTips(),req.getUserId());
		if (!flag) {
			throw new RuntimeException("修改角色失败");
		}
		return ResponseData.ok();
	}
	
	/**
	 * 删除角色
	 * @param req
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ResponseData deleteRole(@Valid RoleDeleteRequest req, BindingResult result) {
		log.info("删除角色");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(ErrorsUtil.fieldError2Map(result.getFieldErrors()));
		}
		boolean flag = roleService.deleteRole(req.getRoleId());
		if (!flag) {
			throw new RuntimeException("删除角色失败");
		}
		return ResponseData.ok();
	}
	
	/**
	 * 添加角色
	 * @param req
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseData addRole(@Valid RoleAddRequest req, BindingResult result) {
		log.info("添加角色");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(ErrorsUtil.fieldError2Map(result.getFieldErrors()));
		}
		boolean flag = roleService.addRole(req.getRoleId(),req.getRoleName(),req.getTips(),req.getUserId());
		if (!flag) {
			throw new RuntimeException("添加角色失败");
		}
		return ResponseData.ok();
	}
	
}
