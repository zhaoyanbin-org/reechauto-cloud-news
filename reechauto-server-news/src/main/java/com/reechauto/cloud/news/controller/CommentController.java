package com.reechauto.cloud.news.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reechauto.cloud.common.resp.ResponseData;
import com.reechauto.cloud.news.bean.req.comment.CommentAddRequest;
import com.reechauto.cloud.news.bean.req.comment.CommentDelRequest;
import com.reechauto.cloud.news.bean.req.comment.CommentModifyRequest;
import com.reechauto.cloud.news.bean.req.comment.CommentQueryRequest;
import com.reechauto.cloud.news.bean.req.notice.NoticeQueryRequest;
import com.reechauto.cloud.news.service.comment.CommentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/comment")
public class CommentController extends BaseController {

	@Autowired
	private CommentService commentService;

	// 发表评论
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseData addComment(@Valid CommentAddRequest req, BindingResult result) {
		log.info("发表评论");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(result.getAllErrors());
		}
		ResponseData responseData = commentService.addComment(req.getUserId(), req.getNewsShareId(),
				req.getCommentContext());
		return responseData;
	}

	// 修改评论
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public ResponseData modifyComment(@Valid CommentModifyRequest req, BindingResult result) {
		log.info("修改评论");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(result.getAllErrors());
		}
		ResponseData responseData = commentService.modifyComment(req.getId(), req.getCommentContext());
		return responseData;
	}

	// 删除评论
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	public ResponseData delComment(@Valid CommentDelRequest req, BindingResult result) {
		log.info("删除评论");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(result.getAllErrors());
		}
		ResponseData responseData = commentService.delComment(req.getId());
		return responseData;
	}

	// 查询评论
	@RequestMapping(value = "/query", method = RequestMethod.POST)
	public ResponseData queryComment(@Valid CommentQueryRequest req, BindingResult result) {
		log.info("查询评论");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(result.getAllErrors());
		}
		ResponseData responseData = commentService.queryByNewsShareId(req.getNewsShareId());
		return responseData;
	}
}
