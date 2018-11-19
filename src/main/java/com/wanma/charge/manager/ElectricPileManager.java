package com.wanma.charge.manager;

import com.wanma.charge.domain.ElectricPile;
import com.wanma.charge.manager.common.DomainManager;

/**
 * @author zangyy
 */
public interface ElectricPileManager extends DomainManager<Long, ElectricPile> {

    ElectricPile getElectricPileByCode(String code);

}
