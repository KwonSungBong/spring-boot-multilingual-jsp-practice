package com.example.demo.controller;

import com.example.demo.service.MenuService;
import com.example.demo.service.RoleMenuService;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;
import com.example.demo.vo.RoleMenuSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/manage")
public class ManageController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleMenuService roleMenuService;

    @RequestMapping("/manager")
    public ModelAndView manager() {
        ModelAndView modelAndView = new ModelAndView("manage/manager");
        modelAndView.addObject("menuRoot", menuService.getMenuRoot());
        modelAndView.addObject("userList", userService.findAll());
        return modelAndView;
    }

    @RequestMapping("/menu")
    public ModelAndView menu() {
        ModelAndView modelAndView = new ModelAndView("manage/menu");
        modelAndView.addObject("menuRoot", menuService.getMenuRoot());
        modelAndView.addObject("menuList", menuService.getMenuList());
        return modelAndView;
    }

    @RequestMapping("/role")
    public ModelAndView role() {
        RoleMenuSearch search = new RoleMenuSearch();
        search.setRoleId(1);

        ModelAndView modelAndView = new ModelAndView("manage/role");
        modelAndView.addObject("menuRoot", menuService.getMenuRoot());
        modelAndView.addObject("roleList", roleService.findAll());
        modelAndView.addObject("roleMenuList", roleMenuService.findAll(search));
        return modelAndView;
    }

}
