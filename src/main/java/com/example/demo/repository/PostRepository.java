package com.example.demo.repository;

import com.example.demo.vo.Post;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PostRepository {
    List<Post> findAll();
    Post findOne(int id);
    int insert(Post post);
    int update(Post post);
    int delete(int id);
}
