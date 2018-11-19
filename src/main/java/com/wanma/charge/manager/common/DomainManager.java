package com.wanma.charge.manager.common;


import com.wanma.charge.domain.common.CommonDomain;
import com.wanma.charge.domain.common.OrderCondition;
import com.wanma.charge.domain.common.Page;

import java.util.List;

/**
 * @author zangyy
 * @date 2015/7/24
 * manager基础
 */
public interface DomainManager<K, T extends CommonDomain> {
    int save(T obj);

    int update(T obj);

    int saveOrUpdate(T obj);

    T getById(K key);

    T getByCondition(T condition);

    List<T> listByCondition(T condition, List<OrderCondition> orderConditions);

    long count(T obj);

    int deleteById(K key);

    int deleteByCondition(T condition);

    List<T> listWithPage(T condition, Page page);
}
