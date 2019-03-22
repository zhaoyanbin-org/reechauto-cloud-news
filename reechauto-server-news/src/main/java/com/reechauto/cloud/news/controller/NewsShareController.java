package com.reechauto.cloud.news.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.reechauto.cloud.common.resp.ResponseData;
import com.reechauto.cloud.news.bean.req.news.LikesUsersQueryRequest;
import com.reechauto.cloud.news.bean.req.news.NewsShareLikesRequest;
import com.reechauto.cloud.news.bean.req.news.NewsShareSingleRequest;
import com.reechauto.cloud.news.bean.req.news.NewsShareTopQueryRequest;
import com.reechauto.cloud.news.service.news.NewsShareService;
import com.reechauto.cloud.news.utils.ErrorsUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/newsshare")
/**
 * 动态资讯公共接口
 * 
 * @author DELL
 *
 */
public class NewsShareController {

	@Autowired
	private NewsShareService newsShareService;

	/**
	 * 查询推荐
	 * 
	 * @param req
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/top", method = RequestMethod.POST)
	public ResponseData releaseNews(@Valid NewsShareTopQueryRequest req, BindingResult result) {
		log.info("查询推荐");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(ErrorsUtil.fieldError2Map(result.getFieldErrors()));
		}
		ResponseData responseData = newsShareService.queryNewsShareTop(req);
		return responseData;
	}

	/**
	 * 根据ID查询单条资讯或动态
	 * 
	 * @param req
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/single", method = RequestMethod.POST)
	public ResponseData querySingleNews(@Valid NewsShareSingleRequest req, BindingResult result) {
		log.info("根据ID查询单条资讯或动态");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(ErrorsUtil.fieldError2Map(result.getFieldErrors()));
		}
		ResponseData responseData = newsShareService.querySingleNewsShare(req.getId());
		return responseData;
	}

	/**
	 * 点赞
	 * 
	 * @param req
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/addlikes", method = RequestMethod.POST)
	public ResponseData addLikes(@Valid NewsShareLikesRequest req, BindingResult result) {
		log.info("点赞");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(ErrorsUtil.fieldError2Map(result.getFieldErrors()));
		}
		ResponseData responseData = newsShareService.addLikes(req.getUserId(), req.getNewsShareId());
		return responseData;
	}

	/**
	 * 取消点赞
	 * 
	 * @param req
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/removeLikes", method = RequestMethod.POST)
	public ResponseData removeLikes(@Valid NewsShareLikesRequest req, BindingResult result) {
		log.info("取消点赞");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(ErrorsUtil.fieldError2Map(result.getFieldErrors()));
		}
		ResponseData responseData = newsShareService.removeLikes(req.getUserId(), req.getNewsShareId());
		return responseData;
	}

	/**
	 * 查询点赞人员
	 * 
	 * @param req
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/queryLikesUsers", method = RequestMethod.POST)
	public ResponseData queryLikesUsers(@Valid LikesUsersQueryRequest req, BindingResult result) {
		log.info("查询点赞人员");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(ErrorsUtil.fieldError2Map(result.getFieldErrors()));
		}
		ResponseData responseData = newsShareService.queryLikesNum(req.getNewsShareId(), req.getStart(),
				req.getPageNum());
		return responseData;
	}

	/**
	 * 删除动态
	 * @param req
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/del", method = RequestMethod.POST)
	public ResponseData delComment(@Valid NewsShareSingleRequest req, BindingResult result) {
		log.info("删除动态");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(ErrorsUtil.fieldError2Map(result.getFieldErrors()));
		}
		ResponseData responseData = newsShareService.delNewsShare(req.getId());
		return responseData;
	}

}
