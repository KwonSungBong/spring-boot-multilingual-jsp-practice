package com.example.demo.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class JsTreeNode {
    private long id;
    private String text;
    private List<JsTreeNode> children = new ArrayList<>();
    private int order;
    private int depth;
    private char useYn;

    public State getState() {
        State state = new State();
        if(children.size() != 0) return state;
        if(useYn == 'y') {
            state.setSelected(true);
        } else {
            state.setSelected(false);
        }
        return state;
    }

    @Data
    private static class State {
        private boolean selected;
    }
}
