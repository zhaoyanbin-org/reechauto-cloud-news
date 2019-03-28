package com.reechauto.cloud.news.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.reechauto.cloud.common.resp.ResponseData;
import com.reechauto.cloud.news.bean.req.feedback.FeedbackAnswerByOperatorRequest;
import com.reechauto.cloud.news.bean.req.feedback.FeedbackQueryByOperatorRequest;
import com.reechauto.cloud.news.bean.req.feedback.FeedbackQueryByUserRequest;
import com.reechauto.cloud.news.bean.req.feedback.FeedbackQuestionRequest;
import com.reechauto.cloud.news.service.feedback.AppFeedbackService;
import com.reechauto.cloud.news.utils.ErrorsUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/feedback")
public class FeedbackController {

	@Autowired
	private AppFeedbackService AppFeedbackService;
	/**
	 * 用户查询意见反馈表
	 * @param req
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/queryFeedbacksByUserId", method = RequestMethod.POST)
	public ResponseData queryFeedbacksByUserId(@Valid FeedbackQueryByUserRequest req, BindingResult result) {
		log.info("用户查询意见反馈表");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(ErrorsUtil.fieldError2Map(result.getFieldErrors()));
		}
		ResponseData responseData = AppFeedbackService.queryFeedbacksByUserId(req.getUserId(), req.getPageNum(),
				req.getStart());
		return responseData;
	}

	/**
	 * 用户提交反馈
	 * @param req
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/addQuestion", method = RequestMethod.POST)
	public ResponseData addQuestion(@Valid FeedbackQuestionRequest req, BindingResult result) {
		log.info("用户提交反馈");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(ErrorsUtil.fieldError2Map(result.getFieldErrors()));
		}
		boolean flag = AppFeedbackService.addQuestion(req.getUserId(), req.getQuestion());
		if (!flag) {
			throw new RuntimeException("提交反馈失败");
		}
		return ResponseData.ok();
	}

	/**
	 * 操作员查询意见反馈表
	 * @param req
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/queryFeedbacksByOperator", method = RequestMethod.POST)
	public ResponseData queryFeedbacksByOperator(@Valid FeedbackQueryByOperatorRequest req, BindingResult result) {
		log.info("操作员查询意见反馈表");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(ErrorsUtil.fieldError2Map(result.getFieldErrors()));
		}
		ResponseData responseData = AppFeedbackService.queryFeedbacksByOperator(req.getOperatorId(), req.getMobileNum(),
				req.getStatus(), req.getBeginDate(), req.getEndDate(), req.getPageNum(), req.getStart());
		return responseData;
	}

	/**
	 * 操作员回复反馈
	 * @param req
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/answerQuestion", method = RequestMethod.POST)
	public ResponseData answerQuestion(@Valid FeedbackAnswerByOperatorRequest req, BindingResult result) {
		log.info("用户提交反馈");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(ErrorsUtil.fieldError2Map(result.getFieldErrors()));
		}
		boolean flag = AppFeedbackService.answerQuestion(req.getOperatorId(),req.getAppFeedbackId(),req.getContent());
		if (!flag) {
			throw new RuntimeException("回复反馈失败");
		}
		return ResponseData.ok();
	}

}
