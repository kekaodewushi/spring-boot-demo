package com.wanma.charge.dao.common;

import com.wanma.charge.domain.common.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zangyy
 * 分页mapper
 */
public interface PagedMapper<K, T> extends BasicMapper<K, T> {

    List<T> selectWithPage(@Param("condition") T condition, @Param("page") Page page);
}
