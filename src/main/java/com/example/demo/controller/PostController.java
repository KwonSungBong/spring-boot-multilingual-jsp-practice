package com.example.demo.controller;

import com.example.demo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/post")
public class PostController {

    @Autowired
    private MenuService menuService;

    @RequestMapping
    public ModelAndView post() {
        ModelAndView modelAndView = new ModelAndView("post");
        modelAndView.addObject("menuRoot", menuService.getMenuRoot());
        return modelAndView;
    }

}
