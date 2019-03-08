package com.tianyaleixiaolin.uplusserver.global.specify;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

/**
 * 要筛选的列，或者表达式（平均数、sum等）
 *
 * @author Mr.li wrote on 2018/12/28.
 */
public interface MySelector {
    enum Operator {
        COUNT, COUNT_DISTINCT, SUM, AVG, MAX, MIN
    }

    Selection getSelection(Root<?> root, CriteriaBuilder builder);
}