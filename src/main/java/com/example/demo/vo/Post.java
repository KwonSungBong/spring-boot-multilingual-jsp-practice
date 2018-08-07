package com.example.demo.vo;

import lombok.Data;

import java.util.List;

@Data
public class Post {
    private long id;
//    private long titleReferId;
//    private long contentReferId;
    private List<I18nRefer> title;
    private List<I18nRefer> content;
}
