package com.wanma.charge.dao.common;

import com.wanma.charge.domain.common.OrderCondition;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zangyy
 * 基础mapper
 */
public interface BasicMapper<K, T> {
    List<T> selectByCondition(@Param("condition") T condition, @Param("orderConditions") List<OrderCondition> orderConditions);

    T selectByPrimaryKey(K key);

    T selectOne(@Param("condition") T condition);

    long selectCount(@Param("condition") T condition);

    int insert(T record);

    int updateByPrimaryKey(T record);

    int deleteByPrimaryKey(K key);

    int deleteByCondition(@Param("condition") T condition);

}
