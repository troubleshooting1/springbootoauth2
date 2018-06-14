package com.anji.springbootoauth2demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * author: chenqiang
 * date: 2018/6/14 14:15
 */
@RestController
@RequestMapping
public class HelloWorldController {
    @RequestMapping("/hello")
    public String sayHello(){
        return "Hello World!";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
