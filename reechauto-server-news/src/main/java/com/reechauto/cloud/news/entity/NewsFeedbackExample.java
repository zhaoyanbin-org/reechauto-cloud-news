package com.reechauto.cloud.news.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsFeedbackExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;
    protected Integer limitStart;
    protected Integer offset;

    public NewsFeedbackExample() {
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
    * tableName: news_feedback
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
        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }
        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }
        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }
        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }
        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }
        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }
        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }
        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }
        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }
        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }
        public Criteria andQuestionIsNull() {
            addCriterion("question is null");
            return (Criteria) this;
        }
        public Criteria andQuestionIsNotNull() {
            addCriterion("question is not null");
            return (Criteria) this;
        }
        public Criteria andQuestionEqualTo(String value) {
            addCriterion("question =", value, "question");
            return (Criteria) this;
        }
        public Criteria andQuestionNotEqualTo(String value) {
            addCriterion("question <>", value, "question");
            return (Criteria) this;
        }
        public Criteria andQuestionGreaterThan(String value) {
            addCriterion("question >", value, "question");
            return (Criteria) this;
        }
        public Criteria andQuestionGreaterThanOrEqualTo(String value) {
            addCriterion("question >=", value, "question");
            return (Criteria) this;
        }
        public Criteria andQuestionLessThan(String value) {
            addCriterion("question <", value, "question");
            return (Criteria) this;
        }
        public Criteria andQuestionLessThanOrEqualTo(String value) {
            addCriterion("question <=", value, "question");
            return (Criteria) this;
        }
        public Criteria andQuestionLike(String value) {
            addCriterion("question like", value, "question");
            return (Criteria) this;
        }
        public Criteria andQuestionNotLike(String value) {
            addCriterion("question not like", value, "question");
            return (Criteria) this;
        }
        public Criteria andQuestionIn(List<String> values) {
            addCriterion("question in", values, "question");
            return (Criteria) this;
        }
        public Criteria andQuestionNotIn(List<String> values) {
            addCriterion("question not in", values, "question");
            return (Criteria) this;
        }
        public Criteria andQuestionBetween(String value1, String value2) {
            addCriterion("question between", value1, value2, "question");
            return (Criteria) this;
        }
        public Criteria andQuestionNotBetween(String value1, String value2) {
            addCriterion("question not between", value1, value2, "question");
            return (Criteria) this;
        }
        public Criteria andAnswerIsNull() {
            addCriterion("answer is null");
            return (Criteria) this;
        }
        public Criteria andAnswerIsNotNull() {
            addCriterion("answer is not null");
            return (Criteria) this;
        }
        public Criteria andAnswerEqualTo(String value) {
            addCriterion("answer =", value, "answer");
            return (Criteria) this;
        }
        public Criteria andAnswerNotEqualTo(String value) {
            addCriterion("answer <>", value, "answer");
            return (Criteria) this;
        }
        public Criteria andAnswerGreaterThan(String value) {
            addCriterion("answer >", value, "answer");
            return (Criteria) this;
        }
        public Criteria andAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("answer >=", value, "answer");
            return (Criteria) this;
        }
        public Criteria andAnswerLessThan(String value) {
            addCriterion("answer <", value, "answer");
            return (Criteria) this;
        }
        public Criteria andAnswerLessThanOrEqualTo(String value) {
            addCriterion("answer <=", value, "answer");
            return (Criteria) this;
        }
        public Criteria andAnswerLike(String value) {
            addCriterion("answer like", value, "answer");
            return (Criteria) this;
        }
        public Criteria andAnswerNotLike(String value) {
            addCriterion("answer not like", value, "answer");
            return (Criteria) this;
        }
        public Criteria andAnswerIn(List<String> values) {
            addCriterion("answer in", values, "answer");
            return (Criteria) this;
        }
        public Criteria andAnswerNotIn(List<String> values) {
            addCriterion("answer not in", values, "answer");
            return (Criteria) this;
        }
        public Criteria andAnswerBetween(String value1, String value2) {
            addCriterion("answer between", value1, value2, "answer");
            return (Criteria) this;
        }
        public Criteria andAnswerNotBetween(String value1, String value2) {
            addCriterion("answer not between", value1, value2, "answer");
            return (Criteria) this;
        }
        public Criteria andQuestionTimeIsNull() {
            addCriterion("question_time is null");
            return (Criteria) this;
        }
        public Criteria andQuestionTimeIsNotNull() {
            addCriterion("question_time is not null");
            return (Criteria) this;
        }
        public Criteria andQuestionTimeEqualTo(Date value) {
            addCriterion("question_time =", value, "questionTime");
            return (Criteria) this;
        }
        public Criteria andQuestionTimeNotEqualTo(Date value) {
            addCriterion("question_time <>", value, "questionTime");
            return (Criteria) this;
        }
        public Criteria andQuestionTimeGreaterThan(Date value) {
            addCriterion("question_time >", value, "questionTime");
            return (Criteria) this;
        }
        public Criteria andQuestionTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("question_time >=", value, "questionTime");
            return (Criteria) this;
        }
        public Criteria andQuestionTimeLessThan(Date value) {
            addCriterion("question_time <", value, "questionTime");
            return (Criteria) this;
        }
        public Criteria andQuestionTimeLessThanOrEqualTo(Date value) {
            addCriterion("question_time <=", value, "questionTime");
            return (Criteria) this;
        }
        public Criteria andQuestionTimeIn(List<Date> values) {
            addCriterion("question_time in", values, "questionTime");
            return (Criteria) this;
        }
        public Criteria andQuestionTimeNotIn(List<Date> values) {
            addCriterion("question_time not in", values, "questionTime");
            return (Criteria) this;
        }
        public Criteria andQuestionTimeBetween(Date value1, Date value2) {
            addCriterion("question_time between", value1, value2, "questionTime");
            return (Criteria) this;
        }
        public Criteria andQuestionTimeNotBetween(Date value1, Date value2) {
            addCriterion("question_time not between", value1, value2, "questionTime");
            return (Criteria) this;
        }
        public Criteria andAnswerTimeIsNull() {
            addCriterion("answer_time is null");
            return (Criteria) this;
        }
        public Criteria andAnswerTimeIsNotNull() {
            addCriterion("answer_time is not null");
            return (Criteria) this;
        }
        public Criteria andAnswerTimeEqualTo(Date value) {
            addCriterion("answer_time =", value, "answerTime");
            return (Criteria) this;
        }
        public Criteria andAnswerTimeNotEqualTo(Date value) {
            addCriterion("answer_time <>", value, "answerTime");
            return (Criteria) this;
        }
        public Criteria andAnswerTimeGreaterThan(Date value) {
            addCriterion("answer_time >", value, "answerTime");
            return (Criteria) this;
        }
        public Criteria andAnswerTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("answer_time >=", value, "answerTime");
            return (Criteria) this;
        }
        public Criteria andAnswerTimeLessThan(Date value) {
            addCriterion("answer_time <", value, "answerTime");
            return (Criteria) this;
        }
        public Criteria andAnswerTimeLessThanOrEqualTo(Date value) {
            addCriterion("answer_time <=", value, "answerTime");
            return (Criteria) this;
        }
        public Criteria andAnswerTimeIn(List<Date> values) {
            addCriterion("answer_time in", values, "answerTime");
            return (Criteria) this;
        }
        public Criteria andAnswerTimeNotIn(List<Date> values) {
            addCriterion("answer_time not in", values, "answerTime");
            return (Criteria) this;
        }
        public Criteria andAnswerTimeBetween(Date value1, Date value2) {
            addCriterion("answer_time between", value1, value2, "answerTime");
            return (Criteria) this;
        }
        public Criteria andAnswerTimeNotBetween(Date value1, Date value2) {
            addCriterion("answer_time not between", value1, value2, "answerTime");
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
        public Criteria andQuestionerIdIsNull() {
            addCriterion("questioner_id is null");
            return (Criteria) this;
        }
        public Criteria andQuestionerIdIsNotNull() {
            addCriterion("questioner_id is not null");
            return (Criteria) this;
        }
        public Criteria andQuestionerIdEqualTo(Long value) {
            addCriterion("questioner_id =", value, "questionerId");
            return (Criteria) this;
        }
        public Criteria andQuestionerIdNotEqualTo(Long value) {
            addCriterion("questioner_id <>", value, "questionerId");
            return (Criteria) this;
        }
        public Criteria andQuestionerIdGreaterThan(Long value) {
            addCriterion("questioner_id >", value, "questionerId");
            return (Criteria) this;
        }
        public Criteria andQuestionerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("questioner_id >=", value, "questionerId");
            return (Criteria) this;
        }
        public Criteria andQuestionerIdLessThan(Long value) {
            addCriterion("questioner_id <", value, "questionerId");
            return (Criteria) this;
        }
        public Criteria andQuestionerIdLessThanOrEqualTo(Long value) {
            addCriterion("questioner_id <=", value, "questionerId");
            return (Criteria) this;
        }
        public Criteria andQuestionerIdIn(List<Long> values) {
            addCriterion("questioner_id in", values, "questionerId");
            return (Criteria) this;
        }
        public Criteria andQuestionerIdNotIn(List<Long> values) {
            addCriterion("questioner_id not in", values, "questionerId");
            return (Criteria) this;
        }
        public Criteria andQuestionerIdBetween(Long value1, Long value2) {
            addCriterion("questioner_id between", value1, value2, "questionerId");
            return (Criteria) this;
        }
        public Criteria andQuestionerIdNotBetween(Long value1, Long value2) {
            addCriterion("questioner_id not between", value1, value2, "questionerId");
            return (Criteria) this;
        }
        public Criteria andAnswererIdIsNull() {
            addCriterion("answerer_id is null");
            return (Criteria) this;
        }
        public Criteria andAnswererIdIsNotNull() {
            addCriterion("answerer_id is not null");
            return (Criteria) this;
        }
        public Criteria andAnswererIdEqualTo(Long value) {
            addCriterion("answerer_id =", value, "answererId");
            return (Criteria) this;
        }
        public Criteria andAnswererIdNotEqualTo(Long value) {
            addCriterion("answerer_id <>", value, "answererId");
            return (Criteria) this;
        }
        public Criteria andAnswererIdGreaterThan(Long value) {
            addCriterion("answerer_id >", value, "answererId");
            return (Criteria) this;
        }
        public Criteria andAnswererIdGreaterThanOrEqualTo(Long value) {
            addCriterion("answerer_id >=", value, "answererId");
            return (Criteria) this;
        }
        public Criteria andAnswererIdLessThan(Long value) {
            addCriterion("answerer_id <", value, "answererId");
            return (Criteria) this;
        }
        public Criteria andAnswererIdLessThanOrEqualTo(Long value) {
            addCriterion("answerer_id <=", value, "answererId");
            return (Criteria) this;
        }
        public Criteria andAnswererIdIn(List<Long> values) {
            addCriterion("answerer_id in", values, "answererId");
            return (Criteria) this;
        }
        public Criteria andAnswererIdNotIn(List<Long> values) {
            addCriterion("answerer_id not in", values, "answererId");
            return (Criteria) this;
        }
        public Criteria andAnswererIdBetween(Long value1, Long value2) {
            addCriterion("answerer_id between", value1, value2, "answererId");
            return (Criteria) this;
        }
        public Criteria andAnswererIdNotBetween(Long value1, Long value2) {
            addCriterion("answerer_id not between", value1, value2, "answererId");
            return (Criteria) this;
        }
    }

    /**
    * 绿驰汽车
    * tableName: news_feedback
    * @author zhaoyb
    */
    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
    * 绿驰汽车
    * tableName: news_feedback
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