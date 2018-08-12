package com.example.demo.controller.rest;

import com.example.demo.service.UserService;
import com.example.demo.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/user")
public class UserRestController {

    @Autowired
    private UserService userService;

    @RequestMapping()
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping
    public int insert(@RequestBody User user) {
//        return userService.insert(user);
        return 1;
    }

    @PutMapping
    public int update(@RequestBody User user) {
//        return userService.update(user);
        return 1;
    }

    @DeleteMapping
    public int delete() {
        return 1;
    }
}
