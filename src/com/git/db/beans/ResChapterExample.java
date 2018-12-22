package com.git.db.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResChapterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResChapterExample() {
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBookIdIsNull() {
            addCriterion("BOOK_ID is null");
            return (Criteria) this;
        }

        public Criteria andBookIdIsNotNull() {
            addCriterion("BOOK_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBookIdEqualTo(Integer value) {
            addCriterion("BOOK_ID =", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotEqualTo(Integer value) {
            addCriterion("BOOK_ID <>", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdGreaterThan(Integer value) {
            addCriterion("BOOK_ID >", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("BOOK_ID >=", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdLessThan(Integer value) {
            addCriterion("BOOK_ID <", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdLessThanOrEqualTo(Integer value) {
            addCriterion("BOOK_ID <=", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdIn(List<Integer> values) {
            addCriterion("BOOK_ID in", values, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotIn(List<Integer> values) {
            addCriterion("BOOK_ID not in", values, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdBetween(Integer value1, Integer value2) {
            addCriterion("BOOK_ID between", value1, value2, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotBetween(Integer value1, Integer value2) {
            addCriterion("BOOK_ID not between", value1, value2, "bookId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIsNull() {
            addCriterion("AUTHOR_ID is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIsNotNull() {
            addCriterion("AUTHOR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorIdEqualTo(Integer value) {
            addCriterion("AUTHOR_ID =", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotEqualTo(Integer value) {
            addCriterion("AUTHOR_ID <>", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdGreaterThan(Integer value) {
            addCriterion("AUTHOR_ID >", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("AUTHOR_ID >=", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdLessThan(Integer value) {
            addCriterion("AUTHOR_ID <", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdLessThanOrEqualTo(Integer value) {
            addCriterion("AUTHOR_ID <=", value, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdIn(List<Integer> values) {
            addCriterion("AUTHOR_ID in", values, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotIn(List<Integer> values) {
            addCriterion("AUTHOR_ID not in", values, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdBetween(Integer value1, Integer value2) {
            addCriterion("AUTHOR_ID between", value1, value2, "authorId");
            return (Criteria) this;
        }

        public Criteria andAuthorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("AUTHOR_ID not between", value1, value2, "authorId");
            return (Criteria) this;
        }

        public Criteria andTranslatorIsNull() {
            addCriterion("TRANSLATOR is null");
            return (Criteria) this;
        }

        public Criteria andTranslatorIsNotNull() {
            addCriterion("TRANSLATOR is not null");
            return (Criteria) this;
        }

        public Criteria andTranslatorEqualTo(String value) {
            addCriterion("TRANSLATOR =", value, "translator");
            return (Criteria) this;
        }

        public Criteria andTranslatorNotEqualTo(String value) {
            addCriterion("TRANSLATOR <>", value, "translator");
            return (Criteria) this;
        }

        public Criteria andTranslatorGreaterThan(String value) {
            addCriterion("TRANSLATOR >", value, "translator");
            return (Criteria) this;
        }

        public Criteria andTranslatorGreaterThanOrEqualTo(String value) {
            addCriterion("TRANSLATOR >=", value, "translator");
            return (Criteria) this;
        }

        public Criteria andTranslatorLessThan(String value) {
            addCriterion("TRANSLATOR <", value, "translator");
            return (Criteria) this;
        }

        public Criteria andTranslatorLessThanOrEqualTo(String value) {
            addCriterion("TRANSLATOR <=", value, "translator");
            return (Criteria) this;
        }

        public Criteria andTranslatorLike(String value) {
            addCriterion("TRANSLATOR like", value, "translator");
            return (Criteria) this;
        }

        public Criteria andTranslatorNotLike(String value) {
            addCriterion("TRANSLATOR not like", value, "translator");
            return (Criteria) this;
        }

        public Criteria andTranslatorIn(List<String> values) {
            addCriterion("TRANSLATOR in", values, "translator");
            return (Criteria) this;
        }

        public Criteria andTranslatorNotIn(List<String> values) {
            addCriterion("TRANSLATOR not in", values, "translator");
            return (Criteria) this;
        }

        public Criteria andTranslatorBetween(String value1, String value2) {
            addCriterion("TRANSLATOR between", value1, value2, "translator");
            return (Criteria) this;
        }

        public Criteria andTranslatorNotBetween(String value1, String value2) {
            addCriterion("TRANSLATOR not between", value1, value2, "translator");
            return (Criteria) this;
        }

        public Criteria andChapterNoIsNull() {
            addCriterion("CHAPTER_NO is null");
            return (Criteria) this;
        }

        public Criteria andChapterNoIsNotNull() {
            addCriterion("CHAPTER_NO is not null");
            return (Criteria) this;
        }

        public Criteria andChapterNoEqualTo(Integer value) {
            addCriterion("CHAPTER_NO =", value, "chapterNo");
            return (Criteria) this;
        }

        public Criteria andChapterNoNotEqualTo(Integer value) {
            addCriterion("CHAPTER_NO <>", value, "chapterNo");
            return (Criteria) this;
        }

        public Criteria andChapterNoGreaterThan(Integer value) {
            addCriterion("CHAPTER_NO >", value, "chapterNo");
            return (Criteria) this;
        }

        public Criteria andChapterNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("CHAPTER_NO >=", value, "chapterNo");
            return (Criteria) this;
        }

        public Criteria andChapterNoLessThan(Integer value) {
            addCriterion("CHAPTER_NO <", value, "chapterNo");
            return (Criteria) this;
        }

        public Criteria andChapterNoLessThanOrEqualTo(Integer value) {
            addCriterion("CHAPTER_NO <=", value, "chapterNo");
            return (Criteria) this;
        }

        public Criteria andChapterNoIn(List<Integer> values) {
            addCriterion("CHAPTER_NO in", values, "chapterNo");
            return (Criteria) this;
        }

        public Criteria andChapterNoNotIn(List<Integer> values) {
            addCriterion("CHAPTER_NO not in", values, "chapterNo");
            return (Criteria) this;
        }

        public Criteria andChapterNoBetween(Integer value1, Integer value2) {
            addCriterion("CHAPTER_NO between", value1, value2, "chapterNo");
            return (Criteria) this;
        }

        public Criteria andChapterNoNotBetween(Integer value1, Integer value2) {
            addCriterion("CHAPTER_NO not between", value1, value2, "chapterNo");
            return (Criteria) this;
        }

        public Criteria andNameCnIsNull() {
            addCriterion("NAME_CN is null");
            return (Criteria) this;
        }

        public Criteria andNameCnIsNotNull() {
            addCriterion("NAME_CN is not null");
            return (Criteria) this;
        }

        public Criteria andNameCnEqualTo(String value) {
            addCriterion("NAME_CN =", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnNotEqualTo(String value) {
            addCriterion("NAME_CN <>", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnGreaterThan(String value) {
            addCriterion("NAME_CN >", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnGreaterThanOrEqualTo(String value) {
            addCriterion("NAME_CN >=", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnLessThan(String value) {
            addCriterion("NAME_CN <", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnLessThanOrEqualTo(String value) {
            addCriterion("NAME_CN <=", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnLike(String value) {
            addCriterion("NAME_CN like", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnNotLike(String value) {
            addCriterion("NAME_CN not like", value, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnIn(List<String> values) {
            addCriterion("NAME_CN in", values, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnNotIn(List<String> values) {
            addCriterion("NAME_CN not in", values, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnBetween(String value1, String value2) {
            addCriterion("NAME_CN between", value1, value2, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameCnNotBetween(String value1, String value2) {
            addCriterion("NAME_CN not between", value1, value2, "nameCn");
            return (Criteria) this;
        }

        public Criteria andNameEnIsNull() {
            addCriterion("NAME_EN is null");
            return (Criteria) this;
        }

        public Criteria andNameEnIsNotNull() {
            addCriterion("NAME_EN is not null");
            return (Criteria) this;
        }

        public Criteria andNameEnEqualTo(String value) {
            addCriterion("NAME_EN =", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnNotEqualTo(String value) {
            addCriterion("NAME_EN <>", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnGreaterThan(String value) {
            addCriterion("NAME_EN >", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnGreaterThanOrEqualTo(String value) {
            addCriterion("NAME_EN >=", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnLessThan(String value) {
            addCriterion("NAME_EN <", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnLessThanOrEqualTo(String value) {
            addCriterion("NAME_EN <=", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnLike(String value) {
            addCriterion("NAME_EN like", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnNotLike(String value) {
            addCriterion("NAME_EN not like", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnIn(List<String> values) {
            addCriterion("NAME_EN in", values, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnNotIn(List<String> values) {
            addCriterion("NAME_EN not in", values, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnBetween(String value1, String value2) {
            addCriterion("NAME_EN between", value1, value2, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnNotBetween(String value1, String value2) {
            addCriterion("NAME_EN not between", value1, value2, "nameEn");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNull() {
            addCriterion("SUMMARY is null");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNotNull() {
            addCriterion("SUMMARY is not null");
            return (Criteria) this;
        }

        public Criteria andSummaryEqualTo(String value) {
            addCriterion("SUMMARY =", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotEqualTo(String value) {
            addCriterion("SUMMARY <>", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThan(String value) {
            addCriterion("SUMMARY >", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("SUMMARY >=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThan(String value) {
            addCriterion("SUMMARY <", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThanOrEqualTo(String value) {
            addCriterion("SUMMARY <=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLike(String value) {
            addCriterion("SUMMARY like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotLike(String value) {
            addCriterion("SUMMARY not like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryIn(List<String> values) {
            addCriterion("SUMMARY in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotIn(List<String> values) {
            addCriterion("SUMMARY not in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryBetween(String value1, String value2) {
            addCriterion("SUMMARY between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotBetween(String value1, String value2) {
            addCriterion("SUMMARY not between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andPathIsNull() {
            addCriterion("PATH is null");
            return (Criteria) this;
        }

        public Criteria andPathIsNotNull() {
            addCriterion("PATH is not null");
            return (Criteria) this;
        }

        public Criteria andPathEqualTo(String value) {
            addCriterion("PATH =", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotEqualTo(String value) {
            addCriterion("PATH <>", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThan(String value) {
            addCriterion("PATH >", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThanOrEqualTo(String value) {
            addCriterion("PATH >=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThan(String value) {
            addCriterion("PATH <", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThanOrEqualTo(String value) {
            addCriterion("PATH <=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLike(String value) {
            addCriterion("PATH like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotLike(String value) {
            addCriterion("PATH not like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathIn(List<String> values) {
            addCriterion("PATH in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotIn(List<String> values) {
            addCriterion("PATH not in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathBetween(String value1, String value2) {
            addCriterion("PATH between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotBetween(String value1, String value2) {
            addCriterion("PATH not between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andKeywordsIsNull() {
            addCriterion("KEYWORDS is null");
            return (Criteria) this;
        }

        public Criteria andKeywordsIsNotNull() {
            addCriterion("KEYWORDS is not null");
            return (Criteria) this;
        }

        public Criteria andKeywordsEqualTo(String value) {
            addCriterion("KEYWORDS =", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotEqualTo(String value) {
            addCriterion("KEYWORDS <>", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsGreaterThan(String value) {
            addCriterion("KEYWORDS >", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsGreaterThanOrEqualTo(String value) {
            addCriterion("KEYWORDS >=", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLessThan(String value) {
            addCriterion("KEYWORDS <", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLessThanOrEqualTo(String value) {
            addCriterion("KEYWORDS <=", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLike(String value) {
            addCriterion("KEYWORDS like", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotLike(String value) {
            addCriterion("KEYWORDS not like", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsIn(List<String> values) {
            addCriterion("KEYWORDS in", values, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotIn(List<String> values) {
            addCriterion("KEYWORDS not in", values, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsBetween(String value1, String value2) {
            addCriterion("KEYWORDS between", value1, value2, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotBetween(String value1, String value2) {
            addCriterion("KEYWORDS not between", value1, value2, "keywords");
            return (Criteria) this;
        }

        public Criteria andInitContentIsNull() {
            addCriterion("INIT_CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andInitContentIsNotNull() {
            addCriterion("INIT_CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andInitContentEqualTo(Boolean value) {
            addCriterion("INIT_CONTENT =", value, "initContent");
            return (Criteria) this;
        }

        public Criteria andInitContentNotEqualTo(Boolean value) {
            addCriterion("INIT_CONTENT <>", value, "initContent");
            return (Criteria) this;
        }

        public Criteria andInitContentGreaterThan(Boolean value) {
            addCriterion("INIT_CONTENT >", value, "initContent");
            return (Criteria) this;
        }

        public Criteria andInitContentGreaterThanOrEqualTo(Boolean value) {
            addCriterion("INIT_CONTENT >=", value, "initContent");
            return (Criteria) this;
        }

        public Criteria andInitContentLessThan(Boolean value) {
            addCriterion("INIT_CONTENT <", value, "initContent");
            return (Criteria) this;
        }

        public Criteria andInitContentLessThanOrEqualTo(Boolean value) {
            addCriterion("INIT_CONTENT <=", value, "initContent");
            return (Criteria) this;
        }

        public Criteria andInitContentIn(List<Boolean> values) {
            addCriterion("INIT_CONTENT in", values, "initContent");
            return (Criteria) this;
        }

        public Criteria andInitContentNotIn(List<Boolean> values) {
            addCriterion("INIT_CONTENT not in", values, "initContent");
            return (Criteria) this;
        }

        public Criteria andInitContentBetween(Boolean value1, Boolean value2) {
            addCriterion("INIT_CONTENT between", value1, value2, "initContent");
            return (Criteria) this;
        }

        public Criteria andInitContentNotBetween(Boolean value1, Boolean value2) {
            addCriterion("INIT_CONTENT not between", value1, value2, "initContent");
            return (Criteria) this;
        }

        public Criteria andStartPageNoIsNull() {
            addCriterion("START_PAGE_NO is null");
            return (Criteria) this;
        }

        public Criteria andStartPageNoIsNotNull() {
            addCriterion("START_PAGE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andStartPageNoEqualTo(Integer value) {
            addCriterion("START_PAGE_NO =", value, "startPageNo");
            return (Criteria) this;
        }

        public Criteria andStartPageNoNotEqualTo(Integer value) {
            addCriterion("START_PAGE_NO <>", value, "startPageNo");
            return (Criteria) this;
        }

        public Criteria andStartPageNoGreaterThan(Integer value) {
            addCriterion("START_PAGE_NO >", value, "startPageNo");
            return (Criteria) this;
        }

        public Criteria andStartPageNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("START_PAGE_NO >=", value, "startPageNo");
            return (Criteria) this;
        }

        public Criteria andStartPageNoLessThan(Integer value) {
            addCriterion("START_PAGE_NO <", value, "startPageNo");
            return (Criteria) this;
        }

        public Criteria andStartPageNoLessThanOrEqualTo(Integer value) {
            addCriterion("START_PAGE_NO <=", value, "startPageNo");
            return (Criteria) this;
        }

        public Criteria andStartPageNoIn(List<Integer> values) {
            addCriterion("START_PAGE_NO in", values, "startPageNo");
            return (Criteria) this;
        }

        public Criteria andStartPageNoNotIn(List<Integer> values) {
            addCriterion("START_PAGE_NO not in", values, "startPageNo");
            return (Criteria) this;
        }

        public Criteria andStartPageNoBetween(Integer value1, Integer value2) {
            addCriterion("START_PAGE_NO between", value1, value2, "startPageNo");
            return (Criteria) this;
        }

        public Criteria andStartPageNoNotBetween(Integer value1, Integer value2) {
            addCriterion("START_PAGE_NO not between", value1, value2, "startPageNo");
            return (Criteria) this;
        }

        public Criteria andPageCountIsNull() {
            addCriterion("PAGE_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andPageCountIsNotNull() {
            addCriterion("PAGE_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andPageCountEqualTo(Integer value) {
            addCriterion("PAGE_COUNT =", value, "pageCount");
            return (Criteria) this;
        }

        public Criteria andPageCountNotEqualTo(Integer value) {
            addCriterion("PAGE_COUNT <>", value, "pageCount");
            return (Criteria) this;
        }

        public Criteria andPageCountGreaterThan(Integer value) {
            addCriterion("PAGE_COUNT >", value, "pageCount");
            return (Criteria) this;
        }

        public Criteria andPageCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("PAGE_COUNT >=", value, "pageCount");
            return (Criteria) this;
        }

        public Criteria andPageCountLessThan(Integer value) {
            addCriterion("PAGE_COUNT <", value, "pageCount");
            return (Criteria) this;
        }

        public Criteria andPageCountLessThanOrEqualTo(Integer value) {
            addCriterion("PAGE_COUNT <=", value, "pageCount");
            return (Criteria) this;
        }

        public Criteria andPageCountIn(List<Integer> values) {
            addCriterion("PAGE_COUNT in", values, "pageCount");
            return (Criteria) this;
        }

        public Criteria andPageCountNotIn(List<Integer> values) {
            addCriterion("PAGE_COUNT not in", values, "pageCount");
            return (Criteria) this;
        }

        public Criteria andPageCountBetween(Integer value1, Integer value2) {
            addCriterion("PAGE_COUNT between", value1, value2, "pageCount");
            return (Criteria) this;
        }

        public Criteria andPageCountNotBetween(Integer value1, Integer value2) {
            addCriterion("PAGE_COUNT not between", value1, value2, "pageCount");
            return (Criteria) this;
        }

        public Criteria andInsertDateIsNull() {
            addCriterion("INSERT_DATE is null");
            return (Criteria) this;
        }

        public Criteria andInsertDateIsNotNull() {
            addCriterion("INSERT_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andInsertDateEqualTo(Date value) {
            addCriterion("INSERT_DATE =", value, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateNotEqualTo(Date value) {
            addCriterion("INSERT_DATE <>", value, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateGreaterThan(Date value) {
            addCriterion("INSERT_DATE >", value, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateGreaterThanOrEqualTo(Date value) {
            addCriterion("INSERT_DATE >=", value, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateLessThan(Date value) {
            addCriterion("INSERT_DATE <", value, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateLessThanOrEqualTo(Date value) {
            addCriterion("INSERT_DATE <=", value, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateIn(List<Date> values) {
            addCriterion("INSERT_DATE in", values, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateNotIn(List<Date> values) {
            addCriterion("INSERT_DATE not in", values, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateBetween(Date value1, Date value2) {
            addCriterion("INSERT_DATE between", value1, value2, "insertDate");
            return (Criteria) this;
        }

        public Criteria andInsertDateNotBetween(Date value1, Date value2) {
            addCriterion("INSERT_DATE not between", value1, value2, "insertDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("UPDATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("UPDATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("UPDATE_DATE =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("UPDATE_DATE <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("UPDATE_DATE >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_DATE >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("UPDATE_DATE <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_DATE <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("UPDATE_DATE in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("UPDATE_DATE not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("UPDATE_DATE between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_DATE not between", value1, value2, "updateDate");
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