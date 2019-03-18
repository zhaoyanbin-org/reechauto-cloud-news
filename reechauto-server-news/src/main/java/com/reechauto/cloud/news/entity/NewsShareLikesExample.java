package com.reechauto.cloud.news.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsShareLikesExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;
    protected Integer limitStart;
    protected Integer offset;

    public NewsShareLikesExample() {
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
    * tableName: news_share_likes
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
        public Criteria andNewsShareIdIsNull() {
            addCriterion("news_share_id is null");
            return (Criteria) this;
        }
        public Criteria andNewsShareIdIsNotNull() {
            addCriterion("news_share_id is not null");
            return (Criteria) this;
        }
        public Criteria andNewsShareIdEqualTo(String value) {
            addCriterion("news_share_id =", value, "newsShareId");
            return (Criteria) this;
        }
        public Criteria andNewsShareIdNotEqualTo(String value) {
            addCriterion("news_share_id <>", value, "newsShareId");
            return (Criteria) this;
        }
        public Criteria andNewsShareIdGreaterThan(String value) {
            addCriterion("news_share_id >", value, "newsShareId");
            return (Criteria) this;
        }
        public Criteria andNewsShareIdGreaterThanOrEqualTo(String value) {
            addCriterion("news_share_id >=", value, "newsShareId");
            return (Criteria) this;
        }
        public Criteria andNewsShareIdLessThan(String value) {
            addCriterion("news_share_id <", value, "newsShareId");
            return (Criteria) this;
        }
        public Criteria andNewsShareIdLessThanOrEqualTo(String value) {
            addCriterion("news_share_id <=", value, "newsShareId");
            return (Criteria) this;
        }
        public Criteria andNewsShareIdLike(String value) {
            addCriterion("news_share_id like", value, "newsShareId");
            return (Criteria) this;
        }
        public Criteria andNewsShareIdNotLike(String value) {
            addCriterion("news_share_id not like", value, "newsShareId");
            return (Criteria) this;
        }
        public Criteria andNewsShareIdIn(List<String> values) {
            addCriterion("news_share_id in", values, "newsShareId");
            return (Criteria) this;
        }
        public Criteria andNewsShareIdNotIn(List<String> values) {
            addCriterion("news_share_id not in", values, "newsShareId");
            return (Criteria) this;
        }
        public Criteria andNewsShareIdBetween(String value1, String value2) {
            addCriterion("news_share_id between", value1, value2, "newsShareId");
            return (Criteria) this;
        }
        public Criteria andNewsShareIdNotBetween(String value1, String value2) {
            addCriterion("news_share_id not between", value1, value2, "newsShareId");
            return (Criteria) this;
        }
        public Criteria andLikesUserIdIsNull() {
            addCriterion("likes_user_id is null");
            return (Criteria) this;
        }
        public Criteria andLikesUserIdIsNotNull() {
            addCriterion("likes_user_id is not null");
            return (Criteria) this;
        }
        public Criteria andLikesUserIdEqualTo(Long value) {
            addCriterion("likes_user_id =", value, "likesUserId");
            return (Criteria) this;
        }
        public Criteria andLikesUserIdNotEqualTo(Long value) {
            addCriterion("likes_user_id <>", value, "likesUserId");
            return (Criteria) this;
        }
        public Criteria andLikesUserIdGreaterThan(Long value) {
            addCriterion("likes_user_id >", value, "likesUserId");
            return (Criteria) this;
        }
        public Criteria andLikesUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("likes_user_id >=", value, "likesUserId");
            return (Criteria) this;
        }
        public Criteria andLikesUserIdLessThan(Long value) {
            addCriterion("likes_user_id <", value, "likesUserId");
            return (Criteria) this;
        }
        public Criteria andLikesUserIdLessThanOrEqualTo(Long value) {
            addCriterion("likes_user_id <=", value, "likesUserId");
            return (Criteria) this;
        }
        public Criteria andLikesUserIdIn(List<Long> values) {
            addCriterion("likes_user_id in", values, "likesUserId");
            return (Criteria) this;
        }
        public Criteria andLikesUserIdNotIn(List<Long> values) {
            addCriterion("likes_user_id not in", values, "likesUserId");
            return (Criteria) this;
        }
        public Criteria andLikesUserIdBetween(Long value1, Long value2) {
            addCriterion("likes_user_id between", value1, value2, "likesUserId");
            return (Criteria) this;
        }
        public Criteria andLikesUserIdNotBetween(Long value1, Long value2) {
            addCriterion("likes_user_id not between", value1, value2, "likesUserId");
            return (Criteria) this;
        }
        public Criteria andLikesUserNickNameIsNull() {
            addCriterion("likes_user_nick_name is null");
            return (Criteria) this;
        }
        public Criteria andLikesUserNickNameIsNotNull() {
            addCriterion("likes_user_nick_name is not null");
            return (Criteria) this;
        }
        public Criteria andLikesUserNickNameEqualTo(String value) {
            addCriterion("likes_user_nick_name =", value, "likesUserNickName");
            return (Criteria) this;
        }
        public Criteria andLikesUserNickNameNotEqualTo(String value) {
            addCriterion("likes_user_nick_name <>", value, "likesUserNickName");
            return (Criteria) this;
        }
        public Criteria andLikesUserNickNameGreaterThan(String value) {
            addCriterion("likes_user_nick_name >", value, "likesUserNickName");
            return (Criteria) this;
        }
        public Criteria andLikesUserNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("likes_user_nick_name >=", value, "likesUserNickName");
            return (Criteria) this;
        }
        public Criteria andLikesUserNickNameLessThan(String value) {
            addCriterion("likes_user_nick_name <", value, "likesUserNickName");
            return (Criteria) this;
        }
        public Criteria andLikesUserNickNameLessThanOrEqualTo(String value) {
            addCriterion("likes_user_nick_name <=", value, "likesUserNickName");
            return (Criteria) this;
        }
        public Criteria andLikesUserNickNameLike(String value) {
            addCriterion("likes_user_nick_name like", value, "likesUserNickName");
            return (Criteria) this;
        }
        public Criteria andLikesUserNickNameNotLike(String value) {
            addCriterion("likes_user_nick_name not like", value, "likesUserNickName");
            return (Criteria) this;
        }
        public Criteria andLikesUserNickNameIn(List<String> values) {
            addCriterion("likes_user_nick_name in", values, "likesUserNickName");
            return (Criteria) this;
        }
        public Criteria andLikesUserNickNameNotIn(List<String> values) {
            addCriterion("likes_user_nick_name not in", values, "likesUserNickName");
            return (Criteria) this;
        }
        public Criteria andLikesUserNickNameBetween(String value1, String value2) {
            addCriterion("likes_user_nick_name between", value1, value2, "likesUserNickName");
            return (Criteria) this;
        }
        public Criteria andLikesUserNickNameNotBetween(String value1, String value2) {
            addCriterion("likes_user_nick_name not between", value1, value2, "likesUserNickName");
            return (Criteria) this;
        }
        public Criteria andLikesUserHeadPortraitUrlIsNull() {
            addCriterion("likes_user_head_portrait_url is null");
            return (Criteria) this;
        }
        public Criteria andLikesUserHeadPortraitUrlIsNotNull() {
            addCriterion("likes_user_head_portrait_url is not null");
            return (Criteria) this;
        }
        public Criteria andLikesUserHeadPortraitUrlEqualTo(String value) {
            addCriterion("likes_user_head_portrait_url =", value, "likesUserHeadPortraitUrl");
            return (Criteria) this;
        }
        public Criteria andLikesUserHeadPortraitUrlNotEqualTo(String value) {
            addCriterion("likes_user_head_portrait_url <>", value, "likesUserHeadPortraitUrl");
            return (Criteria) this;
        }
        public Criteria andLikesUserHeadPortraitUrlGreaterThan(String value) {
            addCriterion("likes_user_head_portrait_url >", value, "likesUserHeadPortraitUrl");
            return (Criteria) this;
        }
        public Criteria andLikesUserHeadPortraitUrlGreaterThanOrEqualTo(String value) {
            addCriterion("likes_user_head_portrait_url >=", value, "likesUserHeadPortraitUrl");
            return (Criteria) this;
        }
        public Criteria andLikesUserHeadPortraitUrlLessThan(String value) {
            addCriterion("likes_user_head_portrait_url <", value, "likesUserHeadPortraitUrl");
            return (Criteria) this;
        }
        public Criteria andLikesUserHeadPortraitUrlLessThanOrEqualTo(String value) {
            addCriterion("likes_user_head_portrait_url <=", value, "likesUserHeadPortraitUrl");
            return (Criteria) this;
        }
        public Criteria andLikesUserHeadPortraitUrlLike(String value) {
            addCriterion("likes_user_head_portrait_url like", value, "likesUserHeadPortraitUrl");
            return (Criteria) this;
        }
        public Criteria andLikesUserHeadPortraitUrlNotLike(String value) {
            addCriterion("likes_user_head_portrait_url not like", value, "likesUserHeadPortraitUrl");
            return (Criteria) this;
        }
        public Criteria andLikesUserHeadPortraitUrlIn(List<String> values) {
            addCriterion("likes_user_head_portrait_url in", values, "likesUserHeadPortraitUrl");
            return (Criteria) this;
        }
        public Criteria andLikesUserHeadPortraitUrlNotIn(List<String> values) {
            addCriterion("likes_user_head_portrait_url not in", values, "likesUserHeadPortraitUrl");
            return (Criteria) this;
        }
        public Criteria andLikesUserHeadPortraitUrlBetween(String value1, String value2) {
            addCriterion("likes_user_head_portrait_url between", value1, value2, "likesUserHeadPortraitUrl");
            return (Criteria) this;
        }
        public Criteria andLikesUserHeadPortraitUrlNotBetween(String value1, String value2) {
            addCriterion("likes_user_head_portrait_url not between", value1, value2, "likesUserHeadPortraitUrl");
            return (Criteria) this;
        }
        public Criteria andLikesTimeIsNull() {
            addCriterion("likes_time is null");
            return (Criteria) this;
        }
        public Criteria andLikesTimeIsNotNull() {
            addCriterion("likes_time is not null");
            return (Criteria) this;
        }
        public Criteria andLikesTimeEqualTo(Date value) {
            addCriterion("likes_time =", value, "likesTime");
            return (Criteria) this;
        }
        public Criteria andLikesTimeNotEqualTo(Date value) {
            addCriterion("likes_time <>", value, "likesTime");
            return (Criteria) this;
        }
        public Criteria andLikesTimeGreaterThan(Date value) {
            addCriterion("likes_time >", value, "likesTime");
            return (Criteria) this;
        }
        public Criteria andLikesTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("likes_time >=", value, "likesTime");
            return (Criteria) this;
        }
        public Criteria andLikesTimeLessThan(Date value) {
            addCriterion("likes_time <", value, "likesTime");
            return (Criteria) this;
        }
        public Criteria andLikesTimeLessThanOrEqualTo(Date value) {
            addCriterion("likes_time <=", value, "likesTime");
            return (Criteria) this;
        }
        public Criteria andLikesTimeIn(List<Date> values) {
            addCriterion("likes_time in", values, "likesTime");
            return (Criteria) this;
        }
        public Criteria andLikesTimeNotIn(List<Date> values) {
            addCriterion("likes_time not in", values, "likesTime");
            return (Criteria) this;
        }
        public Criteria andLikesTimeBetween(Date value1, Date value2) {
            addCriterion("likes_time between", value1, value2, "likesTime");
            return (Criteria) this;
        }
        public Criteria andLikesTimeNotBetween(Date value1, Date value2) {
            addCriterion("likes_time not between", value1, value2, "likesTime");
            return (Criteria) this;
        }
    }

    /**
    * 绿驰汽车
    * tableName: news_share_likes
    * @author zhaoyb
    */
    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
    * 绿驰汽车
    * tableName: news_share_likes
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