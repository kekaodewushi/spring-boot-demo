package com.wanma.charge.dao;


import com.wanma.charge.dao.common.BasicMapper;
import com.wanma.charge.domain.ElectricPile;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zangyy
 */
@Mapper
public interface ElectricPileMapper extends BasicMapper {

    /**
     * 根据电桩编码获取简单的电桩
     */
    ElectricPile selectSimpleByCode(String epCode);
}