package com.example.demo;

import com.example.demo.service.PostService;
import com.example.demo.vo.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void TEST1() {
        PathMatcher pathMatcher = new AntPathMatcher();

        String pattern = "/WEB-INF/jsp/view/*.jsp";
        String data = "/WEB-INF/jsp/view/login.jsp";
        boolean result = pathMatcher.match(pattern, data);
        System.out.println(result);
    }

    @Autowired
    private PostService postService;

    @Test
    public void TEST2() {
        Post post = new Post();
//        post.setTitleReferId(0);
//        post.setContentReferId(0);
//        postService.insert(post);
        System.out.println();
    }

    @Test
    public void TEST3() {
        List<Post> postList = postService.findAll();
        System.out.println(postList);
    }

}
