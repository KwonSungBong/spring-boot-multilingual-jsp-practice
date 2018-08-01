package com.example.demo.service;

import com.example.demo.repository.RoleRepository;
import com.example.demo.vo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Role findOne(int id) {
        return roleRepository.findOne(id);
    }

    public int insert(Role role) {
        return roleRepository.insert(role);
    }

    public int update(Role role) {
        return roleRepository.update(role);
    }

    public int delete(int id) {
        return roleRepository.delete(id);
    }

}
