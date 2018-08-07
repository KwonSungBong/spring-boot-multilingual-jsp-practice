package com.example.demo.controller.rest;

import com.example.demo.service.RoleMenuService;
import com.example.demo.vo.RoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/roleMenu")
public class RoleMenuRestController {

    @Autowired
    private RoleMenuService roleMenuService;

    @RequestMapping("/findAll")
    public List<RoleMenu> findAll() {
        return roleMenuService.findAll();
    }

    @RequestMapping("/insert")
    public int insert() {
        RoleMenu roleMenu = new RoleMenu();
        return roleMenuService.insert(roleMenu);
    }
}
