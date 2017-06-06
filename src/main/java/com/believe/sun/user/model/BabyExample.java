package com.believe.sun.user.model;

import java.util.ArrayList;
import java.util.List;

public class BabyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BabyExample() {
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

        public Criteria andBabyNameIsNull() {
            addCriterion("baby_name is null");
            return (Criteria) this;
        }

        public Criteria andBabyNameIsNotNull() {
            addCriterion("baby_name is not null");
            return (Criteria) this;
        }

        public Criteria andBabyNameEqualTo(String value) {
            addCriterion("baby_name =", value, "babyName");
            return (Criteria) this;
        }

        public Criteria andBabyNameNotEqualTo(String value) {
            addCriterion("baby_name <>", value, "babyName");
            return (Criteria) this;
        }

        public Criteria andBabyNameGreaterThan(String value) {
            addCriterion("baby_name >", value, "babyName");
            return (Criteria) this;
        }

        public Criteria andBabyNameGreaterThanOrEqualTo(String value) {
            addCriterion("baby_name >=", value, "babyName");
            return (Criteria) this;
        }

        public Criteria andBabyNameLessThan(String value) {
            addCriterion("baby_name <", value, "babyName");
            return (Criteria) this;
        }

        public Criteria andBabyNameLessThanOrEqualTo(String value) {
            addCriterion("baby_name <=", value, "babyName");
            return (Criteria) this;
        }

        public Criteria andBabyNameLike(String value) {
            addCriterion("baby_name like", value, "babyName");
            return (Criteria) this;
        }

        public Criteria andBabyNameNotLike(String value) {
            addCriterion("baby_name not like", value, "babyName");
            return (Criteria) this;
        }

        public Criteria andBabyNameIn(List<String> values) {
            addCriterion("baby_name in", values, "babyName");
            return (Criteria) this;
        }

        public Criteria andBabyNameNotIn(List<String> values) {
            addCriterion("baby_name not in", values, "babyName");
            return (Criteria) this;
        }

        public Criteria andBabyNameBetween(String value1, String value2) {
            addCriterion("baby_name between", value1, value2, "babyName");
            return (Criteria) this;
        }

        public Criteria andBabyNameNotBetween(String value1, String value2) {
            addCriterion("baby_name not between", value1, value2, "babyName");
            return (Criteria) this;
        }

        public Criteria andBabyAgeIsNull() {
            addCriterion("baby_age is null");
            return (Criteria) this;
        }

        public Criteria andBabyAgeIsNotNull() {
            addCriterion("baby_age is not null");
            return (Criteria) this;
        }

        public Criteria andBabyAgeEqualTo(Integer value) {
            addCriterion("baby_age =", value, "babyAge");
            return (Criteria) this;
        }

        public Criteria andBabyAgeNotEqualTo(Integer value) {
            addCriterion("baby_age <>", value, "babyAge");
            return (Criteria) this;
        }

        public Criteria andBabyAgeGreaterThan(Integer value) {
            addCriterion("baby_age >", value, "babyAge");
            return (Criteria) this;
        }

