package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value="/")
public class IndexController {

    @RequestMapping
    public ModelAndView home(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

}
