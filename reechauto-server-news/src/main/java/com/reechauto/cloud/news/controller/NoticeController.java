package com.reechauto.cloud.news.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.reechauto.cloud.common.resp.ResponseData;
import com.reechauto.cloud.news.bean.req.notice.NoticeQueryRequest;
import com.reechauto.cloud.news.bean.req.notice.NoticeReadRequest;
import com.reechauto.cloud.news.service.notice.NoticeService;
import com.reechauto.cloud.news.utils.ErrorsUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/notice")
public class NoticeController {

	@Autowired
	private NoticeService noticeServer;

	/**
	 * 查询我的消息
	 * @param req
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/query", method = RequestMethod.POST)
	public ResponseData queryNotice(@Valid NoticeQueryRequest req, BindingResult result) {
		log.info("查询我的消息");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(ErrorsUtil.fieldError2Map(result.getFieldErrors()));
		}
		ResponseData responseData = noticeServer.queryNotice(req.getUserId(), req.getStart(), req.getPageNum());
		return responseData;
	}

	/**
	 * read消息
	 * @param req
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/read", method = RequestMethod.POST)
	public ResponseData readNotice(@Valid NoticeReadRequest req, BindingResult result) {
		log.info("read消息");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(ErrorsUtil.fieldError2Map(result.getFieldErrors()));
		}
		boolean flag = noticeServer.readNotice(req.getNoticeId());
		if (flag) {
			return ResponseData.ok();
		}
		throw new RuntimeException("消息已读失败");
	}

	/**
	 * 将消息全部标记为已读
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/readAll", method = RequestMethod.POST)
	public ResponseData readAllNotice(@RequestParam("userId") Long userId) {
		log.info("将消息全部标记为已读");
		noticeServer.readAllNotice(userId);
		return ResponseData.ok();
	}

	/**
	 * 统计未读消息的个数
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/noread", method = RequestMethod.POST)
	public ResponseData noReadNotice(@RequestParam("userId") Long userId) {
		log.info("统计未读消息的个数");
		ResponseData responseData = noticeServer.countNoRead(userId);
		return responseData;
	}

}
