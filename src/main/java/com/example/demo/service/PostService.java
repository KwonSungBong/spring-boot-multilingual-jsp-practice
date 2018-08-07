package com.example.demo.service;

import com.example.demo.repository.PostRepository;
import com.example.demo.vo.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findOne(int id) {
        return postRepository.findOne(id);
    }

    public int insert(Post post) {
        postRepository.insertPostTitle(post.getTitle());
        postRepository.insertPostContent(post.getContent());
        return postRepository.insert(post);
    }

    public int update(Post post) {
        postRepository.updatePostTitle(post.getTitle());
        postRepository.updatePostContent(post.getContent());
        return postRepository.update(post);
    }

    public int delete(int id) {
        return postRepository.delete(id);
    }

}
