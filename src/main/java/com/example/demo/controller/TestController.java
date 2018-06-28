package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;

@Controller
public class TestController {

    @Autowired
    private MessageSource messageSource;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/test")
    public ModelAndView test() {
        ModelAndView modelAndView = new ModelAndView("test");
        modelAndView.addObject("hello", messageSource.getMessage("hello", null, Locale.KOREA));
        return modelAndView;
    }

    @RequestMapping("/session")
    public ModelAndView session(Locale locale) {
        ModelAndView modelAndView = new ModelAndView("session");
        modelAndView.addObject("hello", messageSource.getMessage("hello", null, LocaleContextHolder.getLocale()));
        return modelAndView;
    }

}
