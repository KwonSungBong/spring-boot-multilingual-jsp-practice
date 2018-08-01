package com.example.demo.repository;

import com.example.demo.vo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserRepository {
    List<User> findAll();
    User findOne(int id);
    int insert(User user);
    int update(User user);
    int delete(int id);
}
