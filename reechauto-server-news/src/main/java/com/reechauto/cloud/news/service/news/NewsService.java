package com.reechauto.cloud.news.service.news;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.reechauto.cloud.common.resp.ResponseData;
import com.reechauto.cloud.news.bean.enums.IsTopEnum;
import com.reechauto.cloud.news.bean.enums.NewsShareEnum;
import com.reechauto.cloud.news.bean.enums.NewsShareStatusEnum;
import com.reechauto.cloud.news.bean.news.NewsShareInfo;
import com.reechauto.cloud.news.bean.news.NewsShareQuery;
import com.reechauto.cloud.news.bean.req.news.NewsModifyRequest;
import com.reechauto.cloud.news.bean.req.news.NewsPublishRequest;
import com.reechauto.cloud.news.bean.req.news.NewsQueryRequest;

@Service
public class NewsService {
	
	@Autowired
	private NewsShareService  newsShareService;
  
	/**
             * 发布资讯
     * @param vo
     * @return
     */
	public ResponseData pushNews( Long userId,String title,String intro,String context,String imagesUrl,String isTope) {
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
	public ResponseData modifyNews( Long userId,String id,String title,String intro,String context,String imagesUrl,String isTope
			,String status) {
		NewsShareInfo bean = new NewsShareInfo();
		bean.setId(id);
		if (StringUtils.isNotBlank(title)) {
			bean.setTitle(title);
		}
		if (StringUtils.isNotBlank(intro)) {
			bean.setIntro(intro);;
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
