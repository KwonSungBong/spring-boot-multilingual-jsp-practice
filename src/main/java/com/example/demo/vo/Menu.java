package com.example.demo.vo;

import lombok.Data;

@Data
public class Menu {
    private long id;
    private String name;
    private String url;
    private int order;
    private int depth;
    private long parent;
    private MenuType menuType;
    private char useYn;
}
