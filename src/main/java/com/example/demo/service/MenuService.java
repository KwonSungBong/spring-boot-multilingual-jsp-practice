package com.example.demo.service;

import com.example.demo.repository.MenuRepository;
import com.example.demo.vo.JsTreeNode;
import com.example.demo.vo.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public List<Menu> findAll() {
        return menuRepository.findAll();
    }

    public List<JsTreeNode> getJsTreeNodeList() {
        List<Menu> menuList = menuRepository.findByDepth();

        Map<Long, JsTreeNode> jsTreeNodeMap = new HashMap<>();
        List<JsTreeNode> jsTreeNodeList = new ArrayList<>();
        for(Menu menu : menuList) {
            JsTreeNode jsTreeNode = new JsTreeNode();
            jsTreeNode.setId(menu.getId());
            jsTreeNode.setText(menu.getName());
            jsTreeNode.setOrder(menu.getOrder());
            jsTreeNode.setDepth(menu.getDepth());
            jsTreeNode.setUseYn(menu.getUseYn());
            jsTreeNodeMap.put(menu.getId(), jsTreeNode);
            if(menu.getDepth() == 1) {
                jsTreeNodeList.add(jsTreeNode);
            } else {
                jsTreeNodeMap.get(menu.getParent()).getChildren().add(jsTreeNode);
            }
        }

        return jsTreeNodeList;
    }

    public List<JsTreeNode> selectAuthMenuTreeNodeList() {
        List<JsTreeNode> jsTreeNodeList = getJsTreeNodeList();

        List<JsTreeNode> allList = new ArrayList<>();
        for(JsTreeNode jsTreeNode : jsTreeNodeList) {
            allList.addAll(getTreeNodeList(jsTreeNode));
        }

        return allList;
    }

    private List<JsTreeNode> getTreeNodeList(JsTreeNode treeNode) {
        List<JsTreeNode> list = new ArrayList<>();
        list.add(treeNode);
        if(!ObjectUtils.isEmpty(treeNode.getChildren())) {
            for(JsTreeNode child : treeNode.getChildren()) {
                list.addAll(getTreeNodeList(child));
            }
        }
        return list;
    }

    public Menu findOne(int id) {
        return menuRepository.findOne(id);
    }

    public int insert(Menu menu) {
        return menuRepository.insert(menu);
    }

    public int update(Menu menu) {
        return menuRepository.update(menu);
    }

    public int delete(int id) {
        return menuRepository.delete(id);
    }

}
