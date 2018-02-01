package com.dawn.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbTitleExample implements Serializable {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public TbTitleExample() {
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

		public Criteria andTbtitleIdIsNull() {
			addCriterion("tbtitle_id is null");
			return (Criteria) this;
		}

		public Criteria andTbtitleIdIsNotNull() {
			addCriterion("tbtitle_id is not null");
			return (Criteria) this;
		}

		public Criteria andTbtitleIdEqualTo(Long value) {
			addCriterion("tbtitle_id =", value, "tbtitleId");
			return (Criteria) this;
		}

		public Criteria andTbtitleEqualTo(String value) {
			addCriterion("title =", value, "title");
			return (Criteria) this;
		}

		public Criteria andTbtitleIdNotEqualTo(Long value) {
			addCriterion("tbtitle_id <>", value, "tbtitleId");
			return (Criteria) this;
		}

		public Criteria andTbtitleIdGreaterThan(Long value) {
			addCriterion("tbtitle_id >", value, "tbtitleId");
			return (Criteria) this;
		}

		public Criteria andTbtitleIdGreaterThanOrEqualTo(Long value) {
			addCriterion("tbtitle_id >=", value, "tbtitleId");
			return (Criteria) this;
		}

		public Criteria andTbtitleIdLessThan(Long value) {
			addCriterion("tbtitle_id <", value, "tbtitleId");
			return (Criteria) this;
		}

		public Criteria andTbtitleIdLessThanOrEqualTo(Long value) {
			addCriterion("tbtitle_id <=", value, "tbtitleId");
			return (Criteria) this;
		}

		public Criteria andTbtitleIdIn(List<Long> values) {
			addCriterion("tbtitle_id in", values, "tbtitleId");
			return (Criteria) this;
		}

		public Criteria andTbtitleIdNotIn(List<Long> values) {
			addCriterion("tbtitle_id not in", values, "tbtitleId");
			return (Criteria) this;
		}

		public Criteria andTbtitleIdBetween(Long value1, Long value2) {
			addCriterion("tbtitle_id between", value1, value2, "tbtitleId");
			return (Criteria) this;
		}

		public Criteria andTbtitleIdNotBetween(Long value1, Long value2) {
			addCriterion("tbtitle_id not between", value1, value2, "tbtitleId");
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

		public Criteria andCreatedEqualTo(Date value) {
			addCriterion("created =", value, "created");
			return (Criteria) this;
		}

		public Criteria andCreatedNotEqualTo(Date value) {
			addCriterion("created <>", value, "created");
			return (Criteria) this;
		}

		public Criteria andCreatedGreaterThan(Date value) {
			addCriterion("created >", value, "created");
			return (Criteria) this;
		}

		public Criteria andCreatedGreaterThanOrEqualTo(Date value) {
			addCriterion("created >=", value, "created");
			return (Criteria) this;
		}

		public Criteria andCreatedLessThan(Date value) {
			addCriterion("created <", value, "created");
			return (Criteria) this;
		}

		public Criteria andCreatedLessThanOrEqualTo(Date value) {
			addCriterion("created <=", value, "created");
			return (Criteria) this;
		}

		public Criteria andCreatedIn(List<Date> values) {
			addCriterion("created in", values, "created");
			return (Criteria) this;
		}

		public Criteria andCreatedNotIn(List<Date> values) {
			addCriterion("created not in", values, "created");
			return (Criteria) this;
		}

		public Criteria andCreatedBetween(Date value1, Date value2) {
			addCriterion("created between", value1, value2, "created");
			return (Criteria) this;
		}

		public Criteria andCreatedNotBetween(Date value1, Date value2) {
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

		public Criteria andUpdatedEqualTo(Date value) {
			addCriterion("updated =", value, "updated");
			return (Criteria) this;
		}

		public Criteria andUpdatedNotEqualTo(Date value) {
			addCriterion("updated <>", value, "updated");
			return (Criteria) this;
		}

		public Criteria andUpdatedGreaterThan(Date value) {
			addCriterion("updated >", value, "updated");
			return (Criteria) this;
		}

		public Criteria andUpdatedGreaterThanOrEqualTo(Date value) {
			addCriterion("updated >=", value, "updated");
			return (Criteria) this;
		}

		public Criteria andUpdatedLessThan(Date value) {
			addCriterion("updated <", value, "updated");
			return (Criteria) this;
		}

		public Criteria andUpdatedLessThanOrEqualTo(Date value) {
			addCriterion("updated <=", value, "updated");
			return (Criteria) this;
		}

		public Criteria andUpdatedIn(List<Date> values) {
			addCriterion("updated in", values, "updated");
			return (Criteria) this;
		}

		public Criteria andUpdatedNotIn(List<Date> values) {
			addCriterion("updated not in", values, "updated");
			return (Criteria) this;
		}

		public Criteria andUpdatedBetween(Date value1, Date value2) {
			addCriterion("updated between", value1, value2, "updated");
			return (Criteria) this;
		}

		public Criteria andUpdatedNotBetween(Date value1, Date value2) {
			addCriterion("updated not between", value1, value2, "updated");
			return (Criteria) this;
		}

		public Criteria andClicknumIsNull() {
			addCriterion("clicknum is null");
			return (Criteria) this;
		}

		public Criteria andClicknumIsNotNull() {
			addCriterion("clicknum is not null");
			return (Criteria) this;
		}

		public Criteria andClicknumEqualTo(Long value) {
			addCriterion("clicknum =", value, "clicknum");
			return (Criteria) this;
		}

		public Criteria andClicknumNotEqualTo(Long value) {
			addCriterion("clicknum <>", value, "clicknum");
			return (Criteria) this;
		}

		public Criteria andClicknumGreaterThan(Long value) {
			addCriterion("clicknum >", value, "clicknum");
			return (Criteria) this;
		}

		public Criteria andClicknumGreaterThanOrEqualTo(Long value) {
			addCriterion("clicknum >=", value, "clicknum");
			return (Criteria) this;
		}

		public Criteria andClicknumLessThan(Long value) {
			addCriterion("clicknum <", value, "clicknum");
			return (Criteria) this;
		}

		public Criteria andClicknumLessThanOrEqualTo(Long value) {
			addCriterion("clicknum <=", value, "clicknum");
			return (Criteria) this;
		}

		public Criteria andClicknumIn(List<Long> values) {
			addCriterion("clicknum in", values, "clicknum");
			return (Criteria) this;
		}

		public Criteria andClicknumNotIn(List<Long> values) {
			addCriterion("clicknum not in", values, "clicknum");
			return (Criteria) this;
		}

		public Criteria andClicknumBetween(Long value1, Long value2) {
			addCriterion("clicknum between", value1, value2, "clicknum");
			return (Criteria) this;
		}

		public Criteria andClicknumNotBetween(Long value1, Long value2) {
			addCriterion("clicknum not between", value1, value2, "clicknum");
			return (Criteria) this;
		}

		public Criteria andCategoryIdIsNull() {
			addCriterion("category_id is null");
			return (Criteria) this;
		}

		public Criteria andCategoryIdIsNotNull() {
			addCriterion("category_id is not null");
			return (Criteria) this;
		}

		public Criteria andCategoryIdEqualTo(Long value) {
			addCriterion("category_id =", value, "categoryId");
			return (Criteria) this;
		}

		public Criteria andCategoryIdNotEqualTo(Long value) {
			addCriterion("category_id <>", value, "categoryId");
			return (Criteria) this;
		}

		public Criteria andCategoryIdGreaterThan(Long value) {
			addCriterion("category_id >", value, "categoryId");
			return (Criteria) this;
		}

		public Criteria andCategoryIdGreaterThanOrEqualTo(Long value) {
			addCriterion("category_id >=", value, "categoryId");
			return (Criteria) this;
		}

		public Criteria andCategoryIdLessThan(Long value) {
			addCriterion("category_id <", value, "categoryId");
			return (Criteria) this;
		}

		public Criteria andCategoryIdLessThanOrEqualTo(Long value) {
			addCriterion("category_id <=", value, "categoryId");
			return (Criteria) this;
		}

		public Criteria andCategoryIdIn(List<Long> values) {
			addCriterion("category_id in", values, "categoryId");
			return (Criteria) this;
		}

		public Criteria andCategoryIdNotIn(List<Long> values) {
			addCriterion("category_id not in", values, "categoryId");
			return (Criteria) this;
		}

		public Criteria andCategoryIdBetween(Long value1, Long value2) {
			addCriterion("category_id between", value1, value2, "categoryId");
			return (Criteria) this;
		}

		public Criteria andCategoryIdNotBetween(Long value1, Long value2) {
			addCriterion("category_id not between", value1, value2, "categoryId");
			return (Criteria) this;
		}

		public Criteria andAuditStatusIsNull() {
			addCriterion("audit_status is null");
			return (Criteria) this;
		}

		public Criteria andAuditStatusIsNotNull() {
			addCriterion("audit_status is not null");
			return (Criteria) this;
		}

		public Criteria andAuditStatusEqualTo(String value) {
			addCriterion("audit_status =", value, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andAuditStatusNotEqualTo(String value) {
			addCriterion("audit_status <>", value, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andAuditStatusGreaterThan(String value) {
			addCriterion("audit_status >", value, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andAuditStatusGreaterThanOrEqualTo(String value) {
			addCriterion("audit_status >=", value, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andAuditStatusLessThan(String value) {
			addCriterion("audit_status <", value, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andAuditStatusLessThanOrEqualTo(String value) {
			addCriterion("audit_status <=", value, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andAuditStatusLike(String value) {
			addCriterion("audit_status like", value, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andAuditStatusNotLike(String value) {
			addCriterion("audit_status not like", value, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andAuditStatusIn(List<String> values) {
			addCriterion("audit_status in", values, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andAuditStatusNotIn(List<String> values) {
			addCriterion("audit_status not in", values, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andAuditStatusBetween(String value1, String value2) {
			addCriterion("audit_status between", value1, value2, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andAuditStatusNotBetween(String value1, String value2) {
			addCriterion("audit_status not between", value1, value2, "auditStatus");
			return (Criteria) this;
		}

		public Criteria andUseridIsNull() {
			addCriterion("userid is null");
			return (Criteria) this;
		}

		public Criteria andUseridIsNotNull() {
			addCriterion("userid is not null");
			return (Criteria) this;
		}

		public Criteria andUseridEqualTo(Integer value) {
			addCriterion("userid =", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridNotEqualTo(Integer value) {
			addCriterion("userid <>", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridGreaterThan(Integer value) {
			addCriterion("userid >", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
			addCriterion("userid >=", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridLessThan(Integer value) {
			addCriterion("userid <", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridLessThanOrEqualTo(Integer value) {
			addCriterion("userid <=", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridIn(List<Integer> values) {
			addCriterion("userid in", values, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridNotIn(List<Integer> values) {
			addCriterion("userid not in", values, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridBetween(Integer value1, Integer value2) {
			addCriterion("userid between", value1, value2, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridNotBetween(Integer value1, Integer value2) {
			addCriterion("userid not between", value1, value2, "userid");
			return (Criteria) this;
		}

		public Criteria andCauseIsNull() {
			addCriterion("cause is null");
			return (Criteria) this;
		}

		public Criteria andCauseIsNotNull() {
			addCriterion("cause is not null");
			return (Criteria) this;
		}

		public Criteria andCauseEqualTo(String value) {
			addCriterion("cause =", value, "cause");
			return (Criteria) this;
		}

		public Criteria andCauseNotEqualTo(String value) {
			addCriterion("cause <>", value, "cause");
			return (Criteria) this;
		}

		public Criteria andCauseGreaterThan(String value) {
			addCriterion("cause >", value, "cause");
			return (Criteria) this;
		}

		public Criteria andCauseGreaterThanOrEqualTo(String value) {
			addCriterion("cause >=", value, "cause");
			return (Criteria) this;
		}

		public Criteria andCauseLessThan(String value) {
			addCriterion("cause <", value, "cause");
			return (Criteria) this;
		}

		public Criteria andCauseLessThanOrEqualTo(String value) {
			addCriterion("cause <=", value, "cause");
			return (Criteria) this;
		}

		public Criteria andCauseLike(String value) {
			addCriterion("cause like", value, "cause");
			return (Criteria) this;
		}

		public Criteria andCauseNotLike(String value) {
			addCriterion("cause not like", value, "cause");
			return (Criteria) this;
		}

		public Criteria andCauseIn(List<String> values) {
			addCriterion("cause in", values, "cause");
			return (Criteria) this;
		}

		public Criteria andCauseNotIn(List<String> values) {
			addCriterion("cause not in", values, "cause");
			return (Criteria) this;
		}

		public Criteria andCauseBetween(String value1, String value2) {
			addCriterion("cause between", value1, value2, "cause");
			return (Criteria) this;
		}

		public Criteria andCauseNotBetween(String value1, String value2) {
			addCriterion("cause not between", value1, value2, "cause");
			return (Criteria) this;
		}

		public Criteria andUserTypeIsNull() {
			addCriterion("user_type is null");
			return (Criteria) this;
		}

		public Criteria andUserTypeIsNotNull() {
			addCriterion("user_type is not null");
			return (Criteria) this;
		}

		public Criteria andUserTypeEqualTo(Integer value) {
			addCriterion("user_type =", value, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeNotEqualTo(Integer value) {
			addCriterion("user_type <>", value, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeGreaterThan(Integer value) {
			addCriterion("user_type >", value, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("user_type >=", value, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeLessThan(Integer value) {
			addCriterion("user_type <", value, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeLessThanOrEqualTo(Integer value) {
			addCriterion("user_type <=", value, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeIn(List<Integer> values) {
			addCriterion("user_type in", values, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeNotIn(List<Integer> values) {
			addCriterion("user_type not in", values, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeBetween(Integer value1, Integer value2) {
			addCriterion("user_type between", value1, value2, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("user_type not between", value1, value2, "userType");
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