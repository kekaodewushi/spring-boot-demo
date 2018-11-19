package com.wanma.charge.controller;

import com.wanma.charge.controller.contant.WebConstant;
import com.wanma.charge.domain.ElectricPile;
import com.wanma.charge.manager.ElectricPileManager;
import com.wanma.charge.util.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zangyy
 */
@RestController
@RequestMapping(value = WebConstant.REST_CHARGE_API + "/demo")
public class DemoController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoController.class);

    @Resource
    private ElectricPileManager electricPileManager;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ElectricPile test(String code) {
        ElectricPile electricPile = null;
        try {
            electricPile = electricPileManager.getElectricPileByCode(code);
        } catch (Exception e) {
            LOGGER.warn("test is error|code=:" + code + ";", e);
            throw new BusinessException();
        }
        return electricPile;
    }
}