package com.wanma.charge.manager.common;

import com.google.common.base.Preconditions;

import com.wanma.charge.dao.common.BasicMapper;
import com.wanma.charge.dao.common.PagedMapper;
import com.wanma.charge.domain.common.CommonDomain;
import com.wanma.charge.domain.common.OrderCondition;
import com.wanma.charge.domain.common.Page;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zangyy
 * @date 2015/7/24
 * 抽象manager层
 */
public abstract class AbstractManager<T extends CommonDomain> implements DomainManager<Long, T> {

    protected abstract BasicMapper<Long, T> getMapper();

    @Override
    public int save(T obj) {
        Date now = new Date();
        obj.setIsDel(0);
        obj.setModifyTime(now);
        obj.setCreateTime(now);
        return getMapper().insert(obj);
    }

    @Override
    public int update(T obj) {
        Preconditions.checkArgument(obj != null && obj.getId() != null);
        Date now = new Date();
        obj.setModifyTime(now);
        return getMapper().updateByPrimaryKey(obj);
    }

    @Override
    public int saveOrUpdate(T obj) {
        if (obj.getId() == null || getById(obj.getId()) == null) {
            return save(obj);
        } else {
            return update(obj);
        }
    }

    @Override
    public T getById(Long key) {
        Preconditions.checkNotNull(key);

        return getMapper().selectByPrimaryKey(key);
    }

    @Override
    public T getByCondition(T condition) {
        return getMapper().selectOne(condition);
    }

    @Override
    public List<T> listByCondition(T condition, List<OrderCondition> orderConditions) {
        List<T> res = getMapper().selectByCondition(condition, orderConditions);
        return res == null ? new ArrayList<>() : res;
    }

    @Override
    public long count(T obj) {
        return getMapper().selectCount(obj);
    }

    @Override
    public int deleteById(Long key) {
        Preconditions.checkNotNull(key);

        return getMapper().deleteByPrimaryKey(key);
    }

    @Override
    public int deleteByCondition(T condition) {
        return getMapper().deleteByCondition(condition);
    }

    @Override
    public List<T> listWithPage(T condition, Page page) {
        BasicMapper<Long, T> mapper = getMapper();
        if (getMapper() instanceof PagedMapper) {
            List<T> res = ((PagedMapper<Long, T>) mapper).selectWithPage(condition, page);
            return res == null ? new ArrayList<>() : res;
        } else {
            throw new UnsupportedOperationException(getMapper().getClass() + " is not PagedMapper class");
        }
    }

    protected List<T> nonEmptyList(List<T> list) {
        return list == null ? new ArrayList<>() : list;
    }
}
