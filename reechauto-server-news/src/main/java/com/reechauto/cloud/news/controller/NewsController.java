package com.reechauto.cloud.news.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.reechauto.cloud.common.resp.ResponseData;
import com.reechauto.cloud.news.bean.req.news.NewsModifyRequest;
import com.reechauto.cloud.news.bean.req.news.NewsPublishRequest;
import com.reechauto.cloud.news.bean.req.news.NewsQueryRequest;
import com.reechauto.cloud.news.bean.req.news.NewsShareSingleRequest;
import com.reechauto.cloud.news.service.news.NewsService;
import com.reechauto.cloud.news.utils.ErrorsUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/news")
public class NewsController {

	@Autowired
	private NewsService newsService;

	/**
	 * 发布资讯
	 * 
	 * @param req
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/push", method = RequestMethod.POST)
	public ResponseData releaseNews(@Valid NewsPublishRequest req, BindingResult result) {
		log.info("发布资讯");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(ErrorsUtil.fieldError2Map(result.getFieldErrors()));
		}
		ResponseData responseData = newsService.pushNews(req);
		return responseData;
	}

	/**
	 * 修改资讯
	 * 
	 * @param req
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public ResponseData modifyNews(@Valid NewsModifyRequest req, BindingResult result) {
		log.info("修改资讯");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(ErrorsUtil.fieldError2Map(result.getFieldErrors()));
		}
		ResponseData responseData = newsService.modifyNews(req);
		return responseData;
	}

	/**
	 * 根据条件查询资讯
	 * 
	 * @param req
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/query", method = RequestMethod.POST)
	public ResponseData queryNews(@Valid NewsQueryRequest req, BindingResult result) {
		log.info("根据条件查询资讯");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(ErrorsUtil.fieldError2Map(result.getFieldErrors()));
		}
		ResponseData responseData = newsService.queryNews(req);
		return responseData;
	}

	/**
	 * 根据动态或资讯的ID增加浏览次数
	 * 
	 * @param req
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/browse", method = RequestMethod.POST)
	public ResponseData browse(@Valid NewsShareSingleRequest req, BindingResult result) {
		log.info("根据资讯或动态的ID增加浏览次数");
		if (result.hasErrors()) {
			return ResponseData.argumentsError().data(ErrorsUtil.fieldError2Map(result.getFieldErrors()));
		}
		ResponseData responseData = newsService.browse(req.getId());
		return responseData;
	}

}
