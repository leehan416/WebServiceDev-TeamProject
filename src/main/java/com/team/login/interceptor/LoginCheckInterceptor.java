package com.team.login.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckInterceptor implements HandlerInterceptor {


    // interceptor pre handler
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // get session
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("login");

        // if there are no login session,
        if (obj == null) {
            // redirect to login page
            response.sendRedirect(request.getContextPath() + "/login");

            return false;
        }

        return true;
    }

    // interceptor post handler
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
}