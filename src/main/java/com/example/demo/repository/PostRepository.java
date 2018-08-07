package com.example.demo.repository;

import com.example.demo.vo.I18nRefer;
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
    int insertPostTitle(List<I18nRefer> title);
    int insertPostContent(List<I18nRefer> content);
    int updatePostTitle(List<I18nRefer> title);
    int updatePostContent(List<I18nRefer> content);
}
