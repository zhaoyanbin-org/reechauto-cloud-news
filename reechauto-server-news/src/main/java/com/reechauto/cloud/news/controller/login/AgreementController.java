package com.reechauto.cloud.news.controller.login;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reechauto.cloud.common.resp.ResponseData;
import com.reechauto.cloud.news.bean.req.agreement.AgreementRequest;
import com.reechauto.cloud.news.service.agreement.AgreementService;
import com.reechauto.cloud.news.utils.ErrorsUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/agreement")
public class AgreementController {
	@Autowired
	private AgreementService agreementService;

	/**
	 * 是否同意协议
	 * 
	 * @param req
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/isAgreement", method = RequestMethod.POST)
	public ResponseData isAgreement(@Valid AgreementRequest req, BindingResult result) {
		log.info("查询是否同意协议");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(ErrorsUtil.fieldError2Map(result.getFieldErrors()));
		}

		boolean flag = agreementService.isAgreement(req.getUserId());
		if (flag) {
			return ResponseData.ok("已同意");
		} else {
			return ResponseData.error("未同意协议");
		}
	}

	/**
	 * 同意协议
	 * 
	 * @param req
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/agree", method = RequestMethod.POST)
	public ResponseData agreeAgreement(@Valid AgreementRequest req, BindingResult result) {
		log.info("添加否同意协议记录");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(ErrorsUtil.fieldError2Map(result.getFieldErrors()));
		}
		boolean flag = agreementService.agreeAgreement(req.getUserId());
		if (flag) {
			return ResponseData.ok();
		} else {
			return ResponseData.error("同意协议操作失败");
		}
	}

}
