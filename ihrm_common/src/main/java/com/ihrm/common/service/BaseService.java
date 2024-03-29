package com.ihrm.common.service;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class BaseService<T> {

    protected Specification<T> getSpec(String companyId){
        Specification<T> spect = new Specification() {
            /**
             * 用于构造条件
             *     root             : 包含了所有的对象数据
             *     criteriaQuery    : 一般不用
             *     criteriaBuilder  : 构造查询条件
             *           companyId = "1"
             */
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("companyId").as(String.class), companyId);
            }
        };
        return spect;
    }

}
