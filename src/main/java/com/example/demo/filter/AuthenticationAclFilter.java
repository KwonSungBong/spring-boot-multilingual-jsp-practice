//package com.example.demo.filter;
//
//import com.example.demo.filter.base.BaseWebSecurityFilter;
//import com.example.demo.service.MenuService;
//import org.springframework.util.AntPathMatcher;
//import org.springframework.util.PathMatcher;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class AuthenticationAclFilter extends BaseWebSecurityFilter {
//
//	private static String accessDeniedRedirectUrl = "/main/main.do";
//
//	private String[] authenticationAccessibleResources = new String[0];
//
//    private MenuService menuService;
//
//	public AuthenticationAclFilter(MenuService menuService) {
//		super();
//		this.menuService = menuService;
//	}
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
//	@Override
//	public void doHttpFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
////		boolean isCheckAccessible = isCheckAccessible(request);
////		if(isCheckAccessible) {
////			boolean isMenuAccessible = isMenuAccessible(request);
////			if(!isMenuAccessible) {
////				WebUtil.redirect(response, request, accessDeniedRedirectUrl);
////				return;
////			}
////		}
//		chain.doFilter(request, response);
//	}
//
//	private PathMatcher pathMatcher = new AntPathMatcher();
//	private boolean isCheckAccessible(HttpServletRequest request){
//		String url = request.getServletPath();
//		for(String path : getAuthenticationAccessibleResources()) {
//			if(pathMatcher.match(path, url)) {
//				return true;
//			}
//		}
//		return false;
//	}
//
//    private boolean isMenuAccessible(HttpServletRequest request){
////        String url = request.getServletPath();
////		String[] menuUrlList = AdminSessionUtil.getSessionValue("menuUrlList");
////		for(String path : menuUrlList) {
////	        if(pathMatcher.match(path, url)) {
////	        	return true;
////	        }
////		}
//		return false;
//    }
//}