package com.example.demo.vo;

import lombok.Data;

import java.util.Map;

@Data
public class Post {
    private long id;
    private Map<String, I18nRefer> title;
    private Map<String, I18nRefer> content;
}
