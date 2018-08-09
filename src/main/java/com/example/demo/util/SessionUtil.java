package com.example.demo.util;

import com.example.demo.vo.LoginUser;
import com.example.demo.vo.User;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class SessionUtil {

    private static String LOGIN_USER_KEY = "loginUser";
    public static Map<String, List<LoginUser>> loginUserMap = new ConcurrentHashMap<>();

    public static HttpServletRequest getCurrentRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest servletRequest = ((ServletRequestAttributes) requestAttributes).getRequest();
        return servletRequest;
    }

    public static void login(User user) {
        LoginUser loginUser = new LoginUser();
        loginUser.setUser(user);
        loginUser.setSession(getCurrentRequest().getSession());
        setSession(LOGIN_USER_KEY, loginUser);
        if(loginUserMap.containsKey(loginUser.getUsername())) {
            loginUserMap.get(loginUser.getUsername()).add(loginUser);
        } else {
            List<LoginUser> loginUserSet = new Vector<>();
            loginUserSet.add(loginUser);
            loginUserMap.put(loginUser.getUsername(), loginUserSet);
        }
    }

    public static void logout() {
        List<LoginUser> loginUserSet = loginUserMap.get(getLoginUser().getUsername());
        loginUserSet.remove(getLoginUser());
        invalidate();
    }

    public static LoginUser getLoginUser() {
        return (LoginUser) getCurrentRequest().getSession().getAttribute(LOGIN_USER_KEY);
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
