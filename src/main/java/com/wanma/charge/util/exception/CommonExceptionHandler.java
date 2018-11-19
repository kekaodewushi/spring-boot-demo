package com.wanma.charge.util.exception;

import com.wanma.charge.util.NetUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zangyaoyi on 2018/11/19.
 */
@ControllerAdvice
public class CommonExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommonExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String, Object> exceptionHandler(Exception e) {
        Map<String, Object> result = new HashMap<>();
        LOGGER.warn(NetUtils.getHostIp() + e.getMessage() + ";", e);
        result.put("Msg", "系统异常，请核实参数后再次请求");
        result.put("Ret", "500");
        //正常开发中，可创建一个统一响应实体，如CommonResp
        return result;
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public Map<String, Object> exceptionHandler(BusinessException e) {
        LOGGER.warn("Encountered business error|" + e.getErrorCode() + "|" + e.getErrorMessage());
        Map<String, Object> models = new HashMap<>();
        models.put("msg", e.getErrorMessage());
        models.put("status", e.getErrorCode());
        return models;
    }

    @ExceptionHandler(CECBusinessException.class)
    @ResponseBody
    public Map<String, Object> exceptionHandler(CECBusinessException bex) {
        LOGGER.warn("Encountered cecBusiness error|" + bex.getCode() + "|" + bex.getMessage());
        Map<String, Object> models = new HashMap<>();
        models.put("Msg", bex.getMessage());
        models.put("Ret", bex.getCode());
        return models;
    }

}
