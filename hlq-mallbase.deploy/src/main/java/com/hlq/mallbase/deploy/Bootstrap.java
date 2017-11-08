package com.hlq.mallbase.deploy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;


/**
 * 
 * @时间:2017年10月31日
 * @作者: hukc
 * @Mail:hu1932@163.com
 * @说明:启动类
 */

@SpringBootApplication
@ComponentScan
@ImportResource({"classpath:config/applicationContext.xml"})
public class Bootstrap {
    public static void main(String[] args) {
        //启动springboot
        SpringApplication.run(Bootstrap.class, args);

    }
}
