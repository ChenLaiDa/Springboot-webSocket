package com.example.springbootwebsocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Author: chenchong
 * @Date: 2022/5/26 21:55
 */
@Controller
@RequestMapping("/web")
public class WebController {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
