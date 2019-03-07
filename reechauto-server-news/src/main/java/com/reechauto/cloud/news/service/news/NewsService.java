package com.reechauto.cloud.news.service.news;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.reechauto.cloud.common.resp.ResponseData;
import com.reechauto.cloud.news.bean.NewsShareInfo;
import com.reechauto.cloud.news.bean.NewsShareQuery;
import com.reechauto.cloud.news.bean.enums.IsTopEnum;
import com.reechauto.cloud.news.bean.enums.NewsShareEnum;
import com.reechauto.cloud.news.bean.enums.NewsShareStatusEnum;
import com.reechauto.cloud.news.bean.req.news.NewsModifyRequest;
import com.reechauto.cloud.news.bean.req.news.NewsPublishRequest;
import com.reechauto.cloud.news.bean.req.news.NewsQueryRequest;

@Service
public class NewsService {
	
	@Autowired
	private NewsShareService  newsShareService;

	public ResponseData pushNews( NewsPublishRequest vo) {
		NewsShareInfo bean = new NewsShareInfo();
		bean.setTitle(vo.getTitle());
		bean.setIntro(vo.getIntro());
		bean.setContext(vo.getContext());
		bean.setImagesUrl(vo.getImagesUrl());
		if (StringUtils.isNotBlank(vo.getIsTope())) {
			bean.setIsTope(IsTopEnum.get(vo.getIsTope()).getValue());
		} else {
			bean.setIsTope(IsTopEnum.N.getValue());
		}
		bean.setPushUserId(vo.getUserId());
		bean.setIsNews(NewsShareEnum.NEWS.getValue());
		bean.setStatus(NewsShareStatusEnum.Y.getValue());

		boolean flag = newsShareService.addNewsShare(bean);
		if (!flag) {
			throw new RuntimeException("发布资讯失败");
		}
		return  ResponseData.ok();
		
	}

	/**
	 * 修改资讯
	 * 
	 * @param token
	 * @param vo
	 * @return
	 */
	public ResponseData modifyNews( NewsModifyRequest vo) {
		NewsShareInfo bean = new NewsShareInfo();
		bean.setId(vo.getId());
		if (StringUtils.isNotBlank(vo.getTitle())) {
			bean.setTitle(vo.getTitle());
		}
		if (StringUtils.isNotBlank(vo.getIntro())) {
			bean.setIntro(vo.getIntro());
		}
		if (StringUtils.isNotBlank(vo.getContext())) {
			bean.setContext(vo.getContext());
		}
		if (StringUtils.isNotBlank(vo.getImagesUrl())) {
			bean.setImagesUrl(vo.getImagesUrl());
		}
		if (StringUtils.isNotBlank(vo.getIsTope())) {
			bean.setIsTope(IsTopEnum.get(vo.getIsTope()).getValue());
		}
		bean.setIsNews(NewsShareEnum.NEWS.getValue());
		bean.setPushUserId(vo.getUserId());
		if (StringUtils.isNotBlank(vo.getStatus())) {
			bean.setStatus(NewsShareStatusEnum.get(vo.getStatus()).getValue());
		}

		boolean flag =  newsShareService.modifyNewsShare(bean);
		
		if (!flag) {
			throw new RuntimeException("修改资讯失败");
		}
		return ResponseData.ok();
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
	public ResponseData queryNews( NewsQueryRequest vo) {
		NewsShareQuery bean = new NewsShareQuery();
		bean.setIsNews(NewsShareEnum.NEWS.getValue());
		bean.setStart(vo.getStart());
		bean.setPageNum(vo.getPageNum());
		if(StringUtils.isNotBlank(vo.getCreateDate()))
		{
		  bean.setCreateDate(vo.getCreateDate());
		}
		if(vo.getPushUserId()!=null&&vo.getPushUserId()>0) {
			bean.setPushUserId(vo.getPushUserId());
		}
		if(StringUtils.isNotBlank(vo.getSearchCondition())) {
			bean.setSearchCondition(vo.getSearchCondition());
		}
		if(StringUtils.isNotBlank(vo.getStatus()))
		{
		 bean.setStatus(NewsShareStatusEnum.get(vo.getStatus()).getValue());
		}
		bean.setUserId(vo.getUserId());
		return newsShareService.queryNewsShare(bean.getUserId(),bean.getIsNews(), bean.getIsTope(), bean.getStatus(), bean.getPushUserId()==null?0:bean.getPushUserId(), bean.getCreateDate(),bean.getSearchCondition(), bean.getStart(), bean.getPageNum());
	}
	
	/**
	 * 增加浏览次数
	 * @param newsShareId
	 * @return
	 */
	public ResponseData browse(String newsShareId) {
		boolean flag = newsShareService.browse(newsShareId);
		if(flag) {
			return  ResponseData.ok();
		}
		throw new RuntimeException("增加浏览次数失败");
	}

	
}
