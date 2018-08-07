package com.example.demo.controller.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/test")
public class TestRestController {

    @RequestMapping
    public String test() {
        return "test";
    }

}
