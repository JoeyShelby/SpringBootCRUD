package org.joey.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author: JoeyShelby
 * @date: 2022-06-16 09:12
 */
public class UserHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if (session.getAttribute("username") != null) {
            return true;
        } else {
            request.getRequestDispatcher("/index").forward(request,response);
            return false;
        }
    }

}
