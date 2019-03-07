package com.reechauto.cloud.news.service.feedback;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.reechauto.cloud.common.exception.DataEmptyException;
import com.reechauto.cloud.common.resp.ResponseData;
import com.reechauto.cloud.common.utils.date.DateUtil;
import com.reechauto.cloud.news.bean.enums.IsAnsweredEnum;
import com.reechauto.cloud.news.bean.req.feedback.FeedbackAnswerByOperatorRequest;
import com.reechauto.cloud.news.bean.response.FeedbackList;
import com.reechauto.cloud.news.entity.NewsFeedback;
import com.reechauto.cloud.news.entity.NewsFeedbackExample;
import com.reechauto.cloud.news.entity.NewsFeedbackExample.Criteria;
import com.reechauto.cloud.news.entity.UserDetails;
import com.reechauto.cloud.news.entity.UserDetailsExample;
import com.reechauto.cloud.news.mapper.NewsFeedbackMapper;
import com.reechauto.cloud.news.mapper.UserDetailsMapper;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class AppFeedbackService {


	@Autowired
	private NewsFeedbackMapper newsFeedbackMapper;
	@Autowired
	private UserDetailsMapper userDetailsMapper;

	public ResponseData queryFeedbacksByUserId(Long userId, Integer pageNum, Integer start) {

		List<NewsFeedback> list = null;
		NewsFeedbackExample example = new NewsFeedbackExample();
		Criteria criteria = example.createCriteria();
		criteria.andQuestionerIdEqualTo(userId);
		example.setOrderByClause(" question_time DESC");
		example.setLimitStart(start);
		example.setOffset(pageNum);
		list = this.newsFeedbackMapper.selectByExample(example);
		return ResponseData.ok().data(list);

	}

	public ResponseData addQuestion(Long userId, String question) {

		log.info("questionerId:" + userId);
		NewsFeedback record = new NewsFeedback();
		record.setQuestion(question);
		record.setQuestionerId(userId);
		record.setQuestionTime(new Date());
		boolean flag = this.newsFeedbackMapper.insertSelective(record) > 0;
		return ResponseData.ok();
	}

	public ResponseData queryFeedbacksByOperator(Long operatorId, String mobileNum, String status, String beginDate,
			String endDate, Integer pageNum, Integer start) {
		List<NewsFeedback> list = null;
		Long userId = null;
		if (StringUtils.isNotBlank(mobileNum)) {
			UserDetailsExample userDetailsExample = new UserDetailsExample();
			com.reechauto.cloud.news.entity.UserDetailsExample.Criteria criteria = userDetailsExample.createCriteria();
			criteria.andMobileEqualTo(mobileNum);
			List<UserDetails> list1 = userDetailsMapper.selectByExample(userDetailsExample);
			if (list1 == null) {
				throw new DataEmptyException("用户不存在");
			}
			userId = list1.get(0).getUserId();
		}
		NewsFeedbackExample example = new NewsFeedbackExample();
		Criteria criteria = example.createCriteria();
		if (userId != null) {
			criteria.andQuestionerIdEqualTo(userId);
		}
		if (StringUtils.isNotBlank(status)) {
			criteria.andStatusEqualTo(IsAnsweredEnum.get(status).getValue());
		}
		if (StringUtils.isNotBlank(beginDate)) {
			criteria.andQuestionTimeGreaterThanOrEqualTo(DateUtil.convert2Date(beginDate, "yyyy-MM-dd"));
		}
		if (StringUtils.isNotBlank(endDate)) {
			criteria.andQuestionTimeLessThanOrEqualTo(DateUtil.convert2Date(endDate, "yyyy-MM-dd"));
		}
		example.setOrderByClause("question_time DESC");
		example.setLimitStart(start);
		example.setOffset(pageNum);
		list = this.newsFeedbackMapper.selectByExample(example);
		List<FeedbackList> nList = new ArrayList<FeedbackList>();
		if (CollectionUtils.isNotEmpty(list)) {
			for (NewsFeedback appFeedback : list) {
				FeedbackList nl = new FeedbackList();
				BeanUtils.copyProperties(appFeedback, nl);
				if (StringUtils.isNotBlank(mobileNum)) {
					nl.setMobileNum(mobileNum);
				} else {
					UserDetails UserDetails = userDetailsMapper.selectByPrimaryKey(appFeedback.getQuestionerId());
					nl.setMobileNum(UserDetails.getMobile());
				}
				nList.add(nl);
			}
		}
		return ResponseData.ok().data(nList);
	}

	public ResponseData answerQuestion(FeedbackAnswerByOperatorRequest vo) {

		log.info("appFeedbackId:" + vo.getAppFeedbackId());
		log.info("content:" + vo.getContent());
		NewsFeedback record = newsFeedbackMapper.selectByPrimaryKey(vo.getAppFeedbackId());
		record.setAnswer(vo.getContent());
		record.setAnswererId(vo.getOperatorId());
		record.setAnswerTime(new Date());
		record.setStatus("Y");
		boolean flag = this.newsFeedbackMapper.updateByPrimaryKeySelective(record) > 0;
		return ResponseData.ok();
	}

}
