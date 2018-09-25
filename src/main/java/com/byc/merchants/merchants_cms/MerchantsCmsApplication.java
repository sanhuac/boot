package com.byc.merchants.merchants_cms;

import com.byc.merchants.merchants_cms.springboot.SpringContext;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

@SpringBootApplication
@MapperScan("com.byc.merchants.merchants_cms.dao")
public class MerchantsCmsApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(MerchantsCmsApplication.class);
        application.addListeners(new SpringContext());
        application.run(args);
    }
}
