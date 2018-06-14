package com.anji.springbootoauth2demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * author: chenqiang
 * date: 2018/6/14 14:17
 */
@RestController
@RequestMapping("/secure")
public class SecureController {
    @RequestMapping(method = RequestMethod.GET)
    public String sayHello(){
        return "Secure Hello!";
    }
}
