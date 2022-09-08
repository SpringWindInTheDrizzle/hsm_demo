package com.example.hsm_demo.auth;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ClientServerAuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UserDetail userDetail = (UserDetail) request.getSession().getAttribute("USER_SESSION_KEY");
        if (userDetail == null) {
            return false;
        }
        ThreadLocalStore.setCurrentUser(userDetail);
        return true;
    }
}
