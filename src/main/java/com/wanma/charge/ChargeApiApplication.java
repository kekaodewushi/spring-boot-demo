package com.wanma.charge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author zangyy
 */
@SpringBootApplication
public class ChargeApiApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ChargeApiApplication.class, args);
    }
}
