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

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hlq.mallbase.management.facade.intf.UserInfoFacade;

/**
 * @author hukc
 * @version
 * @since JDK 1.7
 * @see
 */
@Controller
@RequestMapping("")
public class IndexController {
	@Resource
	private UserInfoFacade userInfoFacade;

	@RequestMapping("/")
	public String index(Model model) {
		int res = userInfoFacade.doLogin("123", "123");
		System.out.println(res);
		model.addAttribute("name", "dfsdfsf");
		return "index";
	}
}
