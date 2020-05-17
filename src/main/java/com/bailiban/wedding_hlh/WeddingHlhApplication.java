package com.bailiban.wedding_hlh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 * 启动项目，对项目中所有的包进行扫描
 * 配置当前应用程序是SpringBoot项目
 * 该类必须放在项目包在根目录
 */
@SpringBootApplication
@MapperScan("com.bailiban.wedding_hlh.dao")
public class WeddingHlhApplication {

    public static void main(String[] args) {
        //启动项目
        SpringApplication.run(WeddingHlhApplication.class, args);
    }

}
