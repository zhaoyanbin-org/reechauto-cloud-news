package com.reechauto.cloud.news.service.news;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import com.reechauto.cloud.common.exception.DataEmptyException;
import com.reechauto.cloud.common.resp.ResponseData;
import com.reechauto.cloud.common.utils.code.IdGenerator;
import com.reechauto.cloud.common.utils.date.DateUtil;
import com.reechauto.cloud.common.utils.json.JsonUtils;
import com.reechauto.cloud.news.bean.enums.CommentStatusEnum;
import com.reechauto.cloud.news.bean.enums.IsTopEnum;
import com.reechauto.cloud.news.bean.enums.NewsShareEnum;
import com.reechauto.cloud.news.bean.enums.NewsShareStatusEnum;
import com.reechauto.cloud.news.bean.news.NewsShareBean;
import com.reechauto.cloud.news.bean.news.NewsShareInfo;
import com.reechauto.cloud.news.bean.news.NewsShareQuery;
import com.reechauto.cloud.news.bean.req.news.NewsShareTopQueryRequest;
import com.reechauto.cloud.news.entity.NewsShare;
import com.reechauto.cloud.news.entity.NewsShareCommentExample;
import com.reechauto.cloud.news.entity.NewsShareExample;
import com.reechauto.cloud.news.entity.NewsShareLikes;
import com.reechauto.cloud.news.entity.NewsShareLikesExample;
import com.reechauto.cloud.news.entity.NewsShareWithBLOBs;
import com.reechauto.cloud.news.entity.SysMenu;
import com.reechauto.cloud.news.entity.UserDetails;
import com.reechauto.cloud.news.entity.NewsShareExample.Criteria;
import com.reechauto.cloud.news.mapper.NewsShareCommentMapper;
import com.reechauto.cloud.news.mapper.NewsShareLikesMapper;
import com.reechauto.cloud.news.mapper.NewsShareMapper;
import com.reechauto.cloud.news.mapper.UserDetailsMapper;
import com.reechauto.cloud.news.service.notice.NoticeService;
import com.reechauto.cloud.news.utils.HtmlFilter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NewsShareService {

	@Autowired
	private NewsShareMapper newsShareMapper;
	@Autowired
	private UserDetailsMapper userDetailsMapper;
	@Autowired
	private NewsShareLikesMapper newsShareLikesMapper;
	@Autowired
	private NewsShareCommentMapper newsShareCommentMapper;
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * 发布资讯或动态
	 * 
	 * @param bean
	 * @return
	 */
	public boolean addNewsShare(NewsShareInfo bean) {
		// 1:查询发布人
		UserDetails pushUser = this.userDetailsMapper.selectByPrimaryKey(bean.getPushUserId());
		if (pushUser == null) {
			throw new DataEmptyException("PushUser is empty !");
		}

		NewsShareWithBLOBs record = new NewsShareWithBLOBs();
		record.setId(IdGenerator.uuid());
		// 发布人信息
		record.setPushUserId(pushUser.getUserId());
		record.setPushUserNick(pushUser.getNickName());
		record.setPushUserHeadPortraitUrl(pushUser.getImgUrl());
		if (StringUtils.isNotBlank(bean.getContext())) {
			record.setContext(bean.getContext());
		}
		if (StringUtils.isNotBlank(bean.getContextTxt())) {
			record.setContextTxt(bean.getContextTxt());
		}
		if (StringUtils.isNotBlank(bean.getImagesUrl())) {
			record.setImagesUrl(bean.getImagesUrl());
		}
		if (StringUtils.isNotBlank(bean.getIntro())) {
			record.setIntro(bean.getIntro());
		}
		if (StringUtils.isNotBlank(bean.getTitle())) {
			record.setTitle(bean.getTitle());
		}
		if (StringUtils.isNotBlank(bean.getIsNews())) {
			record.setIsNews(NewsShareEnum.get(bean.getIsNews()).getValue());
		}
		if (StringUtils.isNotBlank(bean.getIsTope())) {
			record.setIsTope(IsTopEnum.get(bean.getIsTope()).getValue());
		}

		return this.newsShareMapper.insertSelective(record) > 0;
	}

	public boolean modifyNewsShare(NewsShareInfo bean) {
		NewsShareWithBLOBs record = this.newsShareMapper.selectByPrimaryKey(bean.getId());
		if (record == null) {
			throw new RuntimeException("Parameter 'id' does not exist ");
		}
		record.setModifyTime(new Date());
		if (StringUtils.isNotBlank(bean.getIsTope())) {
			record.setIsTope(IsTopEnum.get(bean.getIsTope()).getValue());
		}
		if (StringUtils.isNotBlank(bean.getStatus())) {
			record.setStatus(NewsShareStatusEnum.get(bean.getStatus()).getValue());
		}
		if (bean.getBrowseNum() != null && bean.getBrowseNum() > 0) {
			record.setBrowseNum(record.getBrowseNum() + bean.getBrowseNum());
		}
		if (StringUtils.isNotBlank(bean.getContext())) {
			record.setContext(bean.getContext());
		}
		if (StringUtils.isNotBlank(bean.getContextTxt())) {
			record.setContextTxt(HtmlFilter.delHtmlTag(bean.getContextTxt()));
		}
		if (StringUtils.isNotBlank(bean.getIntro())) {
			record.setIntro(bean.getIntro());
		}
		if (StringUtils.isNotBlank(bean.getTitle())) {
			record.setTitle(bean.getTitle());
		}
		if (StringUtils.isNotBlank(bean.getImagesUrl())) {
			record.setImagesUrl(bean.getImagesUrl());
		}
		if (bean.getLikeNum() != null && bean.getLikeNum() == -1) {
			record.setLikeNum(record.getLikeNum() - 1);
		}
		if (bean.getLikeNum() != null && bean.getLikeNum() == 1) {
			record.setLikeNum(record.getLikeNum() + 1);
		}
		return this.newsShareMapper.updateByPrimaryKeySelective(record) > 0;
	}

	/**
	 * 根据条件查询资讯或动态
	 * 
	 * @param userId
	 * @param isNews
	 * @param isTop
	 * @param status
	 * @param pushUserId
	 * @param createDate
	 * @param SearchCondition
	 * @param start
	 * @param pageNum
	 * @return
	 */
	public ResponseData queryNewsShare(Long userId, String isNews, String isTop, String status, Long pushUserId,
			String createDate, String SearchCondition, int start, int pageNum) {
		NewsShareExample example = new NewsShareExample();
		Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(isNews)) {
			criteria.andIsNewsEqualTo(NewsShareEnum.get(isNews).getValue());
		}
		if (StringUtils.isNotBlank(isTop)) {
			criteria.andIsTopeEqualTo(IsTopEnum.get(isTop).getValue());
		}
		if (StringUtils.isNotBlank(status)) {
			criteria.andStatusEqualTo(NewsShareStatusEnum.get(status).getValue());
		}
		if (pushUserId != null && pushUserId > 0) {
			criteria.andPushUserIdEqualTo(pushUserId);
		}
		if (StringUtils.isNotBlank(createDate)) {
			criteria.andCreateTimeGreaterThanOrEqualTo(DateUtil.convert2Date(createDate, "yyyy-MM-dd"))
					.andCreateTimeLessThan(DateUtil.addDays(DateUtil.convert2Date(createDate, "yyyy-MM-dd"), 1));
		}
		if (StringUtils.isNotBlank(SearchCondition)) {
			criteria.andTitleLike("%" + SearchCondition + "%");
		}
		Long total = this.newsShareMapper.countByExample(example);
		example.setOrderByClause(" create_time Desc");
		example.setOffset(pageNum);
		example.setLimitStart(start);
		List<NewsShareWithBLOBs> list = this.newsShareMapper.selectByExampleWithBLOBs(example);
		List<NewsShareBean> nlist = new ArrayList<NewsShareBean>();
		if (CollectionUtils.isNotEmpty(list)) {
			for (NewsShareWithBLOBs bean : list) {
				NewsShareBean vo = new NewsShareBean();
				BeanUtils.copyProperties(bean, vo);
				int commentNum = queryCommentNum(bean.getId());
				vo.setCommentNum(commentNum);
				boolean flag = isHasLikes(bean.getId(), userId);
				vo.setHasLike(flag);
				nlist.add(vo);
			}
		}
		return ResponseData.ok().data(nlist).data("total", total);
	}

	/**
	 * 根据ID查询资讯
	 * 
	 * @param id
	 * @return
	 */
	public ResponseData singleNewsShare(String id) {
		NewsShareWithBLOBs recod = this.newsShareMapper.selectByPrimaryKey(id);
		return ResponseData.ok().data(recod);
	}
	
	/**
	 * 根据搜索内容查询动态或资讯
	 * 
	 * @param id
	 * @return
	 */
	public ResponseData searchNewsShare(Long userId,String context,Integer start,Integer pageNum) {
		String sql = "SELECT * from news_share where ((context  like ? or title like ?) and is_news = 'share' or (context_txt  like ? or title like ?) and is_news = 'news') and status = 'Y'   order by create_time DESC limit ?,? ";
		Object[] param = new Object[6];
		param[0] = "%"+context.trim()+"%";
		param[1] = "%"+context.trim()+"%";
		param[2] = "%"+context.trim()+"%";
		param[3] = "%"+context.trim()+"%";
		param[4] = start;
		param[5] = pageNum;
		RowMapper<NewsShareWithBLOBs> rowMapper = new BeanPropertyRowMapper<NewsShareWithBLOBs>(NewsShareWithBLOBs.class);
		List<NewsShareWithBLOBs> list = this.jdbcTemplate.query(sql, rowMapper,param);
		List<NewsShareBean> nlist = new ArrayList<NewsShareBean>();
		if (CollectionUtils.isNotEmpty(list)) {
			for (NewsShareWithBLOBs bean : list) {
				NewsShareBean vo = new NewsShareBean();
				BeanUtils.copyProperties(bean, vo);
				int commentNum = queryCommentNum(bean.getId());
				vo.setCommentNum(commentNum);
				boolean flag = isHasLikes(bean.getId(), userId);
				vo.setHasLike(flag);
				nlist.add(vo);
			}
		}
		String sql1 = "SELECT count(*) from news_share where ((context  like ? or title like ?) and is_news = 'share' or (context_txt  like ? or title like ?) and is_news = 'news') and status = 'Y'  ";
		Object[] param1 = new Object[4];
		param1[0] = "%"+context.trim()+"%";
		param1[1] = "%"+context.trim()+"%";
		param1[2] = "%"+context.trim()+"%";
		param1[3] = "%"+context.trim()+"%";
		Long total = this.jdbcTemplate.queryForObject(sql1, Long.class,param1);
		return ResponseData.ok().data(nlist).data("total", total);
	}
	/**
	 * 点赞
	 * 
	 * @param newsShareId
	 * @param userId
	 * @return
	 */
	@Transactional
	public void addLikes(String newsShareId, Long userId) {
		UserDetails userDetails = this.userDetailsMapper.selectByPrimaryKey(userId);
		if (userDetails == null) {
			throw new DataEmptyException("用户不存在");
		}
		NewsShareLikes record = new NewsShareLikes();
		String id = IdGenerator.uuid();
		record.setId(id);
		record.setNewsShareId(newsShareId);
		record.setLikesUserId(userId);
		record.setLikesUserNickName(userDetails.getNickName());
		record.setLikesUserHeadPortraitUrl(userDetails.getImgUrl());
		boolean flag = this.newsShareLikesMapper.insertSelective(record) > 0;
		if (flag) {
			NewsShareWithBLOBs bean = this.newsShareMapper.selectByPrimaryKey(newsShareId);
			bean.setLikeNum(bean.getLikeNum() == null ? 0 : bean.getLikeNum() + 1);
			bean.setModifyTime(new Date());
			int n = this.newsShareMapper.updateByPrimaryKeySelective(bean);
			if (n <= 0) {
				throw new RuntimeException("点赞失败");
			}
			// 发送通知
			noticeService.addNotice(newsShareId, id, "likes");
		}else {
			throw new RuntimeException("点赞失败");
		}
	}

	/**
	 * 取消点赞
	 * 
	 * @param newsShareId
	 * @param userId
	 * @return
	 */
	@Transactional
	public boolean removeLikes(String newsShareId, Long userId) {
		NewsShareLikesExample example = new NewsShareLikesExample();
		example.createCriteria().andNewsShareIdEqualTo(newsShareId).andLikesUserIdEqualTo(userId);
		boolean flag = this.newsShareLikesMapper.deleteByExample(example) > 0;
		if (flag) {
			NewsShareWithBLOBs bean = this.newsShareMapper.selectByPrimaryKey(newsShareId);
			bean.setLikeNum(bean.getLikeNum() == null ? 0 : bean.getLikeNum() - 1);
			int n = this.newsShareMapper.updateByPrimaryKeySelective(bean);
			if (n <= 0) {
				throw new RuntimeException("点赞失败");
			}
		}
		return true;
	}

	/**
	 * 查询点赞列表
	 * 
	 * @param newsShareId
	 * @return
	 */
	public ResponseData queryLikesNum(String newsShareId, int start, int pageNum) {
		NewsShareLikesExample example = new NewsShareLikesExample();
		example.createCriteria().andNewsShareIdEqualTo(newsShareId);
		long total = this.newsShareLikesMapper.countByExample(example);
		example.setOrderByClause(" likes_time desc");
		example.setLimitStart(start);
		example.setOffset(pageNum);
		List<NewsShareLikes> list = this.newsShareLikesMapper.selectByExample(example);
		return ResponseData.ok().data(list).data("total", total);
	}

	/**
	 * 根据资讯或动态的ID增加浏览次数
	 * 
	 * @param newsShareId
	 * @return
	 */
	public boolean browse(String newsShareId) {
		NewsShareWithBLOBs bean = this.newsShareMapper.selectByPrimaryKey(newsShareId);
		bean.setBrowseNum(bean.getBrowseNum() + 1);
		return this.newsShareMapper.updateByPrimaryKeySelective(bean) > 0;
	}

	/**
	 * 查询我的发布数量
	 * 
	 * @param pushUserId
	 * @return
	 */
	public Long mySharesNum(Long pushUserId) {
		NewsShareExample example = new NewsShareExample();
		example.createCriteria().andStatusEqualTo(NewsShareStatusEnum.Y.getValue()).andPushUserIdEqualTo(pushUserId);
		return this.newsShareMapper.countByExample(example);
	}

	/**
	 * 查询评论数
	 * 
	 * @param new_share_id
	 * @return
	 */
	private int queryCommentNum(String new_share_id) {
		NewsShareCommentExample example = new NewsShareCommentExample();
		example.createCriteria().andCommentStatusEqualTo(CommentStatusEnum.Y.getValue())
				.andNewsShareIdEqualTo(new_share_id);
		return (int) this.newsShareCommentMapper.countByExample(example);
	}

	private boolean isHasLikes(String newsShareId, Long userId) {
		NewsShareLikesExample example = new NewsShareLikesExample();
		example.createCriteria().andNewsShareIdEqualTo(newsShareId).andLikesUserIdEqualTo(userId);
		return this.newsShareLikesMapper.countByExample(example) > 0;

	}

	/**
	 * 查询置顶
	 * @param userId
	 * @param pageNum
	 * @param start
	 * @return
	 */
	public ResponseData queryNewsShareTop(Long userId, Integer pageNum, Integer start) {
		return queryNewsShare(userId, null, IsTopEnum.Y.getValue(), NewsShareStatusEnum.Y.getValue(), 0L, null, null,
				start, pageNum);
	}
	/**
	 * 查询点赞人数
	 * 
	 * @param newsShareId
	 * @param pageNum
	 * @param start
	 * @return
	 */

	public boolean delNewsShare(String id) {
		NewsShareInfo bean = new NewsShareInfo();
		bean.setId(id);
		bean.setStatus(NewsShareStatusEnum.N.getValue());
		log.info(JsonUtils.toJson(bean));
		boolean flag = modifyNewsShare(bean);
		return flag;
	}

}
