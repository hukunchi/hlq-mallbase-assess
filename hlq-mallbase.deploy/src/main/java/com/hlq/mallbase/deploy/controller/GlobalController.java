package com.hlq.mallbase.deploy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 
 * @时间:2017年10月31日
 * @作者: hukc
 * @Mail:hu1932@163.com
 * @说明:全局的控制器
 */
@Controller
@RequestMapping("/global")
public class GlobalController {

    /**
     * 跳转到404页面
     *
     * @author fengshuonan
     */
    @RequestMapping(path = "/error")
    public String errorPage() {
        return "/404.html";
    }

    /**
     * 跳转到session超时页面
     *
     * @author fengshuonan
     */
    @RequestMapping(path = "/sessionError")
    public String errorPageInfo(Model model) {
        model.addAttribute("tips", "session超时");
        return "/login.html";
    }
}
