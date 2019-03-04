package com.reechauto.cloud.news.service.news;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reechauto.cloud.common.enums.IsTopEnum;
import com.reechauto.cloud.common.enums.NewsShareEnum;
import com.reechauto.cloud.common.enums.NewsShareStatusEnum;
import com.reechauto.cloud.common.resp.ResponseData;
import com.reechauto.cloud.common.utils.json.JsonUtils;
import com.reechauto.cloud.news.bean.NewsShareInfo;
import com.reechauto.cloud.news.bean.NewsShareQuery;
import com.reechauto.cloud.news.bean.req.news.ShareModifyRequest;
import com.reechauto.cloud.news.bean.req.news.SharePublishRequest;
import com.reechauto.cloud.news.bean.req.news.ShareQueryRequest;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class ShareService {

	@Autowired
	private NewsShareService  newsShareService;
	
	public ResponseData pushShare(SharePublishRequest vo) {
		NewsShareInfo bean = new NewsShareInfo();
		bean.setTitle(vo.getContext());
		bean.setImagesUrl(vo.getImagesUrl());
		bean.setIsNews(NewsShareEnum.SHARE.getValue());
		bean.setPushUserId(vo.getUserId());
		bean.setStatus(NewsShareStatusEnum.Y.getValue());
		boolean flag = newsShareService.addNewsShare(bean);
		if (!flag) {
			throw new RuntimeException("发布动态失败");
		}
		return ResponseData.ok();
	}

	/**
	 * 修改动态
	 * 
	 * @param token
	 * @param vo
	 * @return
	 */
	public ResponseData modifyShare(ShareModifyRequest vo) {
		NewsShareInfo bean = new NewsShareInfo();
		bean.setId(vo.getId());
		if (StringUtils.isNotBlank(vo.getContext())) {
			bean.setTitle(vo.getContext());
		}
		if (StringUtils.isNotBlank(vo.getImagesUrl())) {
			bean.setImagesUrl(vo.getImagesUrl());
		}
		if(StringUtils.isNotBlank(vo.getIsTope())) {
			bean.setIsTope(IsTopEnum.get(vo.getIsTope()).getValue());
		}
		if(StringUtils.isNotBlank(vo.getStatus())) {
			bean.setIsTope(NewsShareStatusEnum.get(vo.getStatus()).getValue());
		}
		bean.setIsNews(NewsShareEnum.SHARE.getValue());
		bean.setPushUserId(vo.getUserId());
	//	return feignNewsShareService.modifyNewsShare(bean);
		log.info(JsonUtils.toJson(bean));
		boolean flag = newsShareService.modifyNewsShare(bean);
		if (!flag) {
			throw new RuntimeException("修改动态失败");
		}
		return ResponseData.ok();
	}

	/**
	 * 查询动态
	 * 
	 * @param isTop
	 * @param status
	 * @param pushUserId
	 * @param createDate
	 * @param limit
	 * @param offset
	 * @return
	 */
	public ResponseData queryShare(ShareQueryRequest vo, boolean currentUser) {
		NewsShareQuery bean = new NewsShareQuery();
		bean.setIsNews(NewsShareEnum.SHARE.getValue());
		bean.setStart(vo.getStart());
		bean.setPageNum(vo.getPageNum());
		bean.setStatus(vo.getStatus());
		if (currentUser) {
			bean.setPushUserId(vo.getUserId());
		}
		bean.setSearchCondition(vo.getSearchCondition());
		bean.setUserId(vo.getUserId());
		return newsShareService.queryNewsShare(bean.getUserId(),bean.getIsNews(), bean.getIsTope(), bean.getStatus(), bean.getPushUserId()==null?0:bean.getPushUserId(), bean.getCreateDate(),bean.getSearchCondition(), bean.getStart(), bean.getPageNum());
	}
	
}
