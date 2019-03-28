package com.reechauto.cloud.news.service.news;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.runner.ReactiveWebApplicationContextRunner;
import org.springframework.stereotype.Service;
import com.reechauto.cloud.common.resp.ResponseData;
import com.reechauto.cloud.common.utils.json.JsonUtils;
import com.reechauto.cloud.news.bean.enums.IsTopEnum;
import com.reechauto.cloud.news.bean.enums.NewsShareEnum;
import com.reechauto.cloud.news.bean.enums.NewsShareStatusEnum;
import com.reechauto.cloud.news.bean.news.NewsShareInfo;
import com.reechauto.cloud.news.bean.news.NewsShareQuery;
import com.reechauto.cloud.news.bean.req.news.ShareModifyRequest;
import com.reechauto.cloud.news.bean.req.news.SharePublishRequest;
import com.reechauto.cloud.news.bean.req.news.ShareQueryRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ShareService {

	@Autowired
	private NewsShareService newsShareService;

	/**
	 * 发布动态
	 * 
	 * @param vo
	 * @return
	 */
	public boolean pushShare(Long userId, String context, String imagesUrl) {
		NewsShareInfo bean = new NewsShareInfo();
		bean.setTitle(context);
		bean.setImagesUrl(imagesUrl);
		bean.setIsNews(NewsShareEnum.SHARE.getValue());
		bean.setPushUserId(userId);
		bean.setStatus(NewsShareStatusEnum.Y.getValue());
		boolean flag = newsShareService.addNewsShare(bean);
		return flag;
	}

	/**
	 * 修改动态
	 * 
	 * @param token
	 * @param vo
	 * @return
	 */
	public boolean modifyShare(Long userId, String id, String isTope, String status, String context, String imagesUrl) {
		NewsShareInfo bean = new NewsShareInfo();
		bean.setId(id);
		if (StringUtils.isNotBlank(context)) {
			bean.setTitle(context);
		}
		if (StringUtils.isNotBlank(imagesUrl)) {
			bean.setImagesUrl(imagesUrl);
		}
		if (StringUtils.isNotBlank(isTope)) {
			bean.setIsTope(IsTopEnum.get(isTope).getValue());
		}
		if (StringUtils.isNotBlank(status)) {
			bean.setIsTope(NewsShareStatusEnum.get(status).getValue());
		}
		bean.setIsNews(NewsShareEnum.SHARE.getValue());
		bean.setPushUserId(userId);
		log.info(JsonUtils.toJson(bean));
		boolean flag = newsShareService.modifyNewsShare(bean);
		return flag;
	}

	/**
	 * 根据条件查询动态
	 * 
	 * @param isTop
	 * @param status
	 * @param pushUserId
	 * @param createDate
	 * @param limit
	 * @param offset
	 * @return
	 */
	public ResponseData queryShare(Long userId, String searchCondition, Integer pageNum, Integer start, String status,
			boolean currentUser) {
		return newsShareService.queryNewsShare(userId, NewsShareEnum.SHARE.getValue(), null, status,
				currentUser == true ? userId : 0, null, searchCondition, start, pageNum);
	}

}
