package com.example.demo.vo;

import lombok.Data;

@Data
public class I18n {
    private String code;
    private String local;
    private I18nType type;
    private String text;
}
