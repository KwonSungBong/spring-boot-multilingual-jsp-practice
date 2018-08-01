package com.example.demo.controller;

import com.example.demo.service.MenuService;
import com.example.demo.vo.JsTreeNode;
import com.example.demo.vo.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuRestController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/jsTreeNode")
    public List<JsTreeNode> getJsTreeNodeList() {
        return menuService.getJsTreeNodeList();
    }

    @RequestMapping("/findAll")
    public List<Menu> findAll() {
        return menuService.findAll();
    }

    @RequestMapping("/insert")
    public int insert() {
        Menu menu = new Menu();
        return menuService.insert(menu);
    }

}
