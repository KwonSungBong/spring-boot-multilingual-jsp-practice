package com.example.demo.filter;

import org.springframework.core.Ordered;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

public abstract class BaseFilter implements Filter, Ordered {

    private PathMatcher pathMatcher = new AntPathMatcher();

    private String[] patterns = new String[0];
    private String[] excludes = new String[0];

    public void setPatterns(String[] patterns) {
        this.patterns = patterns;
    }
    public String[] getPatterns() {
        return patterns;
    }
    public void setExcludes(String[] excludes) {
        this.excludes = excludes;
    }
    public String[] getExcludes() {
        return excludes;
    }

    private int order;

    @Override
    abstract public void init(FilterConfig filterConfig);

    @Override
    abstract public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain);

    @Override
    abstract public void destroy();

    public void setOrder(int order) {
        this.order = order;
    }
    @Override
    public int getOrder() {
        return this.order;
    }

    protected boolean isMatchedUrl(ServletRequest servletRequest) {
        boolean rst = false;
        HttpServletRequest httpequest = (HttpServletRequest) servletRequest;
        String url = httpequest.getRequestURI();

        if(this.patterns.length==0){
            return true;
        }

        for(String path : this.patterns) {
            if(pathMatcher.match(path, url)) {
                return true;
            }
        }
        return rst;
    }

    protected boolean isExcludedUrl(ServletRequest servletRequest) {
        HttpServletRequest httpequest = (HttpServletRequest) servletRequest;
        String url = httpequest.getRequestURI();
        if(excludes.length==0){
            return false;
        }
        for(String path : excludes) {
            if(pathMatcher.match(path, url)) {
                return true;
            }
        }
        return false;
    }
}
