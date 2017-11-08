package com.hlq.mallbase.deploy.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 
 * @时间:2017年10月23日
 * @作者: hukc
 * @Mail:hu1932@163.com
 * @说明:配置加载工具类
 */
public class ConfigLoader {
    private final static Logger logger = LoggerFactory.getLogger(ConfigLoader.class);
    private final static ConcurrentHashMap<String, String> configMap = new ConcurrentHashMap<String, String>();
    public static void init(String[] configLocations) throws IOException{
    	if(logger.isInfoEnabled()){
    		logger.info("MessageResourceFactory init ...");
    	}
        Properties properties = new Properties();
        for(String location:configLocations){
            InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(location);
            if(inputStream == null){
                inputStream = (ConfigLoader.class.getResourceAsStream(location));
                if(inputStream == null){
                    throw new NullPointerException("can't load file "+location);
                }
            }
            properties.load(inputStream);
        }
        for(Iterator<?> it = properties.keySet().iterator(); it.hasNext(); ){
            String key = (String)it.next();
            String value = (String) properties.get(key);
            configMap.put(key, value);
        }
    }
    public static String get(String key){
        return configMap.get(key);
    }
}
