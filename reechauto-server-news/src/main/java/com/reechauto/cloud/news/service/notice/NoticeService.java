package com.reechauto.cloud.news.service.notice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.reechauto.cloud.common.enums.NoticeTypeEnum;
import com.reechauto.cloud.common.enums.YnEnum;
import com.reechauto.cloud.common.resp.ResponseData;
import com.reechauto.cloud.common.utils.code.IdGenerator;
import com.reechauto.cloud.news.bean.response.NoticeList;
import com.reechauto.cloud.news.entity.NewsNotice;
import com.reechauto.cloud.news.entity.NewsNoticeExample;
import com.reechauto.cloud.news.entity.NewsShareComment;
import com.reechauto.cloud.news.entity.NewsShareLikes;
import com.reechauto.cloud.news.entity.NewsShareWithBLOBs;
import com.reechauto.cloud.news.mapper.NewsNoticeMapper;
import com.reechauto.cloud.news.mapper.NewsShareCommentMapper;
import com.reechauto.cloud.news.mapper.NewsShareLikesMapper;
import com.reechauto.cloud.news.mapper.NewsShareMapper;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class NoticeService {
	
	
	@Autowired
	private NewsNoticeMapper newsNoticeMapper;
	@Autowired
	private NewsShareMapper newsShareMapper;
	@Autowired
	private NewsShareCommentMapper newsShareCommentMapper;
	@Autowired
	private NewsShareLikesMapper newsShareLikesMapper;
	@Autowired
	private JdbcTemplate  reechAutoJdbcTemplate;

	public ResponseData queryNotice(Long userId, int start, int pageNum) {
		NewsNoticeExample example = new NewsNoticeExample();
		example.createCriteria().andNotifyIdEqualTo(userId);
		Long total = this.newsNoticeMapper.countByExample(example);
		example.setOrderByClause(" is_read ASC,create_time DESC");
		example.setLimitStart(start);
		example.setOffset(pageNum);
		List<NewsNotice> list = this.newsNoticeMapper.selectByExample(example);
		List<NoticeList> nlist = new ArrayList<NoticeList>();
		if (CollectionUtils.isNotEmpty(list)) {
			for (NewsNotice notice : list) {
				NoticeList nl = new NoticeList();
				BeanUtils.copyProperties(notice, nl);
				NewsShareWithBLOBs newsShare = this.newsShareMapper.selectByPrimaryKey(notice.getNewsShareId());
				nl.setNewsShare(newsShare);
				if (NoticeTypeEnum.LIKES.getValue().equals(notice.getNoticeType())) {
					NewsShareLikes newsShareLikes = this.newsShareLikesMapper
							.selectByPrimaryKey(notice.getRelationId());
					nl.setNewsShareLikes(newsShareLikes);
				}
				if (NoticeTypeEnum.COMMENT.getValue().equals(notice.getNoticeType())) {
					NewsShareComment newsShareComment = this.newsShareCommentMapper
							.selectByPrimaryKey(notice.getRelationId());
					nl.setComment(newsShareComment);
				}
				nlist.add(nl);
			}
		}

		return ResponseData.ok().data(nlist).data("total", total);
	}
	public ResponseData read(String noticeId) {
		
		boolean flag = readNotice(noticeId);;
		if(flag) {
			return ResponseData.ok();
		}
		throw new RuntimeException("消息已读失败");
	}
	
	public ResponseData countNoRead(Long userId) {
	//	Long userId = commonService.getUserIdByToken(token);
	//	return this.feignNoticeService.countNoRead(userId);
		Long num = countNotRead(userId);
		return ResponseData.ok().data(num);
	}
	
	public ResponseData readAll(Long userId) {
		//Long userId = commonService.getUserIdByToken(token);
		 readAllNotice(userId);
		 return ResponseData.ok();
	}
	
	
	

	public void addNotice(String newsShareId, String relationId, String noticeType) {
		try {
			NewsShareWithBLOBs bean = newsShareMapper.selectByPrimaryKey(newsShareId);
			if (bean != null) {
				NewsNotice record = new NewsNotice();
				record.setId(IdGenerator.uuid());
				record.setNewsShareId(newsShareId);
				record.setNoticeType(NoticeTypeEnum.get(noticeType).getValue());
				record.setNotifyId(bean.getPushUserId());
				record.setRelationId(relationId);
				this.newsNoticeMapper.insertSelective(record);
			} else {
				log.error("不存在的动态ID:" + newsShareId);
			}

		} catch (Exception ex) {
			log.error("发送通知失败：newsShareId：" + newsShareId + ",relationId：" + relationId + ",noticeType：" + noticeType);
		}
	}

	/**
	 * 通知列表
	 * 
	 * @param notifyId
	 * @param start
	 * @param pageNum
	 * @return
	 */
	

	/**
	 * 已读通知
	 * 
	 * @param id
	 * @return
	 */
	public boolean readNotice(String id) {
		NewsNotice record = this.newsNoticeMapper.selectByPrimaryKey(id);
		if (record != null) {
			record.setIsRead(YnEnum.Y.getValue());
			record.setReadTime(new Date());
			return this.newsNoticeMapper.updateByPrimaryKeySelective(record) > 0;
		}
		throw new RuntimeException("错误的ID:" + id);
	}
	
	/**
	 * 全部已读通知
	 * 
	 * @param id
	 * @return
	 */
	
	public void readAllNotice(Long notifyId) {
		
		this.reechAutoJdbcTemplate.update("update notice set is_read = ? where notify_id = ? ",YnEnum.Y.getValue(),notifyId);
		
	}
	
	/**
	 * 统计未读
	 * @param notifyId
	 * @return
	 */
	public Long countNotRead(Long notifyId) {
		NewsNoticeExample example=new NewsNoticeExample();
		example.createCriteria().andIsReadEqualTo(YnEnum.N.getValue()).andNotifyIdEqualTo(notifyId);
		return this.newsNoticeMapper.countByExample(example);
	}


}
