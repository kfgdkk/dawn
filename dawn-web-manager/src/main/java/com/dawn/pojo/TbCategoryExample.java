package com.dawn.pojo;

import java.util.ArrayList;
import java.util.List;

public class TbCategoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbCategoryExample() {
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

        public Criteria andCategordIdIsNull() {
            addCriterion("categord_id is null");
            return (Criteria) this;
        }

        public Criteria andCategordIdIsNotNull() {
            addCriterion("categord_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategordIdEqualTo(Long value) {
            addCriterion("categord_id =", value, "categordId");
            return (Criteria) this;
        }

        public Criteria andCategordIdNotEqualTo(Long value) {
            addCriterion("categord_id <>", value, "categordId");
            return (Criteria) this;
        }

        public Criteria andCategordIdGreaterThan(Long value) {
            addCriterion("categord_id >", value, "categordId");
            return (Criteria) this;
        }

        public Criteria andCategordIdGreaterThanOrEqualTo(Long value) {
            addCriterion("categord_id >=", value, "categordId");
            return (Criteria) this;
        }

        public Criteria andCategordIdLessThan(Long value) {
            addCriterion("categord_id <", value, "categordId");
            return (Criteria) this;
        }

        public Criteria andCategordIdLessThanOrEqualTo(Long value) {
            addCriterion("categord_id <=", value, "categordId");
            return (Criteria) this;
        }

        public Criteria andCategordIdIn(List<Long> values) {
            addCriterion("categord_id in", values, "categordId");
            return (Criteria) this;
        }

        public Criteria andCategordIdNotIn(List<Long> values) {
            addCriterion("categord_id not in", values, "categordId");
            return (Criteria) this;
        }

        public Criteria andCategordIdBetween(Long value1, Long value2) {
            addCriterion("categord_id between", value1, value2, "categordId");
            return (Criteria) this;
        }

        public Criteria andCategordIdNotBetween(Long value1, Long value2) {
            addCriterion("categord_id not between", value1, value2, "categordId");
            return (Criteria) this;
        }

        public Criteria andClassnameIsNull() {
            addCriterion("classname is null");
            return (Criteria) this;
        }

        public Criteria andClassnameIsNotNull() {
            addCriterion("classname is not null");
            return (Criteria) this;
        }

        public Criteria andClassnameEqualTo(String value) {
            addCriterion("classname =", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotEqualTo(String value) {
            addCriterion("classname <>", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameGreaterThan(String value) {
            addCriterion("classname >", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameGreaterThanOrEqualTo(String value) {
            addCriterion("classname >=", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameLessThan(String value) {
            addCriterion("classname <", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameLessThanOrEqualTo(String value) {
            addCriterion("classname <=", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameLike(String value) {
            addCriterion("classname like", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotLike(String value) {
            addCriterion("classname not like", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameIn(List<String> values) {
            addCriterion("classname in", values, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotIn(List<String> values) {
            addCriterion("classname not in", values, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameBetween(String value1, String value2) {
            addCriterion("classname between", value1, value2, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotBetween(String value1, String value2) {
            addCriterion("classname not between", value1, value2, "classname");
            return (Criteria) this;
        }

        public Criteria andParentidIsNull() {
            addCriterion("parentId is null");
            return (Criteria) this;
        }

        public Criteria andParentidIsNotNull() {
            addCriterion("parentId is not null");
            return (Criteria) this;
        }

        public Criteria andParentidEqualTo(Long value) {
            addCriterion("parentId =", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotEqualTo(Long value) {
            addCriterion("parentId <>", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThan(Long value) {
            addCriterion("parentId >", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThanOrEqualTo(Long value) {
            addCriterion("parentId >=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThan(Long value) {
            addCriterion("parentId <", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThanOrEqualTo(Long value) {
            addCriterion("parentId <=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidIn(List<Long> values) {
            addCriterion("parentId in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotIn(List<Long> values) {
            addCriterion("parentId not in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidBetween(Long value1, Long value2) {
            addCriterion("parentId between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotBetween(Long value1, Long value2) {
            addCriterion("parentId not between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNull() {
            addCriterion("created is null");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNotNull() {
            addCriterion("created is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedEqualTo(String value) {
            addCriterion("created =", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotEqualTo(String value) {
            addCriterion("created <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(String value) {
            addCriterion("created >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(String value) {
            addCriterion("created >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(String value) {
            addCriterion("created <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(String value) {
            addCriterion("created <=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLike(String value) {
            addCriterion("created like", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotLike(String value) {
            addCriterion("created not like", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedIn(List<String> values) {
            addCriterion("created in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<String> values) {
            addCriterion("created not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(String value1, String value2) {
            addCriterion("created between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(String value1, String value2) {
            addCriterion("created not between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNull() {
            addCriterion("updated is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNotNull() {
            addCriterion("updated is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedEqualTo(String value) {
            addCriterion("updated =", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotEqualTo(String value) {
            addCriterion("updated <>", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThan(String value) {
            addCriterion("updated >", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThanOrEqualTo(String value) {
            addCriterion("updated >=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThan(String value) {
            addCriterion("updated <", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThanOrEqualTo(String value) {
            addCriterion("updated <=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLike(String value) {
            addCriterion("updated like", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotLike(String value) {
            addCriterion("updated not like", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedIn(List<String> values) {
            addCriterion("updated in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotIn(List<String> values) {
            addCriterion("updated not in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedBetween(String value1, String value2) {
            addCriterion("updated between", value1, value2, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotBetween(String value1, String value2) {
            addCriterion("updated not between", value1, value2, "updated");
            return (Criteria) this;
        }

        public Criteria andTbDescIdsIsNull() {
            addCriterion("tb_desc_ids is null");
            return (Criteria) this;
        }

        public Criteria andTbDescIdsIsNotNull() {
            addCriterion("tb_desc_ids is not null");
            return (Criteria) this;
        }

        public Criteria andTbDescIdsEqualTo(String value) {
            addCriterion("tb_desc_ids =", value, "tbDescIds");
            return (Criteria) this;
        }

        public Criteria andTbDescIdsNotEqualTo(String value) {
            addCriterion("tb_desc_ids <>", value, "tbDescIds");
            return (Criteria) this;
        }

        public Criteria andTbDescIdsGreaterThan(String value) {
            addCriterion("tb_desc_ids >", value, "tbDescIds");
            return (Criteria) this;
        }

        public Criteria andTbDescIdsGreaterThanOrEqualTo(String value) {
            addCriterion("tb_desc_ids >=", value, "tbDescIds");
            return (Criteria) this;
        }

        public Criteria andTbDescIdsLessThan(String value) {
            addCriterion("tb_desc_ids <", value, "tbDescIds");
            return (Criteria) this;
        }

        public Criteria andTbDescIdsLessThanOrEqualTo(String value) {
            addCriterion("tb_desc_ids <=", value, "tbDescIds");
            return (Criteria) this;
        }

        public Criteria andTbDescIdsLike(String value) {
            addCriterion("tb_desc_ids like", value, "tbDescIds");
            return (Criteria) this;
        }

        public Criteria andTbDescIdsNotLike(String value) {
            addCriterion("tb_desc_ids not like", value, "tbDescIds");
            return (Criteria) this;
        }

        public Criteria andTbDescIdsIn(List<String> values) {
            addCriterion("tb_desc_ids in", values, "tbDescIds");
            return (Criteria) this;
        }

        public Criteria andTbDescIdsNotIn(List<String> values) {
            addCriterion("tb_desc_ids not in", values, "tbDescIds");
            return (Criteria) this;
        }

        public Criteria andTbDescIdsBetween(String value1, String value2) {
            addCriterion("tb_desc_ids between", value1, value2, "tbDescIds");
            return (Criteria) this;
        }

        public Criteria andTbDescIdsNotBetween(String value1, String value2) {
            addCriterion("tb_desc_ids not between", value1, value2, "tbDescIds");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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