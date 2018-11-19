package com.wanma.charge;

import java.math.BigDecimal;

/**
 * @author zangyy
 * @date 2018/10/16
 */
public class Test {

    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("0.5545");
        System.out.println(a.multiply(new BigDecimal("100")).setScale(0, BigDecimal.ROUND_HALF_UP).intValue());
    }

}
