package com.reechauto.cloud.news.controller.privilege;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reechauto.cloud.common.resp.ResponseData;
import com.reechauto.cloud.news.bean.organize.UserOrganizeDetails;
import com.reechauto.cloud.news.bean.req.privilege.OrganizeUserAddRequest;
import com.reechauto.cloud.news.bean.req.privilege.OrganizeUserDelRequest;
import com.reechauto.cloud.news.bean.req.privilege.OrganizeUserQueryByOrgIdRequest;
import com.reechauto.cloud.news.service.privilege.OrganizeUserService;
import com.reechauto.cloud.news.utils.ErrorsUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/organize-user")
public class OrganizeUserController {
	@Autowired
	private OrganizeUserService organizeUserService;

	/**
	 * 给组织添加人员
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseData organizeAddUser(@Valid OrganizeUserAddRequest req, BindingResult result) {
		log.info("为组织添加人员");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(ErrorsUtil.fieldError2Map(result.getFieldErrors()));
		}
		boolean flag = organizeUserService.organizeAddUser(req.getOrgId(), req.getUserId(), req.getOperBy());
		if (flag) {
			return ResponseData.ok();
		} else {
			return ResponseData.error("添加人员成功");
		}
	}

	/**
	 * 从组织删除人员
	 * @param req
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	public ResponseData organizeDelUser(@Valid OrganizeUserDelRequest req, BindingResult result) {
		log.info("删除组织下的人员");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(ErrorsUtil.fieldError2Map(result.getFieldErrors()));
		}
		Boolean flag = organizeUserService.organizeDelUser(req.getOrgId(), req.getUserId());
		if (flag) {
			return ResponseData.ok();
		} else {
			return ResponseData.error("删除组织下人员成功");
		}
	}

	/**
	 * 根据组织查询人员
	 * @param req
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/queryUserByOrgId", method = RequestMethod.POST)
	public ResponseData queryOrgUserByOrgId(@Valid OrganizeUserQueryByOrgIdRequest req, BindingResult result) {
		log.info("查询指定组织下的人员");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(ErrorsUtil.fieldError2Map(result.getFieldErrors()));
		}
		List<UserOrganizeDetails> list = organizeUserService.queryOrgUserByOrgId(req.getOrgId(),req.getPageNum(),req.getPageSize());
		return ResponseData.ok().data(list);
	}

}
