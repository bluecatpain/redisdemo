package com.bjsxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转controller
 *
 */
@Controller
public class pageController {

    @RequestMapping("/{page}")
    public  String showPage(@PathVariable String page){
        return page;
    }
}