        public Criteria andBabyAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("baby_age >=", value, "babyAge");
            return (Criteria) this;
        }

        public Criteria andBabyAgeLessThan(Integer value) {
            addCriterion("baby_age <", value, "babyAge");
            return (Criteria) this;
        }

        public Criteria andBabyAgeLessThanOrEqualTo(Integer value) {
            addCriterion("baby_age <=", value, "babyAge");
            return (Criteria) this;
        }

        public Criteria andBabyAgeIn(List<Integer> values) {
            addCriterion("baby_age in", values, "babyAge");
            return (Criteria) this;
        }

        public Criteria andBabyAgeNotIn(List<Integer> values) {
            addCriterion("baby_age not in", values, "babyAge");
            return (Criteria) this;
        }

        public Criteria andBabyAgeBetween(Integer value1, Integer value2) {
            addCriterion("baby_age between", value1, value2, "babyAge");
            return (Criteria) this;
        }

        public Criteria andBabyAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("baby_age not between", value1, value2, "babyAge");
            return (Criteria) this;
        }

        public Criteria andBabySexIsNull() {
            addCriterion("baby_sex is null");
            return (Criteria) this;
        }

        public Criteria andBabySexIsNotNull() {
            addCriterion("baby_sex is not null");
            return (Criteria) this;
        }

        public Criteria andBabySexEqualTo(Integer value) {
            addCriterion("baby_sex =", value, "babySex");
            return (Criteria) this;
        }

        public Criteria andBabySexNotEqualTo(Integer value) {
            addCriterion("baby_sex <>", value, "babySex");
            return (Criteria) this;
        }

        public Criteria andBabySexGreaterThan(Integer value) {
            addCriterion("baby_sex >", value, "babySex");
            return (Criteria) this;
        }

        public Criteria andBabySexGreaterThanOrEqualTo(Integer value) {
            addCriterion("baby_sex >=", value, "babySex");
            return (Criteria) this;
        }

        public Criteria andBabySexLessThan(Integer value) {
            addCriterion("baby_sex <", value, "babySex");
            return (Criteria) this;
        }

        public Criteria andBabySexLessThanOrEqualTo(Integer value) {
            addCriterion("baby_sex <=", value, "babySex");
            return (Criteria) this;
        }

        public Criteria andBabySexIn(List<Integer> values) {
            addCriterion("baby_sex in", values, "babySex");
            return (Criteria) this;
        }

        public Criteria andBabySexNotIn(List<Integer> values) {
            addCriterion("baby_sex not in", values, "babySex");
            return (Criteria) this;
        }

        public Criteria andBabySexBetween(Integer value1, Integer value2) {
            addCriterion("baby_sex between", value1, value2, "babySex");
            return (Criteria) this;
        }

        public Criteria andBabySexNotBetween(Integer value1, Integer value2) {
            addCriterion("baby_sex not between", value1, value2, "babySex");
            return (Criteria) this;
        }

        public Criteria andBabyNicknameIsNull() {
            addCriterion("baby_nickName is null");
            return (Criteria) this;
        }

        public Criteria andBabyNicknameIsNotNull() {
            addCriterion("baby_nickName is not null");
            return (Criteria) this;
        }

        public Criteria andBabyNicknameEqualTo(String value) {
            addCriterion("baby_nickName =", value, "babyNickname");
            return (Criteria) this;
        }

        public Criteria andBabyNicknameNotEqualTo(String value) {
            addCriterion("baby_nickName <>", value, "babyNickname");
            return (Criteria) this;
        }

        public Criteria andBabyNicknameGreaterThan(String value) {
            addCriterion("baby_nickName >", value, "babyNickname");
            return (Criteria) this;
        }

        public Criteria andBabyNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("baby_nickName >=", value, "babyNickname");
            return (Criteria) this;
        }

        public Criteria andBabyNicknameLessThan(String value) {
            addCriterion("baby_nickName <", value, "babyNickname");
            return (Criteria) this;
        }

        public Criteria andBabyNicknameLessThanOrEqualTo(String value) {
            addCriterion("baby_nickName <=", value, "babyNickname");
            return (Criteria) this;
        }

        public Criteria andBabyNicknameLike(String value) {
            addCriterion("baby_nickName like", value, "babyNickname");
            return (Criteria) this;
        }

        public Criteria andBabyNicknameNotLike(String value) {
            addCriterion("baby_nickName not like", value, "babyNickname");
            return (Criteria) this;
        }

        public Criteria andBabyNicknameIn(List<String> values) {
            addCriterion("baby_nickName in", values, "babyNickname");
            return (Criteria) this;
        }

        public Criteria andBabyNicknameNotIn(List<String> values) {
            addCriterion("baby_nickName not in", values, "babyNickname");
            return (Criteria) this;
        }

        public Criteria andBabyNicknameBetween(String value1, String value2) {
            addCriterion("baby_nickName between", value1, value2, "babyNickname");
            return (Criteria) this;
        }

        public Criteria andBabyNicknameNotBetween(String value1, String value2) {
            addCriterion("baby_nickName not between", value1, value2, "babyNickname");
            return (Criteria) this;
        }

        public Criteria andBabyHeadimageIsNull() {
            addCriterion("baby_headimage is null");
            return (Criteria) this;
        }

        public Criteria andBabyHeadimageIsNotNull() {
            addCriterion("baby_headimage is not null");
            return (Criteria) this;
        }

        public Criteria andBabyHeadimageEqualTo(String value) {
            addCriterion("baby_headimage =", value, "babyHeadimage");
            return (Criteria) this;
        }

        public Criteria andBabyHeadimageNotEqualTo(String value) {
            addCriterion("baby_headimage <>", value, "babyHeadimage");
            return (Criteria) this;
        }

        public Criteria andBabyHeadimageGreaterThan(String value) {
            addCriterion("baby_headimage >", value, "babyHeadimage");
            return (Criteria) this;
        }

        public Criteria andBabyHeadimageGreaterThanOrEqualTo(String value) {
            addCriterion("baby_headimage >=", value, "babyHeadimage");
            return (Criteria) this;
        }

        public Criteria andBabyHeadimageLessThan(String value) {
            addCriterion("baby_headimage <", value, "babyHeadimage");
            return (Criteria) this;
        }

        public Criteria andBabyHeadimageLessThanOrEqualTo(String value) {
            addCriterion("baby_headimage <=", value, "babyHeadimage");
            return (Criteria) this;
        }

        public Criteria andBabyHeadimageLike(String value) {
            addCriterion("baby_headimage like", value, "babyHeadimage");
            return (Criteria) this;
        }

        public Criteria andBabyHeadimageNotLike(String value) {
            addCriterion("baby_headimage not like", value, "babyHeadimage");
            return (Criteria) this;
        }

        public Criteria andBabyHeadimageIn(List<String> values) {
            addCriterion("baby_headimage in", values, "babyHeadimage");
            return (Criteria) this;
        }

        public Criteria andBabyHeadimageNotIn(List<String> values) {
            addCriterion("baby_headimage not in", values, "babyHeadimage");
            return (Criteria) this;
        }

        public Criteria andBabyHeadimageBetween(String value1, String value2) {
            addCriterion("baby_headimage between", value1, value2, "babyHeadimage");
            return (Criteria) this;
        }

        public Criteria andBabyHeadimageNotBetween(String value1, String value2) {
            addCriterion("baby_headimage not between", value1, value2, "babyHeadimage");
            return (Criteria) this;
        }

        public Criteria andPhotoIsNull() {
            addCriterion("photo is null");
            return (Criteria) this;
        }

        public Criteria andPhotoIsNotNull() {
            addCriterion("photo is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoEqualTo(String value) {
            addCriterion("photo =", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotEqualTo(String value) {
            addCriterion("photo <>", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoGreaterThan(String value) {
            addCriterion("photo >", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("photo >=", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLessThan(String value) {
            addCriterion("photo <", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLessThanOrEqualTo(String value) {
            addCriterion("photo <=", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLike(String value) {
            addCriterion("photo like", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotLike(String value) {
            addCriterion("photo not like", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoIn(List<String> values) {
            addCriterion("photo in", values, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotIn(List<String> values) {
            addCriterion("photo not in", values, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoBetween(String value1, String value2) {
            addCriterion("photo between", value1, value2, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotBetween(String value1, String value2) {
            addCriterion("photo not between", value1, value2, "photo");
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