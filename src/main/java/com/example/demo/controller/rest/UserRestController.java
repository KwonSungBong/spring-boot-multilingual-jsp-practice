package com.example.demo.controller.rest;

import com.example.demo.service.UserService;
import com.example.demo.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRestController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public List<User> findAll() {
        return userService.findAll();
    }

    @RequestMapping("/insert")
    public int insert() {
        User user = new User();
        user.setName("test");
        user.setPassword("password");
        user.setUsername("test");
        return userService.insert(user);
    }

}
