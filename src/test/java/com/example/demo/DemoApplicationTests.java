package com.example.demo;

import com.example.demo.cache.LocaleService;
import com.example.demo.repository.I18NRepository;
import com.example.demo.service.PostService;
import com.example.demo.vo.I18n;
import com.example.demo.vo.I18nRefer;
import com.example.demo.vo.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

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
        I18nRefer titleKo = new I18nRefer();
        titleKo.setLocale(Locale.KOREA.toString());
        titleKo.setTable("POST");
        titleKo.setColumn("title");
        titleKo.setText("제목");

        I18nRefer titleEn = new I18nRefer();
        titleEn.setLocale(Locale.US.toString());
        titleEn.setTable("POST");
        titleEn.setColumn("title");
        titleEn.setText("title");

        I18nRefer contentKo = new I18nRefer();
        contentKo.setLocale(Locale.KOREA.toString());
        contentKo.setTable("POST");
        contentKo.setColumn("content");
        contentKo.setText("내용");

        I18nRefer contentEn = new I18nRefer();
        contentEn.setLocale(Locale.US.toString());
        contentEn.setTable("POST");
        contentEn.setColumn("content");
        contentEn.setText("content");

        Post post = new Post();
        post.setTitle(Arrays.asList(titleKo, titleEn));
        post.setContent(Arrays.asList(contentKo, contentEn));

        postService.insert(post);
        System.out.println();
    }

    @Test
    public void TEST3() {
        List<Post> postList = postService.findAll();
        System.out.println(postList);
    }

    @Test
    public void TEST4() {
        I18nRefer titleKo = new I18nRefer();
        titleKo.setId(1);
        titleKo.setLocale(Locale.KOREA.toString());
        titleKo.setText("제목");

        I18nRefer titleEn = new I18nRefer();
        titleEn.setId(1);
        titleEn.setLocale(Locale.US.toString());
        titleEn.setText("title");

        I18nRefer contentKo = new I18nRefer();
        contentKo.setId(1);
        contentKo.setLocale(Locale.KOREA.toString());
        contentKo.setText("내용");

        I18nRefer contentEn = new I18nRefer();
        contentEn.setId(1);
        contentEn.setLocale(Locale.US.toString());
        contentEn.setText("content");

        Post post = new Post();
        post.setId(1);
        post.setTitle(Arrays.asList(titleKo, titleEn));
        post.setContent(Arrays.asList(contentKo, contentEn));
        post.setUseYn("Y");

        postService.update(post);
        System.out.println();
    }

    @Test
    public void TEST5() {
        postService.delete(1);
        System.out.println();
    }

    @Autowired
    private I18NRepository i18NRepository;

    @Test
    public void TEST6() {
        Map<String, Map<String, I18n>> test = i18NRepository.findAll().stream()
                .collect(groupingBy(I18n::getLocale, Collectors.toMap(I18n::getCode, Function.identity())));
        System.out.println();
    }

    @Autowired
    private LocaleService localeService;

    @Test
    public void TEST7() {
        String text = localeService.i18nText("ko_KR", "I18N.TITLE");
        System.out.println();
    }

}
