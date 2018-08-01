package com.example.demo.repository;

import com.example.demo.vo.RoleMenu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoleMenuRepository {
    List<RoleMenu> findAll();
    RoleMenu findOne(int id);
    int insert(RoleMenu roleMenu);
    int update(RoleMenu roleMenu);
    int delete(int id);
}
