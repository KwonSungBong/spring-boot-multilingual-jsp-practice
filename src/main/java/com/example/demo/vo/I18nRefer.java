package com.example.demo.vo;

import lombok.Data;

@Data
public class I18nRefer {
    private long id;
    private String locale;
    private String table;
    private String column;
    private String text;
}
