
 /**
 * Project Name:hlq-mallbase.access
 * File Name:IndexController.java
 * Package Name:com.hlq.mallbase.access.controller
 * Date:2017年11月6日下午3:12:02
 * Copyright (c) 2017, .
 *
*/

package com.hlq.mallbase.access.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hlq.mallbase.management.facade.dto.OrderDto;
import com.hlq.mallbase.management.facade.intf.DemoFacade;

/**
 * @author   hukc
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@RestController
@RequestMapping("")
public class IndexController {
	@Resource
	private DemoFacade demoFacade;
	
	@ResponseBody
	@RequestMapping(value = "/queryDemo", method = RequestMethod.GET)
	public String queryDemo(String userName) throws Exception{
		OrderDto orderDto=new OrderDto();
		orderDto.setOrderId("sdfasf");
		orderDto.setChannelId("sdfsdf");
		demoFacade.insertOrder(orderDto);
		return "success";
	} 
}

