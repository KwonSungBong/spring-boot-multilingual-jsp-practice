package com.example.demo.filter;

import com.example.demo.filter.base.BaseFilter;
import com.example.demo.util.SessionUtil;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class AccessFilter extends BaseFilter {

    private PathMatcher pathMatcher = new AntPathMatcher();

    @Setter
    private String[] accessUrls = new String[0];

    @Setter
    private String noLoginRedirectUrl;

    @Setter
    private String accessDeniedRedirectUrl;

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        try{
            if(isExcludedUrl(httpServletRequest)) {
                log.info("isExcludedUrl");
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }

            if(!SessionUtil.isLogin()) {
                log.info("isLogin");
    			httpServletResponse.sendRedirect(noLoginRedirectUrl);
                return;
            }

            if(!isAccessedUrl(httpServletRequest)) {
                log.info("isAccessedUrl");
                httpServletResponse.sendRedirect(accessDeniedRedirectUrl);
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }

            log.info("AsccessFilter");
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
