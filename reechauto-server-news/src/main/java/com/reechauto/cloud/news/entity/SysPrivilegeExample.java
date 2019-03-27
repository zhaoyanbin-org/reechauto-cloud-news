package com.reechauto.cloud.news.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysPrivilegeExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;
    protected Integer limitStart;
    protected Integer offset;

    public SysPrivilegeExample() {
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
    * tableName: sys_privilege
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
        public Criteria andRoleIdIsNull() {
            addCriterion("role_id is null");
            return (Criteria) this;
        }
        public Criteria andRoleIdIsNotNull() {
            addCriterion("role_id is not null");
            return (Criteria) this;
        }
        public Criteria andRoleIdEqualTo(String value) {
            addCriterion("role_id =", value, "roleId");
            return (Criteria) this;
        }
        public Criteria andRoleIdNotEqualTo(String value) {
            addCriterion("role_id <>", value, "roleId");
            return (Criteria) this;
        }
        public Criteria andRoleIdGreaterThan(String value) {
            addCriterion("role_id >", value, "roleId");
            return (Criteria) this;
        }
        public Criteria andRoleIdGreaterThanOrEqualTo(String value) {
            addCriterion("role_id >=", value, "roleId");
            return (Criteria) this;
        }
        public Criteria andRoleIdLessThan(String value) {
            addCriterion("role_id <", value, "roleId");
            return (Criteria) this;
        }
        public Criteria andRoleIdLessThanOrEqualTo(String value) {
            addCriterion("role_id <=", value, "roleId");
            return (Criteria) this;
        }
        public Criteria andRoleIdLike(String value) {
            addCriterion("role_id like", value, "roleId");
            return (Criteria) this;
        }
        public Criteria andRoleIdNotLike(String value) {
            addCriterion("role_id not like", value, "roleId");
            return (Criteria) this;
        }
        public Criteria andRoleIdIn(List<String> values) {
            addCriterion("role_id in", values, "roleId");
            return (Criteria) this;
        }
        public Criteria andRoleIdNotIn(List<String> values) {
            addCriterion("role_id not in", values, "roleId");
            return (Criteria) this;
        }
        public Criteria andRoleIdBetween(String value1, String value2) {
            addCriterion("role_id between", value1, value2, "roleId");
            return (Criteria) this;
        }
        public Criteria andRoleIdNotBetween(String value1, String value2) {
            addCriterion("role_id not between", value1, value2, "roleId");
            return (Criteria) this;
        }
        public Criteria andMenuIdIsNull() {
            addCriterion("menu_id is null");
            return (Criteria) this;
        }
        public Criteria andMenuIdIsNotNull() {
            addCriterion("menu_id is not null");
            return (Criteria) this;
        }
        public Criteria andMenuIdEqualTo(Long value) {
            addCriterion("menu_id =", value, "menuId");
            return (Criteria) this;
        }
        public Criteria andMenuIdNotEqualTo(Long value) {
            addCriterion("menu_id <>", value, "menuId");
            return (Criteria) this;
        }
        public Criteria andMenuIdGreaterThan(Long value) {
            addCriterion("menu_id >", value, "menuId");
            return (Criteria) this;
        }
        public Criteria andMenuIdGreaterThanOrEqualTo(Long value) {
            addCriterion("menu_id >=", value, "menuId");
            return (Criteria) this;
        }
        public Criteria andMenuIdLessThan(Long value) {
            addCriterion("menu_id <", value, "menuId");
            return (Criteria) this;
        }
        public Criteria andMenuIdLessThanOrEqualTo(Long value) {
            addCriterion("menu_id <=", value, "menuId");
            return (Criteria) this;
        }
        public Criteria andMenuIdIn(List<Long> values) {
            addCriterion("menu_id in", values, "menuId");
            return (Criteria) this;
        }
        public Criteria andMenuIdNotIn(List<Long> values) {
            addCriterion("menu_id not in", values, "menuId");
            return (Criteria) this;
        }
        public Criteria andMenuIdBetween(Long value1, Long value2) {
            addCriterion("menu_id between", value1, value2, "menuId");
            return (Criteria) this;
        }
        public Criteria andMenuIdNotBetween(Long value1, Long value2) {
            addCriterion("menu_id not between", value1, value2, "menuId");
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
        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }
        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }
        public Criteria andCreateByEqualTo(Long value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }
        public Criteria andCreateByNotEqualTo(Long value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }
        public Criteria andCreateByGreaterThan(Long value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }
        public Criteria andCreateByGreaterThanOrEqualTo(Long value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }
        public Criteria andCreateByLessThan(Long value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }
        public Criteria andCreateByLessThanOrEqualTo(Long value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }
        public Criteria andCreateByIn(List<Long> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }
        public Criteria andCreateByNotIn(List<Long> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }
        public Criteria andCreateByBetween(Long value1, Long value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }
        public Criteria andCreateByNotBetween(Long value1, Long value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
            return (Criteria) this;
        }
    }

    /**
    * 绿驰汽车
    * tableName: sys_privilege
    * @author zhaoyb
    */
    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
    * 绿驰汽车
    * tableName: sys_privilege
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