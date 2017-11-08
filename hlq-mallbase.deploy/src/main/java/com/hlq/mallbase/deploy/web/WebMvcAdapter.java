package com.hlq.mallbase.deploy.web;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.hlq.mallbase.deploy.config.ConfigLoader;
/**
 * @时间:2017年10月23日
 * @作者: hukc
 * @Mail:hu1932@163.com
 * @说明:Mvc适配设置
 */
@Configuration
public class WebMvcAdapter extends WebMvcConfigurerAdapter {
	private static Logger logger = Logger.getLogger(WebMvcAdapter.class);

	/**
	 * 初始化加载配置文件
	 */
	final static String[] INIT_PATH = {"config/settings.properties"};
	    static{
	    	try {
	    		ConfigLoader.init(INIT_PATH);
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
				throw new RuntimeException(e.getMessage(), e);
			}
	    }
	   
	    
	    @Bean
	    public FilterRegistrationBean AccessExceptionFilterRegister(){
	    	FilterRegistrationBean registration = new FilterRegistrationBean();
	    	registration.setFilter(new GlobalExceptionFilter());
	    	registration.addUrlPatterns("/*");
	    	return registration;
	    }
	    
	


	
}
