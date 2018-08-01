package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value="/sample")
public class SampleController {

    @RequestMapping
    public ModelAndView sample(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("sample");
        return modelAndView;
    }

    @RequestMapping("/two")
    public ModelAndView sample2(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("sample_two");
        return modelAndView;
    }

    @RequestMapping("/three")
    public ModelAndView sample3(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("sample_three");
        return modelAndView;
    }
}
