package com.reechauto.cloud.news.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsShareCommentExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;
    protected Integer limitStart;
    protected Integer offset;

    public NewsShareCommentExample() {
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
    * tableName: news_share_comment
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
        public Criteria andCommentContextIsNull() {
            addCriterion("comment_context is null");
            return (Criteria) this;
        }
        public Criteria andCommentContextIsNotNull() {
            addCriterion("comment_context is not null");
            return (Criteria) this;
        }
        public Criteria andCommentContextEqualTo(String value) {
            addCriterion("comment_context =", value, "commentContext");
            return (Criteria) this;
        }
        public Criteria andCommentContextNotEqualTo(String value) {
            addCriterion("comment_context <>", value, "commentContext");
            return (Criteria) this;
        }
        public Criteria andCommentContextGreaterThan(String value) {
            addCriterion("comment_context >", value, "commentContext");
            return (Criteria) this;
        }
        public Criteria andCommentContextGreaterThanOrEqualTo(String value) {
            addCriterion("comment_context >=", value, "commentContext");
            return (Criteria) this;
        }
        public Criteria andCommentContextLessThan(String value) {
            addCriterion("comment_context <", value, "commentContext");
            return (Criteria) this;
        }
        public Criteria andCommentContextLessThanOrEqualTo(String value) {
            addCriterion("comment_context <=", value, "commentContext");
            return (Criteria) this;
        }
        public Criteria andCommentContextLike(String value) {
            addCriterion("comment_context like", value, "commentContext");
            return (Criteria) this;
        }
        public Criteria andCommentContextNotLike(String value) {
            addCriterion("comment_context not like", value, "commentContext");
            return (Criteria) this;
        }
        public Criteria andCommentContextIn(List<String> values) {
            addCriterion("comment_context in", values, "commentContext");
            return (Criteria) this;
        }
        public Criteria andCommentContextNotIn(List<String> values) {
            addCriterion("comment_context not in", values, "commentContext");
            return (Criteria) this;
        }
        public Criteria andCommentContextBetween(String value1, String value2) {
            addCriterion("comment_context between", value1, value2, "commentContext");
            return (Criteria) this;
        }
        public Criteria andCommentContextNotBetween(String value1, String value2) {
            addCriterion("comment_context not between", value1, value2, "commentContext");
            return (Criteria) this;
        }
        public Criteria andCommentUserIdIsNull() {
            addCriterion("comment_user_id is null");
            return (Criteria) this;
        }
        public Criteria andCommentUserIdIsNotNull() {
            addCriterion("comment_user_id is not null");
            return (Criteria) this;
        }
        public Criteria andCommentUserIdEqualTo(Long value) {
            addCriterion("comment_user_id =", value, "commentUserId");
            return (Criteria) this;
        }
        public Criteria andCommentUserIdNotEqualTo(Long value) {
            addCriterion("comment_user_id <>", value, "commentUserId");
            return (Criteria) this;
        }
        public Criteria andCommentUserIdGreaterThan(Long value) {
            addCriterion("comment_user_id >", value, "commentUserId");
            return (Criteria) this;
        }
        public Criteria andCommentUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("comment_user_id >=", value, "commentUserId");
            return (Criteria) this;
        }
        public Criteria andCommentUserIdLessThan(Long value) {
            addCriterion("comment_user_id <", value, "commentUserId");
            return (Criteria) this;
        }
        public Criteria andCommentUserIdLessThanOrEqualTo(Long value) {
            addCriterion("comment_user_id <=", value, "commentUserId");
            return (Criteria) this;
        }
        public Criteria andCommentUserIdIn(List<Long> values) {
            addCriterion("comment_user_id in", values, "commentUserId");
            return (Criteria) this;
        }
        public Criteria andCommentUserIdNotIn(List<Long> values) {
            addCriterion("comment_user_id not in", values, "commentUserId");
            return (Criteria) this;
        }
        public Criteria andCommentUserIdBetween(Long value1, Long value2) {
            addCriterion("comment_user_id between", value1, value2, "commentUserId");
            return (Criteria) this;
        }
        public Criteria andCommentUserIdNotBetween(Long value1, Long value2) {
            addCriterion("comment_user_id not between", value1, value2, "commentUserId");
            return (Criteria) this;
        }
        public Criteria andCommentUserNickNameIsNull() {
            addCriterion("comment_user_nick_name is null");
            return (Criteria) this;
        }
        public Criteria andCommentUserNickNameIsNotNull() {
            addCriterion("comment_user_nick_name is not null");
            return (Criteria) this;
        }
        public Criteria andCommentUserNickNameEqualTo(String value) {
            addCriterion("comment_user_nick_name =", value, "commentUserNickName");
            return (Criteria) this;
        }
        public Criteria andCommentUserNickNameNotEqualTo(String value) {
            addCriterion("comment_user_nick_name <>", value, "commentUserNickName");
            return (Criteria) this;
        }
        public Criteria andCommentUserNickNameGreaterThan(String value) {
            addCriterion("comment_user_nick_name >", value, "commentUserNickName");
            return (Criteria) this;
        }
        public Criteria andCommentUserNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("comment_user_nick_name >=", value, "commentUserNickName");
            return (Criteria) this;
        }
        public Criteria andCommentUserNickNameLessThan(String value) {
            addCriterion("comment_user_nick_name <", value, "commentUserNickName");
            return (Criteria) this;
        }
        public Criteria andCommentUserNickNameLessThanOrEqualTo(String value) {
            addCriterion("comment_user_nick_name <=", value, "commentUserNickName");
            return (Criteria) this;
        }
        public Criteria andCommentUserNickNameLike(String value) {
            addCriterion("comment_user_nick_name like", value, "commentUserNickName");
            return (Criteria) this;
        }
        public Criteria andCommentUserNickNameNotLike(String value) {
            addCriterion("comment_user_nick_name not like", value, "commentUserNickName");
            return (Criteria) this;
        }
        public Criteria andCommentUserNickNameIn(List<String> values) {
            addCriterion("comment_user_nick_name in", values, "commentUserNickName");
            return (Criteria) this;
        }
        public Criteria andCommentUserNickNameNotIn(List<String> values) {
            addCriterion("comment_user_nick_name not in", values, "commentUserNickName");
            return (Criteria) this;
        }
        public Criteria andCommentUserNickNameBetween(String value1, String value2) {
            addCriterion("comment_user_nick_name between", value1, value2, "commentUserNickName");
            return (Criteria) this;
        }
        public Criteria andCommentUserNickNameNotBetween(String value1, String value2) {
            addCriterion("comment_user_nick_name not between", value1, value2, "commentUserNickName");
            return (Criteria) this;
        }
        public Criteria andCommentUserHeadPortraitUrlIsNull() {
            addCriterion("comment_user_head_portrait_url is null");
            return (Criteria) this;
        }
        public Criteria andCommentUserHeadPortraitUrlIsNotNull() {
            addCriterion("comment_user_head_portrait_url is not null");
            return (Criteria) this;
        }
        public Criteria andCommentUserHeadPortraitUrlEqualTo(String value) {
            addCriterion("comment_user_head_portrait_url =", value, "commentUserHeadPortraitUrl");
            return (Criteria) this;
        }
        public Criteria andCommentUserHeadPortraitUrlNotEqualTo(String value) {
            addCriterion("comment_user_head_portrait_url <>", value, "commentUserHeadPortraitUrl");
            return (Criteria) this;
        }
        public Criteria andCommentUserHeadPortraitUrlGreaterThan(String value) {
            addCriterion("comment_user_head_portrait_url >", value, "commentUserHeadPortraitUrl");
            return (Criteria) this;
        }
        public Criteria andCommentUserHeadPortraitUrlGreaterThanOrEqualTo(String value) {
            addCriterion("comment_user_head_portrait_url >=", value, "commentUserHeadPortraitUrl");
            return (Criteria) this;
        }
        public Criteria andCommentUserHeadPortraitUrlLessThan(String value) {
            addCriterion("comment_user_head_portrait_url <", value, "commentUserHeadPortraitUrl");
            return (Criteria) this;
        }
        public Criteria andCommentUserHeadPortraitUrlLessThanOrEqualTo(String value) {
            addCriterion("comment_user_head_portrait_url <=", value, "commentUserHeadPortraitUrl");
            return (Criteria) this;
        }
        public Criteria andCommentUserHeadPortraitUrlLike(String value) {
            addCriterion("comment_user_head_portrait_url like", value, "commentUserHeadPortraitUrl");
            return (Criteria) this;
        }
        public Criteria andCommentUserHeadPortraitUrlNotLike(String value) {
            addCriterion("comment_user_head_portrait_url not like", value, "commentUserHeadPortraitUrl");
            return (Criteria) this;
        }
        public Criteria andCommentUserHeadPortraitUrlIn(List<String> values) {
            addCriterion("comment_user_head_portrait_url in", values, "commentUserHeadPortraitUrl");
            return (Criteria) this;
        }
        public Criteria andCommentUserHeadPortraitUrlNotIn(List<String> values) {
            addCriterion("comment_user_head_portrait_url not in", values, "commentUserHeadPortraitUrl");
            return (Criteria) this;
        }
        public Criteria andCommentUserHeadPortraitUrlBetween(String value1, String value2) {
            addCriterion("comment_user_head_portrait_url between", value1, value2, "commentUserHeadPortraitUrl");
            return (Criteria) this;
        }
        public Criteria andCommentUserHeadPortraitUrlNotBetween(String value1, String value2) {
            addCriterion("comment_user_head_portrait_url not between", value1, value2, "commentUserHeadPortraitUrl");
            return (Criteria) this;
        }
        public Criteria andCommentStatusIsNull() {
            addCriterion("comment_status is null");
            return (Criteria) this;
        }
        public Criteria andCommentStatusIsNotNull() {
            addCriterion("comment_status is not null");
            return (Criteria) this;
        }
        public Criteria andCommentStatusEqualTo(String value) {
            addCriterion("comment_status =", value, "commentStatus");
            return (Criteria) this;
        }
        public Criteria andCommentStatusNotEqualTo(String value) {
            addCriterion("comment_status <>", value, "commentStatus");
            return (Criteria) this;
        }
        public Criteria andCommentStatusGreaterThan(String value) {
            addCriterion("comment_status >", value, "commentStatus");
            return (Criteria) this;
        }
        public Criteria andCommentStatusGreaterThanOrEqualTo(String value) {
            addCriterion("comment_status >=", value, "commentStatus");
            return (Criteria) this;
        }
        public Criteria andCommentStatusLessThan(String value) {
            addCriterion("comment_status <", value, "commentStatus");
            return (Criteria) this;
        }
        public Criteria andCommentStatusLessThanOrEqualTo(String value) {
            addCriterion("comment_status <=", value, "commentStatus");
            return (Criteria) this;
        }
        public Criteria andCommentStatusLike(String value) {
            addCriterion("comment_status like", value, "commentStatus");
            return (Criteria) this;
        }
        public Criteria andCommentStatusNotLike(String value) {
            addCriterion("comment_status not like", value, "commentStatus");
            return (Criteria) this;
        }
        public Criteria andCommentStatusIn(List<String> values) {
            addCriterion("comment_status in", values, "commentStatus");
            return (Criteria) this;
        }
        public Criteria andCommentStatusNotIn(List<String> values) {
            addCriterion("comment_status not in", values, "commentStatus");
            return (Criteria) this;
        }
        public Criteria andCommentStatusBetween(String value1, String value2) {
            addCriterion("comment_status between", value1, value2, "commentStatus");
            return (Criteria) this;
        }
        public Criteria andCommentStatusNotBetween(String value1, String value2) {
            addCriterion("comment_status not between", value1, value2, "commentStatus");
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
    * tableName: news_share_comment
    * @author zhaoyb
    */
    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
    * 绿驰汽车
    * tableName: news_share_comment
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