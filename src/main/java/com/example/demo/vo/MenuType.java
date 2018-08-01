package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MenuType {
    menu("menu"), category("category");
    private String name;
}
