package com.reechauto.cloud.news.controller.privilege;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.reechauto.cloud.common.resp.ResponseData;
import com.reechauto.cloud.news.bean.req.privilege.RoleQueryRequest;
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
		ResponseData resp = roleService.queryRoles(req.getRoleId(),req.getRoleName());
		return resp;
	}
	
	/**
	 * 修改角色
	 * @param req
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/query", method = RequestMethod.POST)
	public ResponseData updateRoles(@Valid RoleQueryRequest req, BindingResult result) {
		log.info("修改角色");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(ErrorsUtil.fieldError2Map(result.getFieldErrors()));
		}
		ResponseData resp = roleService.queryRoles(req.getRoleId(),req.getRoleName());
		return resp;
	}
	
}
