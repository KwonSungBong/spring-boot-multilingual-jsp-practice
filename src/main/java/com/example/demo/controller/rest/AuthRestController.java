package com.example.demo.controller.rest;

import com.example.demo.service.UserService;
import com.example.demo.util.SessionUtil;
import com.example.demo.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/auth")
public class AuthRestController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
//        User user = userService.findByEmail(email);
        User user = new User();
        user.setId(1);
        user.setName("test name");
        user.setUsername("test username");
        if(user != null) {
            SessionUtil.setSession("loginUser", user);
            return "1";
        } else {
            return "0";
        }
    }

    @PostMapping("/logout")
    public String logout() {
        SessionUtil.invalidate();
        return "1";
    }

}
