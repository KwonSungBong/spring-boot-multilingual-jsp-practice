package com.example.demo.config;

import com.example.demo.filter.AccessFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public AccessFilter accessFilter(){
        AccessFilter accessFilter = new AccessFilter();
        accessFilter.setPatterns(new String[]{
        });
        return accessFilter;
    }

//    @Bean
//    public WebSecurityFilterProxy webSecurityFilter(SessionProcessingFilter sessionUserIntegratorFilter
//            , AuthenticationAclFilter authenticationAclFilter){
//        WebSecurityFilterProxy filterRegBean = new WebSecurityFilterProxy();
//        filterRegBean.setMatchedUrlPatterns(new String[]{
//                "/**/*.do"
////                ,"/**/*.json"
//        });
//        filterRegBean.setExcludedUrlPatterns(new String[]{
////                "/login",
////                "/WEB-INF/jsp/layout/*.jsp",
////                "/WEB-INF/jsp/view/*.jsp",
//        });
//        List<BaseWebSecurityFilter> list = new ArrayList<>();
//        list.add(sessionUserIntegratorFilter);
//        list.add(authenticationAclFilter);
//        filterRegBean.setFilters(list);
//        return filterRegBean;
//    }
//
//    @Bean
//    public SessionProcessingFilter sessionUserIntegratorFilter(){
//        SessionProcessingFilter filter = new SessionProcessingFilter();
//        filter.setAuthenticationAccessibleResources(new String [] {
//                "/login"
//        });
//        return filter;
//    }
//
//    @Bean
//    public AuthenticationAclFilter authenticationAclFilter(MenuService menuService){
//        AuthenticationAclFilter authenticationAclFilter = new AuthenticationAclFilter(menuService);
//        return authenticationAclFilter;
//    }

}
