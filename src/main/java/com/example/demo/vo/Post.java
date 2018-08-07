package com.example.demo.vo;

import lombok.Data;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Data
public class Post {
    private long id;
    private List<I18nRefer> title;
    private List<I18nRefer> content;
    private String useYn;

    public long getTitleId() {
        if(ObjectUtils.isEmpty(title)) return 0;
        return title.get(0).getId();
    }
    public long getContentId() {
        if(ObjectUtils.isEmpty(content)) return 0;
        return content.get(0).getId();
    }
}
