package com.example.demo.repository;

import com.example.demo.vo.RoleMenu;
import com.example.demo.vo.RoleMenuSearch;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoleMenuRepository {
    List<RoleMenu> findAll(RoleMenuSearch search);
    int insert(RoleMenu roleMenu);
    int update(RoleMenu roleMenu);
    int delete(int id);
}
