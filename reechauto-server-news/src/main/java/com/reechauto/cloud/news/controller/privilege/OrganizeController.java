package com.reechauto.cloud.news.controller.privilege;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reechauto.cloud.common.resp.ResponseData;
import com.reechauto.cloud.news.bean.organize.SysOrganizeBean;
import com.reechauto.cloud.news.bean.req.privilege.OrganizeAddRequest;
import com.reechauto.cloud.news.bean.req.privilege.OrganizeDelByOrgIdRequest;
import com.reechauto.cloud.news.bean.req.privilege.OrganizeDelByParentOrgIdRequest;
import com.reechauto.cloud.news.bean.req.privilege.OrganizeModifyRequest;
import com.reechauto.cloud.news.bean.req.privilege.OrganizeQueryByOrgIdRequest;
import com.reechauto.cloud.news.bean.req.privilege.OrganizeQueryByParentOrgIdRequest;
import com.reechauto.cloud.news.service.privilege.OrganizeService;
import com.reechauto.cloud.news.utils.ErrorsUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/organize")
public class OrganizeController {
	@Autowired
	private OrganizeService organizeService;

	/**
	 * 新增组织
	 * 
	 * @param req
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseData addOrganize(@Valid OrganizeAddRequest req, BindingResult result) {
		log.info("新增组织");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(ErrorsUtil.fieldError2Map(result.getFieldErrors()));
		}
		boolean flag = organizeService.addOrganize(req.getOrgName(), req.getParentOrgId(), req.getSort());
		if (flag) {
			return ResponseData.ok();
		} else {
			return ResponseData.error("添加组织失败");
		}
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public ResponseData modifyOrganize(@Valid OrganizeModifyRequest req, BindingResult result) {
		log.info("修改组织信息");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(ErrorsUtil.fieldError2Map(result.getFieldErrors()));
		}
		boolean flag = organizeService.updateOrganizeByOrgId(req.getOrgId(), req.getOrgName(), req.getParentOrgId(),
				req.getSort());
		if (flag) {
			return ResponseData.ok();
		} else {
			return ResponseData.error("修改组织失败");
		}
	}

	@RequestMapping(value = "/delOrgById", method = RequestMethod.POST)
	public ResponseData delOrganizeById(@Valid OrganizeDelByOrgIdRequest req, BindingResult result) {
		log.info("删除组织及其子组织");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(ErrorsUtil.fieldError2Map(result.getFieldErrors()));
		}
		organizeService.delOrg(req.getOrgId());
		return ResponseData.ok();
	}

	@RequestMapping(value = "/delOrgByParentId", method = RequestMethod.POST)
	public ResponseData delOrganizeByParentId(@Valid OrganizeDelByParentOrgIdRequest req, BindingResult result) {
		log.info("按parentOrgId删除组织");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(ErrorsUtil.fieldError2Map(result.getFieldErrors()));
		}
		organizeService.delOrgByParentOrgId(req.getParentOrgId());
		return ResponseData.ok();
	}

	@RequestMapping(value = "/queryOrgById", method = RequestMethod.POST)
	public ResponseData queryOrganizeById(@Valid OrganizeQueryByOrgIdRequest req, BindingResult result) {
		log.info("按组织Id查询组织及其子组织");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(ErrorsUtil.fieldError2Map(result.getFieldErrors()));
		}
		SysOrganizeBean bean = organizeService.queryOrgByOrgId(req.getOrgId(), req.isAll());
		return ResponseData.ok().data(bean);
	}

	@RequestMapping(value = "/queryOrgByParentId", method = RequestMethod.POST)
	public ResponseData queryOrganizeByParentId(@Valid OrganizeQueryByParentOrgIdRequest req, BindingResult result) {
		log.info("按组织父Id查询组织");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(ErrorsUtil.fieldError2Map(result.getFieldErrors()));
		}
		List<SysOrganizeBean> list = organizeService.queryOrgByParentOrgId(req.getParentOrgId(), req.isAll());
		return ResponseData.ok().data(list);
	}

}
