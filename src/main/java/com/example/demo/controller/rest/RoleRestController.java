package com.example.demo.controller;

import com.example.demo.service.RoleService;
import com.example.demo.vo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleRestController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAll")
    public List<Role> findAll() {
        return roleService.findAll();
    }

    @RequestMapping("/insert")
    public int insert() {
        Role role = new Role();
        return roleService.insert(role);
    }

}
