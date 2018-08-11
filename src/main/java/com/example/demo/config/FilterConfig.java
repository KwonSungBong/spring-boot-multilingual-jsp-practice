package com.example.demo.config;

import com.example.demo.filter.AccessFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public AccessFilter accessFilter(){
        AccessFilter accessFilter = new AccessFilter();
        accessFilter.setExcludes(new String[]{
                "/static/**",
                "/WEB-INF/**",
                "/rest/**",
                "/login"});
        accessFilter.setAccessUrls(new String[]{
                "/**/**",
//                "/",
//                "/login",
//                "/manage/manager"
        });
        accessFilter.setNoLoginRedirectUrl("/login");
        accessFilter.setAccessDeniedRedirectUrl("/");
        return accessFilter;
    }

}
