package com.reechauto.cloud.news.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsShareExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;
    protected Integer limitStart;
    protected Integer offset;

    public NewsShareExample() {
        oredCriteria = new ArrayList<Criteria>();
    }
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }
    public String getOrderByClause() {
        return orderByClause;
    }
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }
    public boolean isDistinct() {
        return distinct;
    }
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }
    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }
    public Integer getLimitStart() {
        return limitStart;
    }
    public void setOffset(Integer offset) {
        this.offset=offset;
    }
    public Integer getOffset() {
        return offset;
    }

    /**
    * 绿驰汽车
    * tableName: news_share
    * @author zhaoyb
    */
    protected abstract static class GeneratedCriteria {

        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }
        public boolean isValid() {
            return criteria.size() > 0;
        }
        public List<Criterion> getAllCriteria() {
            return criteria;
        }
        public List<Criterion> getCriteria() {
            return criteria;
        }
        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }
        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }
        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }
        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }
        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }
        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }
        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }
        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }
        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }
        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }
        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }
        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }
        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }
        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }
        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }
        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }
        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }
        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }
        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }
        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }
        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }
        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }
        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }
        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }
        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }
        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }
        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }
        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }
        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }
        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }
        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }
        public Criteria andIsTopeIsNull() {
            addCriterion("is_tope is null");
            return (Criteria) this;
        }
        public Criteria andIsTopeIsNotNull() {
            addCriterion("is_tope is not null");
            return (Criteria) this;
        }
        public Criteria andIsTopeEqualTo(String value) {
            addCriterion("is_tope =", value, "isTope");
            return (Criteria) this;
        }
        public Criteria andIsTopeNotEqualTo(String value) {
            addCriterion("is_tope <>", value, "isTope");
            return (Criteria) this;
        }
        public Criteria andIsTopeGreaterThan(String value) {
            addCriterion("is_tope >", value, "isTope");
            return (Criteria) this;
        }
        public Criteria andIsTopeGreaterThanOrEqualTo(String value) {
            addCriterion("is_tope >=", value, "isTope");
            return (Criteria) this;
        }
        public Criteria andIsTopeLessThan(String value) {
            addCriterion("is_tope <", value, "isTope");
            return (Criteria) this;
        }
        public Criteria andIsTopeLessThanOrEqualTo(String value) {
            addCriterion("is_tope <=", value, "isTope");
            return (Criteria) this;
        }
        public Criteria andIsTopeLike(String value) {
            addCriterion("is_tope like", value, "isTope");
            return (Criteria) this;
        }
        public Criteria andIsTopeNotLike(String value) {
            addCriterion("is_tope not like", value, "isTope");
            return (Criteria) this;
        }
        public Criteria andIsTopeIn(List<String> values) {
            addCriterion("is_tope in", values, "isTope");
            return (Criteria) this;
        }
        public Criteria andIsTopeNotIn(List<String> values) {
            addCriterion("is_tope not in", values, "isTope");
            return (Criteria) this;
        }
        public Criteria andIsTopeBetween(String value1, String value2) {
            addCriterion("is_tope between", value1, value2, "isTope");
            return (Criteria) this;
        }
        public Criteria andIsTopeNotBetween(String value1, String value2) {
            addCriterion("is_tope not between", value1, value2, "isTope");
            return (Criteria) this;
        }
        public Criteria andIsNewsIsNull() {
            addCriterion("is_news is null");
            return (Criteria) this;
        }
        public Criteria andIsNewsIsNotNull() {
            addCriterion("is_news is not null");
            return (Criteria) this;
        }
        public Criteria andIsNewsEqualTo(String value) {
            addCriterion("is_news =", value, "isNews");
            return (Criteria) this;
        }
        public Criteria andIsNewsNotEqualTo(String value) {
            addCriterion("is_news <>", value, "isNews");
            return (Criteria) this;
        }
        public Criteria andIsNewsGreaterThan(String value) {
            addCriterion("is_news >", value, "isNews");
            return (Criteria) this;
        }
        public Criteria andIsNewsGreaterThanOrEqualTo(String value) {
            addCriterion("is_news >=", value, "isNews");
            return (Criteria) this;
        }
        public Criteria andIsNewsLessThan(String value) {
            addCriterion("is_news <", value, "isNews");
            return (Criteria) this;
        }
        public Criteria andIsNewsLessThanOrEqualTo(String value) {
            addCriterion("is_news <=", value, "isNews");
            return (Criteria) this;
        }
        public Criteria andIsNewsLike(String value) {
            addCriterion("is_news like", value, "isNews");
            return (Criteria) this;
        }
        public Criteria andIsNewsNotLike(String value) {
            addCriterion("is_news not like", value, "isNews");
            return (Criteria) this;
        }
        public Criteria andIsNewsIn(List<String> values) {
            addCriterion("is_news in", values, "isNews");
            return (Criteria) this;
        }
        public Criteria andIsNewsNotIn(List<String> values) {
            addCriterion("is_news not in", values, "isNews");
            return (Criteria) this;
        }
        public Criteria andIsNewsBetween(String value1, String value2) {
            addCriterion("is_news between", value1, value2, "isNews");
            return (Criteria) this;
        }
        public Criteria andIsNewsNotBetween(String value1, String value2) {
            addCriterion("is_news not between", value1, value2, "isNews");
            return (Criteria) this;
        }
        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }
        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }
        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }
        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }
        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }
        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }
        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }
        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }
        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }
        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }
        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }
        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }
        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }
        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }
        public Criteria andPushUserIdIsNull() {
            addCriterion("push_user_id is null");
            return (Criteria) this;
        }
        public Criteria andPushUserIdIsNotNull() {
            addCriterion("push_user_id is not null");
            return (Criteria) this;
        }
        public Criteria andPushUserIdEqualTo(Long value) {
            addCriterion("push_user_id =", value, "pushUserId");
            return (Criteria) this;
        }
        public Criteria andPushUserIdNotEqualTo(Long value) {
            addCriterion("push_user_id <>", value, "pushUserId");
            return (Criteria) this;
        }
        public Criteria andPushUserIdGreaterThan(Long value) {
            addCriterion("push_user_id >", value, "pushUserId");
            return (Criteria) this;
        }
        public Criteria andPushUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("push_user_id >=", value, "pushUserId");
            return (Criteria) this;
        }
        public Criteria andPushUserIdLessThan(Long value) {
            addCriterion("push_user_id <", value, "pushUserId");
            return (Criteria) this;
        }
        public Criteria andPushUserIdLessThanOrEqualTo(Long value) {
            addCriterion("push_user_id <=", value, "pushUserId");
            return (Criteria) this;
        }
        public Criteria andPushUserIdIn(List<Long> values) {
            addCriterion("push_user_id in", values, "pushUserId");
            return (Criteria) this;
        }
        public Criteria andPushUserIdNotIn(List<Long> values) {
            addCriterion("push_user_id not in", values, "pushUserId");
            return (Criteria) this;
        }
        public Criteria andPushUserIdBetween(Long value1, Long value2) {
            addCriterion("push_user_id between", value1, value2, "pushUserId");
            return (Criteria) this;
        }
        public Criteria andPushUserIdNotBetween(Long value1, Long value2) {
            addCriterion("push_user_id not between", value1, value2, "pushUserId");
            return (Criteria) this;
        }
        public Criteria andPushUserNickIsNull() {
            addCriterion("push_user_nick is null");
            return (Criteria) this;
        }
        public Criteria andPushUserNickIsNotNull() {
            addCriterion("push_user_nick is not null");
            return (Criteria) this;
        }
        public Criteria andPushUserNickEqualTo(String value) {
            addCriterion("push_user_nick =", value, "pushUserNick");
            return (Criteria) this;
        }
        public Criteria andPushUserNickNotEqualTo(String value) {
            addCriterion("push_user_nick <>", value, "pushUserNick");
            return (Criteria) this;
        }
        public Criteria andPushUserNickGreaterThan(String value) {
            addCriterion("push_user_nick >", value, "pushUserNick");
            return (Criteria) this;
        }
        public Criteria andPushUserNickGreaterThanOrEqualTo(String value) {
            addCriterion("push_user_nick >=", value, "pushUserNick");
            return (Criteria) this;
        }
        public Criteria andPushUserNickLessThan(String value) {
            addCriterion("push_user_nick <", value, "pushUserNick");
            return (Criteria) this;
        }
        public Criteria andPushUserNickLessThanOrEqualTo(String value) {
            addCriterion("push_user_nick <=", value, "pushUserNick");
            return (Criteria) this;
        }
        public Criteria andPushUserNickLike(String value) {
            addCriterion("push_user_nick like", value, "pushUserNick");
            return (Criteria) this;
        }
        public Criteria andPushUserNickNotLike(String value) {
            addCriterion("push_user_nick not like", value, "pushUserNick");
            return (Criteria) this;
        }
        public Criteria andPushUserNickIn(List<String> values) {
            addCriterion("push_user_nick in", values, "pushUserNick");
            return (Criteria) this;
        }
        public Criteria andPushUserNickNotIn(List<String> values) {
            addCriterion("push_user_nick not in", values, "pushUserNick");
            return (Criteria) this;
        }
        public Criteria andPushUserNickBetween(String value1, String value2) {
            addCriterion("push_user_nick between", value1, value2, "pushUserNick");
            return (Criteria) this;
        }
        public Criteria andPushUserNickNotBetween(String value1, String value2) {
            addCriterion("push_user_nick not between", value1, value2, "pushUserNick");
            return (Criteria) this;
        }
        public Criteria andPushUserHeadPortraitUrlIsNull() {
            addCriterion("push_user_head_portrait_url is null");
            return (Criteria) this;
        }
        public Criteria andPushUserHeadPortraitUrlIsNotNull() {
            addCriterion("push_user_head_portrait_url is not null");
            return (Criteria) this;
        }
        public Criteria andPushUserHeadPortraitUrlEqualTo(String value) {
            addCriterion("push_user_head_portrait_url =", value, "pushUserHeadPortraitUrl");
            return (Criteria) this;
        }
        public Criteria andPushUserHeadPortraitUrlNotEqualTo(String value) {
            addCriterion("push_user_head_portrait_url <>", value, "pushUserHeadPortraitUrl");
            return (Criteria) this;
        }
        public Criteria andPushUserHeadPortraitUrlGreaterThan(String value) {
            addCriterion("push_user_head_portrait_url >", value, "pushUserHeadPortraitUrl");
            return (Criteria) this;
        }
        public Criteria andPushUserHeadPortraitUrlGreaterThanOrEqualTo(String value) {
            addCriterion("push_user_head_portrait_url >=", value, "pushUserHeadPortraitUrl");
            return (Criteria) this;
        }
        public Criteria andPushUserHeadPortraitUrlLessThan(String value) {
            addCriterion("push_user_head_portrait_url <", value, "pushUserHeadPortraitUrl");
            return (Criteria) this;
        }
        public Criteria andPushUserHeadPortraitUrlLessThanOrEqualTo(String value) {
            addCriterion("push_user_head_portrait_url <=", value, "pushUserHeadPortraitUrl");
            return (Criteria) this;
        }
        public Criteria andPushUserHeadPortraitUrlLike(String value) {
            addCriterion("push_user_head_portrait_url like", value, "pushUserHeadPortraitUrl");
            return (Criteria) this;
        }
        public Criteria andPushUserHeadPortraitUrlNotLike(String value) {
            addCriterion("push_user_head_portrait_url not like", value, "pushUserHeadPortraitUrl");
            return (Criteria) this;
        }
        public Criteria andPushUserHeadPortraitUrlIn(List<String> values) {
            addCriterion("push_user_head_portrait_url in", values, "pushUserHeadPortraitUrl");
            return (Criteria) this;
        }
        public Criteria andPushUserHeadPortraitUrlNotIn(List<String> values) {
            addCriterion("push_user_head_portrait_url not in", values, "pushUserHeadPortraitUrl");
            return (Criteria) this;
        }
        public Criteria andPushUserHeadPortraitUrlBetween(String value1, String value2) {
            addCriterion("push_user_head_portrait_url between", value1, value2, "pushUserHeadPortraitUrl");
            return (Criteria) this;
        }
        public Criteria andPushUserHeadPortraitUrlNotBetween(String value1, String value2) {
            addCriterion("push_user_head_portrait_url not between", value1, value2, "pushUserHeadPortraitUrl");
            return (Criteria) this;
        }
        public Criteria andBrowseNumIsNull() {
            addCriterion("browse_num is null");
            return (Criteria) this;
        }
        public Criteria andBrowseNumIsNotNull() {
            addCriterion("browse_num is not null");
            return (Criteria) this;
        }
        public Criteria andBrowseNumEqualTo(Integer value) {
            addCriterion("browse_num =", value, "browseNum");
            return (Criteria) this;
        }
        public Criteria andBrowseNumNotEqualTo(Integer value) {
            addCriterion("browse_num <>", value, "browseNum");
            return (Criteria) this;
        }
        public Criteria andBrowseNumGreaterThan(Integer value) {
            addCriterion("browse_num >", value, "browseNum");
            return (Criteria) this;
        }
        public Criteria andBrowseNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("browse_num >=", value, "browseNum");
            return (Criteria) this;
        }
        public Criteria andBrowseNumLessThan(Integer value) {
            addCriterion("browse_num <", value, "browseNum");
            return (Criteria) this;
        }
        public Criteria andBrowseNumLessThanOrEqualTo(Integer value) {
            addCriterion("browse_num <=", value, "browseNum");
            return (Criteria) this;
        }
        public Criteria andBrowseNumIn(List<Integer> values) {
            addCriterion("browse_num in", values, "browseNum");
            return (Criteria) this;
        }
        public Criteria andBrowseNumNotIn(List<Integer> values) {
            addCriterion("browse_num not in", values, "browseNum");
            return (Criteria) this;
        }
        public Criteria andBrowseNumBetween(Integer value1, Integer value2) {
            addCriterion("browse_num between", value1, value2, "browseNum");
            return (Criteria) this;
        }
        public Criteria andBrowseNumNotBetween(Integer value1, Integer value2) {
            addCriterion("browse_num not between", value1, value2, "browseNum");
            return (Criteria) this;
        }
        public Criteria andLikeNumIsNull() {
            addCriterion("like_num is null");
            return (Criteria) this;
        }
        public Criteria andLikeNumIsNotNull() {
            addCriterion("like_num is not null");
            return (Criteria) this;
        }
        public Criteria andLikeNumEqualTo(Integer value) {
            addCriterion("like_num =", value, "likeNum");
            return (Criteria) this;
        }
        public Criteria andLikeNumNotEqualTo(Integer value) {
            addCriterion("like_num <>", value, "likeNum");
            return (Criteria) this;
        }
        public Criteria andLikeNumGreaterThan(Integer value) {
            addCriterion("like_num >", value, "likeNum");
            return (Criteria) this;
        }
        public Criteria andLikeNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("like_num >=", value, "likeNum");
            return (Criteria) this;
        }
        public Criteria andLikeNumLessThan(Integer value) {
            addCriterion("like_num <", value, "likeNum");
            return (Criteria) this;
        }
        public Criteria andLikeNumLessThanOrEqualTo(Integer value) {
            addCriterion("like_num <=", value, "likeNum");
            return (Criteria) this;
        }
        public Criteria andLikeNumIn(List<Integer> values) {
            addCriterion("like_num in", values, "likeNum");
            return (Criteria) this;
        }
        public Criteria andLikeNumNotIn(List<Integer> values) {
            addCriterion("like_num not in", values, "likeNum");
            return (Criteria) this;
        }
        public Criteria andLikeNumBetween(Integer value1, Integer value2) {
            addCriterion("like_num between", value1, value2, "likeNum");
            return (Criteria) this;
        }
        public Criteria andLikeNumNotBetween(Integer value1, Integer value2) {
            addCriterion("like_num not between", value1, value2, "likeNum");
            return (Criteria) this;
        }
        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }
        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }
        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }
        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }
        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }
        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }
        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }
        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }
        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }
        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }
        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }
        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }
        public Criteria andModifyTimeIsNull() {
            addCriterion("modify_time is null");
            return (Criteria) this;
        }
        public Criteria andModifyTimeIsNotNull() {
            addCriterion("modify_time is not null");
            return (Criteria) this;
        }
        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("modify_time =", value, "modifyTime");
            return (Criteria) this;
        }
        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("modify_time <>", value, "modifyTime");
            return (Criteria) this;
        }
        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("modify_time >", value, "modifyTime");
            return (Criteria) this;
        }
        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_time >=", value, "modifyTime");
            return (Criteria) this;
        }
        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("modify_time <", value, "modifyTime");
            return (Criteria) this;
        }
        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("modify_time <=", value, "modifyTime");
            return (Criteria) this;
        }
        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("modify_time in", values, "modifyTime");
            return (Criteria) this;
        }
        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("modify_time not in", values, "modifyTime");
            return (Criteria) this;
        }
        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("modify_time between", value1, value2, "modifyTime");
            return (Criteria) this;
        }
        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("modify_time not between", value1, value2, "modifyTime");
            return (Criteria) this;
        }
    }

    /**
    * 绿驰汽车
    * tableName: news_share
    * @author zhaoyb
    */
    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
    * 绿驰汽车
    * tableName: news_share
    * @author zhaoyb
    */
    public static class Criterion {

        private String condition;
        private Object value;
        private Object secondValue;
        private boolean noValue;
        private boolean singleValue;
        private boolean betweenValue;
        private boolean listValue;
        private String typeHandler;

        public String getCondition() {
            return condition;
        }
        public Object getValue() {
            return value;
        }
        public Object getSecondValue() {
            return secondValue;
        }
        public boolean isNoValue() {
            return noValue;
        }
        public boolean isSingleValue() {
            return singleValue;
        }
        public boolean isBetweenValue() {
            return betweenValue;
        }
        public boolean isListValue() {
            return listValue;
        }
        public String getTypeHandler() {
            return typeHandler;
        }
        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }
        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }
        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }
        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }
        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}