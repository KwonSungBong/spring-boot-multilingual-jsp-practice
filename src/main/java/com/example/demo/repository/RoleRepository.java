package com.example.demo.repository;

import com.example.demo.vo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoleRepository {
    List<Role> findAll();
    Role findOne(int id);
    int insert(Role role);
    int update(Role role);
    int delete(int id);
}
