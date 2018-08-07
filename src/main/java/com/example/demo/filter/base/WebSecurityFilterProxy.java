package com.example.demo.filter.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.annotation.PostConstruct;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Slf4j
public class WebSecurityFilterProxy implements Filter, Ordered {

	private int order;

    private PathMatcher pathMatcher = new AntPathMatcher();

	private List<BaseWebSecurityFilter> filters;

	private String[] matchedUrlPatterns = new String[0];

	private String[] excludedUrlPatterns = new String[0];

	public void setFilters(List<BaseWebSecurityFilter> filters) {
		this.filters = filters;
	}

	public void setMatchedUrlPatterns(String[] matchedUrlPatterns) {
		this.matchedUrlPatterns = matchedUrlPatterns;
	}

	public void setExcludedUrlPatterns(String[] excludedUrlPatterns) {
		this.excludedUrlPatterns = excludedUrlPatterns;
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@PostConstruct
	public void init()  {
		if(log.isDebugEnabled()) {
			int i = 0;
			for(BaseWebSecurityFilter filter : filters) {
				log.debug("loading framework security filter[" + (++i) + "] - " + filter.getClass().getName());
			}
		}
	}

	@Override
	public void destroy() {
		// do nothing!
	}

	@Override
	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		// 설정된 WebSecurityFilter가 없을 경우
		if(filters == null || filters.size() == 0) {
			chain.doFilter(request, response);
			return;
		}

		HttpServletRequest httpequest = (HttpServletRequest) request;

		// 필터링 적용 URL이 아닌 경우
		if(!isMatchedUrl(httpequest.getRequestURI())) {
			chain.doFilter(request, response);
			return;
		}

		// 필터링 예외 URL인 경우
		if(isExcludedUrl(httpequest.getRequestURI())) {
			chain.doFilter(request, response);
			return;
		}

		WebSecurityFilterChain webSecurityFilterChain = new WebSecurityFilterChain(chain, filters);
		webSecurityFilterChain.doFilter(request, response);
	}

	private boolean isMatchedUrl(String url) {
		for(String path : matchedUrlPatterns) {
	        if(pathMatcher.match(path, url)) {
	        	return true;
	        }
		}
		return false;
    }

	private boolean isExcludedUrl(String url) {
		for(String path : excludedUrlPatterns) {
	        if(pathMatcher.match(path, url)) {
	        	return true;
	        }
		}
		return false;
    }

	private static class WebSecurityFilterChain implements FilterChain {
		private FilterChain filterChain;
		private List<BaseWebSecurityFilter> filters;
		private int currentPosition = 0;

		WebSecurityFilterChain(FilterChain filterChain, List<BaseWebSecurityFilter> filters) {
			this.filterChain = filterChain;
			this.filters = filters;
		}

		@Override
		public void doFilter(ServletRequest request, ServletResponse response) throws IOException, ServletException {
			if (currentPosition == filters.size()) {
				filterChain.doFilter(request, response);
			}
			else {
				currentPosition++;
				Filter nextFilter = filters.get(currentPosition - 1);
				nextFilter.doFilter(request, response, this);

			}
		}
	}
}
