package com.reechauto.cloud.news.controller.privilege;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.reechauto.cloud.common.resp.ResponseData;
import com.reechauto.cloud.news.bean.req.user.SetRoleRequest;
import com.reechauto.cloud.news.bean.req.user.UserRequest;
import com.reechauto.cloud.news.service.privilege.UserRoleService;
import com.reechauto.cloud.news.utils.ErrorsUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/userRole")
public class UserRoleController {

	@Autowired
	private UserRoleService userRoleService;
	
	/**
	 * 查询所有用户
	 * @return
	 */
	@RequestMapping(value = "/queryUsers", method = RequestMethod.POST)
	public ResponseData queryUsers(@Valid UserRequest req, BindingResult result) {
		log.info("查询所有用户");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(ErrorsUtil.fieldError2Map(result.getFieldErrors()));
		}
		ResponseData resp = userRoleService.queryUsers(req.getUserId(),req.getStart(),req.getPageNum());
		return resp;
	}
	
	/**
	 * 给用户分配角色
	 * @return
	 */
	@RequestMapping(value = "/setRoles", method = RequestMethod.POST)
	public ResponseData setRoles(@Valid SetRoleRequest req, BindingResult result) {
		log.info("给用户分配角色");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(ErrorsUtil.fieldError2Map(result.getFieldErrors()));
		}
		userRoleService.setRoles(req.getUserId(),req.getSetter(),req.getRoleIds());
		return ResponseData.ok();
	}
}
