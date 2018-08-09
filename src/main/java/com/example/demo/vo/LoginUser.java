package com.example.demo.vo;

import lombok.Data;

import javax.servlet.http.HttpSession;

@Data
public class LoginUser {
    private User user;
    private HttpSession session;

    public String getUsername() {
        return user.getUsername();
    }
}
