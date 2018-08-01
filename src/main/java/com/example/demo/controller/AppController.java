package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/app")
public class AppController {

    @RequestMapping("/test")
    public String test(HttpServletRequest request) {
        String browserName = request.getHeader("User-Agent");
        return browserName;
    }

}
