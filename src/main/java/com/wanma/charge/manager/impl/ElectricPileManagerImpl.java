package com.wanma.charge.manager.impl;

import com.wanma.charge.dao.ElectricPileMapper;
import com.wanma.charge.dao.common.BasicMapper;
import com.wanma.charge.domain.ElectricPile;
import com.wanma.charge.manager.ElectricPileManager;
import com.wanma.charge.manager.common.AbstractManager;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author zangyy
 */
@Component
public class ElectricPileManagerImpl extends AbstractManager<ElectricPile> implements ElectricPileManager {

    @Resource
    private ElectricPileMapper mapper;

    @Override
    protected BasicMapper<Long, ElectricPile> getMapper() {
        return mapper;
    }

    @Override
    public ElectricPile getElectricPileByCode(String code) {
        return mapper.selectSimpleByCode(code);
    }
}
