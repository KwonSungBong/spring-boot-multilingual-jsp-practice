package com.example.demo.service;

import com.example.demo.repository.MenuRepository;
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

    public Menu getMenuRoot() {
        List<Menu> menuList = menuRepository.findByDepth();

        Menu root = menuList.get(0);
        Map<Long, Menu> menuMap = new HashMap<>();
        for(Menu menu : menuList) {
            menuMap.put(menu.getId(), menu);
            if(!menu.isRoot() && menuMap.containsKey(menu.getParent())) {
                menuMap.get(menu.getParent()).getChildren().add(menu);
            }
        }

        return root;
    }

    public List<Menu> getMenuList() {
        Menu root = getMenuRoot();
        return getMenuList(root);
    }

    private List<Menu> getMenuList(Menu menu) {
        List<Menu> list = new ArrayList<>();
        list.add(menu);
        if(!ObjectUtils.isEmpty(menu.getChildren())) {
            for(Menu child : menu.getChildren()) {
                list.addAll(getMenuList(child));
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
