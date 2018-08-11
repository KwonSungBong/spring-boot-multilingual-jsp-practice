package com.example.demo.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RoleMenu {
    private static int ROOT_DEPTH = 0;

    private long roleId;
    private long menuId;
    private String name;
    private String url;
    private int order;
    private int depth;
    private long parent;
    private MenuType menuType;
    private String useYn;
    private List<Menu> children = new ArrayList<>();

    public boolean isRoot() {
        return ROOT_DEPTH == depth;
    }
}
