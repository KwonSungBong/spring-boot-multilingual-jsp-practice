package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MenuType {
    root("root"), menu("menu"), category("category");
    private String name;
}
