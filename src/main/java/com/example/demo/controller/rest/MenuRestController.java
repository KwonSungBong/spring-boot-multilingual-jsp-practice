package com.example.demo.controller.rest;

import com.example.demo.service.MenuService;
import com.example.demo.vo.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/menu")
public class MenuRestController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/root")
    public Menu getMenuRoot() {
        return menuService.getMenuRoot();
    }

    @PostMapping
    public int insert(@RequestBody Menu menu) {
        return 1;
    }

    @PutMapping
    public int update(@RequestBody Menu menu) {
        return 1;
    }

    @DeleteMapping
    public int delete() {
        return 1;
    }
}
