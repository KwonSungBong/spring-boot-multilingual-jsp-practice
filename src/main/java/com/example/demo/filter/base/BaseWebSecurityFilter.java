package com.example.demo.filter.base;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class BaseWebSecurityFilter implements Filter {

    @Override
	public final void init(FilterConfig filterConfig) throws ServletException {
    	// Does nothing.
    }

    @Override
	public final void destroy() {
    	// Does nothing.
    }

    @Override
	public final void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        doHttpFilter((HttpServletRequest)request, (HttpServletResponse)response, chain);
    }

    protected abstract void doHttpFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException;

}
