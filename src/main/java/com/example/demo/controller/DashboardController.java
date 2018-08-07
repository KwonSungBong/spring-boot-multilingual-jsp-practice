package com.example.demo.controller;

import com.example.demo.service.MenuService;
import com.example.demo.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private MenuService menuService;

    @RequestMapping
    public ModelAndView dashboard() {
        ModelAndView modelAndView = new ModelAndView("dashboard");
        modelAndView.addObject("users", getUsers());
        modelAndView.addObject("menuRoot", menuService.getMenuRoot());
        return modelAndView;
    }

    private List getUsers() {
        User user = new User();
        user.setUsername("johndoe123@gmail.com");
        user.setName("John Doe");
        user.setPassword("Bangalore, Karnataka");
        User user1 = new User();
        user1.setUsername("amitsingh@yahoo.com");
        user1.setName("Amit Singh");
        user1.setPassword("Chennai, Tamilnadu");
        User user2 = new User();
        user2.setUsername("bipulkumar@gmail.com");
        user2.setName("Bipul Kumar");
        user2.setPassword("Bangalore, Karnataka");
        User user3 = new User();
        user3.setUsername("prakashranjan@gmail.com");
        user3.setName("Prakash Ranjan");
        user3.setPassword("Chennai, Tamilnadu");
        return Arrays.asList(user, user1, user2, user3);
    }

}
