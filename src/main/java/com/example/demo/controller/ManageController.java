package com.example.demo.controller;

import com.example.demo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/manage")
public class ManageController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/manager")
    public ModelAndView manager() {
        ModelAndView modelAndView = new ModelAndView("manage/manager");
        modelAndView.addObject("menuRoot", menuService.getMenuRoot());
        return modelAndView;
    }

    @RequestMapping("/menu")
    public ModelAndView menu() {
        ModelAndView modelAndView = new ModelAndView("manage/menu");
        modelAndView.addObject("menuRoot", menuService.getMenuRoot());
        return modelAndView;
    }

    @RequestMapping("/role")
    public ModelAndView role() {
        ModelAndView modelAndView = new ModelAndView("manage/role");
        modelAndView.addObject("menuRoot", menuService.getMenuRoot());
        return modelAndView;
    }

}
