package com.example.demo.util;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class SessionUtil {

    public static HttpServletRequest getCurrentRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest servletRequest = ((ServletRequestAttributes) requestAttributes).getRequest();
        return servletRequest;
    }

    public static Object getSession(String key) {
        return getCurrentRequest().getSession().getAttribute(key);
    }

    public static void setSession(String key, Object value) {
        getCurrentRequest().getSession().setAttribute(key, value);
    }

    public static void invalidate() {
        getCurrentRequest().getSession().invalidate();
    }

}
