package com.reechauto.cloud.news.controller.login;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reechauto.cloud.common.resp.ResponseData;
import com.reechauto.cloud.news.bean.req.agreement.AgreementRequest;
import com.reechauto.cloud.news.service.agreement.AgreementService;

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
	public ResponseData isAgreement(@Valid AgreementRequest req, BindingResult result) {
		log.info("查询是否同意协议");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(result.getAllErrors());
		}

		boolean flag = agreementService.isAgreement(req.getUserId());
		return ResponseData.ok().data(flag);
	}

	/**
	 * 同意协议
	 * 
	 * @param req
	 * @param result
	 * @return
	 */
	public ResponseData agreeAgreement(@Valid AgreementRequest req, BindingResult result) {
		log.info("添加否同意协议记录");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(result.getAllErrors());
		}

		boolean flag = agreementService.agreeAgreement(req.getUserId());
		return ResponseData.ok().data(flag);
	}

}
