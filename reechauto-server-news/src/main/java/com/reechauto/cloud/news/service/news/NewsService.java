package com.reechauto.cloud.news.service.news;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.reechauto.cloud.common.resp.ResponseData;
import com.reechauto.cloud.news.bean.enums.IsTopEnum;
import com.reechauto.cloud.news.bean.enums.NewsShareEnum;
import com.reechauto.cloud.news.bean.enums.NewsShareStatusEnum;
import com.reechauto.cloud.news.bean.news.NewsShareInfo;

@Service
public class NewsService {

	@Autowired
	private NewsShareService newsShareService;

	/**
	 * 发布资讯
	 * 
	 * @param vo
	 * @return
	 */
	public boolean pushNews(Long userId, String title, String intro, String context, String imagesUrl,
			String isTope) {
		NewsShareInfo bean = new NewsShareInfo();
		bean.setTitle(title);
		bean.setIntro(intro);
		bean.setContext(context);
		bean.setImagesUrl(imagesUrl);
		if (StringUtils.isNotBlank(isTope)) {
			bean.setIsTope(IsTopEnum.get(isTope).getValue());
		} else {
			bean.setIsTope(IsTopEnum.N.getValue());
		}
		bean.setPushUserId(userId);
		bean.setIsNews(NewsShareEnum.NEWS.getValue());
		bean.setStatus(NewsShareStatusEnum.Y.getValue());

		boolean flag = newsShareService.addNewsShare(bean);
		return flag;
	}

	/**
	 * 修改资讯
	 * 
	 * @param token
	 * @param vo
	 * @return
	 */
	public boolean modifyNews(Long userId, String id, String title, String intro, String context, String imagesUrl,
			String isTope, String status) {
		NewsShareInfo bean = new NewsShareInfo();
		bean.setId(id);
		if (StringUtils.isNotBlank(title)) {
			bean.setTitle(title);
		}
		if (StringUtils.isNotBlank(intro)) {
			bean.setIntro(intro);
			;
		}
		if (StringUtils.isNotBlank(context)) {
			bean.setContext(context);
		}
		if (StringUtils.isNotBlank(imagesUrl)) {
			bean.setImagesUrl(imagesUrl);
		}
		if (StringUtils.isNotBlank(isTope)) {
			bean.setIsTope(IsTopEnum.get(isTope).getValue());
		}
		bean.setIsNews(NewsShareEnum.NEWS.getValue());
		bean.setPushUserId(userId);
		if (StringUtils.isNotBlank(status)) {
			bean.setStatus(NewsShareStatusEnum.get(status).getValue());
		}
		boolean flag = newsShareService.modifyNewsShare(bean);
		return flag;
	}

	/**
	 * 根据条件查询资讯
	 * 
	 * @param isTop
	 * @param status
	 * @param pushUserId
	 * @param createDate
	 * @param limit
	 * @param offset
	 * @return
	 */
	public ResponseData queryNews(Long userId, String status, Long pushUserId, String createDate, String isTope,
			String searchCondition, Integer pageNum, Integer start) {
		return newsShareService.queryNewsShare(userId, NewsShareEnum.NEWS.getValue(), isTope,
				NewsShareStatusEnum.get(status).getValue(), pushUserId == null ? 0 : pushUserId, createDate,
				searchCondition, start, pageNum);
	}

	/**
	 * 增加浏览次数
	 * 
	 * @param newsShareId
	 * @return
	 */
	public boolean browse(String newsShareId) {
		boolean flag = newsShareService.browse(newsShareId);
		return flag;
	}

}
