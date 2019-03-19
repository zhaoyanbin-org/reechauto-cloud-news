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
			return ResponseData.argumentsError().data(result.getAllErrors());
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
			return ResponseData.argumentsError().data(result.getAllErrors());
		}
		ResponseData responseData = noticeServer.read(req.getNoticeId());
		return responseData;
	}

	/**
	 * 将消息全部标记为已读
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/readAll", method = RequestMethod.POST)
	public ResponseData readAllNotice(@RequestParam("userId") Long userId) {
		log.info("将消息全部标记为已读");
		ResponseData responseData = noticeServer.readAll(userId);
		return responseData;
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
