//package com.example.demo.filter;
//
//
//import com.example.demo.filter.base.BaseWebSecurityFilter;
//import com.example.demo.util.SessionUtil;
//import com.example.demo.vo.User;
//import org.springframework.util.AntPathMatcher;
//import org.springframework.util.PathMatcher;
//
//import javax.annotation.PostConstruct;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class SessionProcessingFilter extends BaseWebSecurityFilter {
//
//	private static String defaultRedirectUrl = "/login";
//
//	private String[] authenticationAccessibleResources = new String[0];
//
//	public void setAuthenticationAccessibleResources(String[] authenticationAccessibleResources) {
//		if(authenticationAccessibleResources != null) {
//			this.authenticationAccessibleResources = authenticationAccessibleResources;
//		}
//	}
//
//	public String[] getAuthenticationAccessibleResources() {
////		if(authenticationAccessibleResources.length == 0) {
////			menuService.setAuthenticationAclFilterMenuUrl();
////		}
//		return authenticationAccessibleResources;
//	}
//
//	@PostConstruct
//	public void init() {
//	}
//
//	@Override
//	public void doHttpFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
//		User prevUser = (User) SessionUtil.getSession("loginUser");
//		boolean isAccessible = isAccessible(request);
//		if(isAccessible) {
//			chain.doFilter(request, response);
//			return;
//		}
//		if(prevUser == null) {
//			HttpServletResponse httpServletResponse = (HttpServletResponse) response;
//			chain.doFilter(request, response);
////			httpServletResponse.sendRedirect(defaultRedirectUrl);
//			return;
//		}
////		if(prevUser != null && prevUser.isExpired()) {}
//		chain.doFilter(request, response);
//	}
//
//	private PathMatcher pathMatcher = new AntPathMatcher();
//	private boolean isAccessible(HttpServletRequest request){
//		String url = request.getServletPath();
//		for(String path : getAuthenticationAccessibleResources()) {
//			if(pathMatcher.match(path, url)) {
//				return true;
//			}
//		}
//		return false;
//	}
//
//}
