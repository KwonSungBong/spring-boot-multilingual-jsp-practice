package com.example.demo.repository;

import com.example.demo.vo.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MenuRepository {
    List<Menu> findAll();
    List<Menu> findByDepth();
    List<Menu> hierarchicalQuery();
    Menu findOne(int id);
    int insert(Menu menu);
    int update(Menu menu);
    int delete(int id);
}
