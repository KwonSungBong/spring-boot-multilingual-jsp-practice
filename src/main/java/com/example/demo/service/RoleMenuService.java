package com.example.demo.service;

import com.example.demo.repository.RoleMenuRepository;
import com.example.demo.vo.RoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleMenuService {

    @Autowired
    private RoleMenuRepository roleMenuRepository;

    public List<RoleMenu> findAll() {
        return roleMenuRepository.findAll();
    }

    public RoleMenu findOne(int id) {
        return roleMenuRepository.findOne(id);
    }

    public int insert(RoleMenu roleMenu) {
        return roleMenuRepository.insert(roleMenu);
    }

    public int update(RoleMenu roleMenu) {
        return roleMenuRepository.update(roleMenu);
    }

    public int delete(int id) {
        return roleMenuRepository.delete(id);
    }

}
