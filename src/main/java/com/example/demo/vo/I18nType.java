package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum I18nType {
    label("label");
    private String name;
}
