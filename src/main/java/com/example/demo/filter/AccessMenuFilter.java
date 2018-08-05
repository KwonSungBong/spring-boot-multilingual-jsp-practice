package com.example.demo.filter;

import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccessMenuFilter extends BaseFilter {

    private PathMatcher pathMatcher = new AntPathMatcher();

    private String[] accessUrls = new String[]{"/login", "/manage/manager"};

    @Override
    public void init(FilterConfig filterConfig) {
        setExcludes(new String[]{"/WEB-INF/jsp/layout/*.jsp", "/WEB-INF/jsp/view/*.jsp", "/login", "/manage/manager"});
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        try{
            if(isExcludedUrl(httpServletRequest)) {
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
            if(!isAccessedUrl(httpServletRequest)) {
                httpServletResponse.sendRedirect("/login");
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
            System.out.println("AccessMenuFilter");
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Throwable t) {
        } finally {
        }
    }

    @Override
    public void destroy() {

    }

    protected boolean isAccessedUrl(ServletRequest servletRequest) {
        HttpServletRequest httpequest = (HttpServletRequest) servletRequest;
        String url = httpequest.getRequestURI();
        if(accessUrls.length==0){
            return false;
        }
        for(String path : accessUrls) {
            if(pathMatcher.match(path, url)) {
                return true;
            }
        }
        return false;
    }

}
