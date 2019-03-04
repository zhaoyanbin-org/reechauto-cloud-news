package com.reechauto.cloud.news.service.comment;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reechauto.cloud.common.enums.CommentStatusEnum;
import com.reechauto.cloud.common.exception.DataEmptyException;
import com.reechauto.cloud.common.resp.ResponseData;
import com.reechauto.cloud.common.utils.code.IdGenerator;
import com.reechauto.cloud.news.entity.NewsShareComment;
import com.reechauto.cloud.news.entity.NewsShareCommentExample;
import com.reechauto.cloud.news.entity.UserDetails;
import com.reechauto.cloud.news.mapper.NewsShareCommentMapper;
import com.reechauto.cloud.news.mapper.UserDetailsMapper;
import com.reechauto.cloud.news.service.notice.NoticeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CommentService {

	@Autowired
	private UserDetailsMapper userDetailsMapper;
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private NewsShareCommentMapper newsShareCommentMapper;

	public ResponseData addComment(Long userId, String newsShareId, String commentContext) {

		log.info("newsShareId:" + newsShareId);
		UserDetails userDetails = userDetailsMapper.selectByPrimaryKey(userId);
		if (userDetails == null) {
			throw new DataEmptyException(userId + "对应用户不存在");
		}
		NewsShareComment record = new NewsShareComment();
		String id = IdGenerator.uuid();
		record.setId(id);
		record.setCommentContext(commentContext);
		record.setCommentUserId(userId);
		record.setCommentUserNickName(userDetails.getNickName());
		record.setCommentUserHeadPortraitUrl(userDetails.getImgUrl());
		record.setNewsShareId(newsShareId);
		boolean flag = this.newsShareCommentMapper.insertSelective(record) > 0;
		if (!flag) {
			throw new RuntimeException("发表评论失败");
		}
		// 发送通知
		noticeService.addNotice(newsShareId, id, "comment");
		return ResponseData.ok();
	}

	public ResponseData modifyComment(String id, String commentContext) {
			NewsShareComment record = this.newsShareCommentMapper.selectByPrimaryKey(id);
			record.setModifyTime(new Date());
			record.setCommentContext(commentContext);
			boolean flag = this.newsShareCommentMapper.updateByPrimaryKeySelective(record) > 0;
			if (!flag) {
				throw new RuntimeException("更新评论失败");
			}
			return ResponseData.ok();
	}

	public ResponseData delComment(String id) {
			NewsShareComment record = this.newsShareCommentMapper.selectByPrimaryKey(id);
			record.setModifyTime(new Date());
			record.setCommentStatus(CommentStatusEnum.N.getValue());
			boolean flag = this.newsShareCommentMapper.updateByPrimaryKeySelective(record) > 0;
			if (!flag) {
				throw new RuntimeException("删除评论失败");
			}
			return ResponseData.ok();
	}

	public ResponseData queryByNewsShareId(String newsShareId) {
		
			NewsShareCommentExample example = new NewsShareCommentExample();
			example.createCriteria().andCommentStatusEqualTo(CommentStatusEnum.Y.getValue())
					.andNewsShareIdEqualTo(newsShareId);
			example.setOrderByClause(" create_time desc");
			List<NewsShareComment> list = this.newsShareCommentMapper.selectByExample(example);
			return ResponseData.ok().data(list);
		} 
}
