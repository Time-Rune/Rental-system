package com.example.rentalsystem.utils;

import com.example.rentalsystem.entity.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

public class UserContext {
    private static final String CURRENT_USER_IN_SESSION = "current_user_info";

    public static String getUserInfoID(){
        return CURRENT_USER_IN_SESSION;
    }

    private static HttpSession getSession(){
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
    }

    public static void putCurrentUserIntoSession(User user){
        HttpSession httpSession = getSession();
        httpSession.setAttribute(CURRENT_USER_IN_SESSION, user);
    }

    public static User getCurrentUser(){
        HttpSession httpSession = getSession();
        return (User) httpSession.getAttribute(CURRENT_USER_IN_SESSION);
    }

    public static void removeCurrentUser(){
        HttpSession httpSession = getSession();
        httpSession.removeAttribute(CURRENT_USER_IN_SESSION);
    }
}
