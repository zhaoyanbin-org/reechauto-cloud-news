package com.reechauto.cloud.news.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.reechauto.cloud.common.resp.ResponseData;
import com.reechauto.cloud.news.bean.req.news.ShareModifyRequest;
import com.reechauto.cloud.news.bean.req.news.SharePublishRequest;
import com.reechauto.cloud.news.bean.req.news.ShareQueryRequest;
import com.reechauto.cloud.news.service.news.ShareService;
import com.reechauto.cloud.news.utils.ErrorsUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/share")
public class ShareController  {

	@Autowired
	private ShareService ShareService;

	/**
	 * 发布动态
	 * @param req
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/push", method = RequestMethod.POST)
	public ResponseData releaseShare(@Valid SharePublishRequest req, BindingResult result) {
		log.info("发布动态");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(ErrorsUtil.fieldError2Map(result.getFieldErrors()));
		}
		ResponseData responseData = ShareService.pushShare(req);
		return responseData;
	}

	/**
	 * 修改动态
	 * @param req
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public ResponseData modifyShare(@Valid ShareModifyRequest req, BindingResult result) {
		log.info("修改动态");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(ErrorsUtil.fieldError2Map(result.getFieldErrors()));
		}
		ResponseData responseData = ShareService.modifyShare(req);
		return responseData;
	}

	/**
	 * 根据条件查询动态
	 * @param req
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/query", method = RequestMethod.POST)
	public ResponseData queryShare(@Valid ShareQueryRequest req, BindingResult result) {
		log.info("根据条件查询动态");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(ErrorsUtil.fieldError2Map(result.getFieldErrors()));
		}
		ResponseData responseData = ShareService.queryShare(req, false);
		return responseData;
	}

	/**
	 * 查询我的动态
	 * @param req
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/me", method = RequestMethod.POST)
	public ResponseData queryMeShare(@Valid ShareQueryRequest req, BindingResult result) {
		log.info("查询我的动态");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(ErrorsUtil.fieldError2Map(result.getFieldErrors()));
		}
		ResponseData responseData = ShareService.queryShare(req, true);
		return responseData;
	}
}
