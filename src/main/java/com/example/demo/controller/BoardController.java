package com.example.demo.controller;

import com.example.demo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/board")
public class BoardController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/{category}")
    public ModelAndView board(@PathVariable String category) {
        ModelAndView modelAndView = new ModelAndView("board");
        modelAndView.addObject("category", category);
        modelAndView.addObject("menuRoot", menuService.getMenuRoot());
        return modelAndView;
    }

}
