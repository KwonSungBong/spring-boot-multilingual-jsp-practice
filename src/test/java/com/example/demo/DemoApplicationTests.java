package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
        PathMatcher pathMatcher = new AntPathMatcher();

        String pattern = "/WEB-INF/jsp/view/*.jsp";
        String data = "/WEB-INF/jsp/view/login.jsp";
        boolean result = pathMatcher.match(pattern, data);
        System.out.println(result);
    }

}
