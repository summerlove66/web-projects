package com.patrick.example.process;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class FormInterceptor extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handle) throws Exception {

        String vt = "vt";
        HttpSession session = request.getSession();

        if (session.getAttribute(vt) == null) {
            session.setAttribute(vt, 0);
        }

        int visited = (int) session.getAttribute(vt);
        System.out.println(visited);
        session.setAttribute(vt, visited + 1);
        if (visited % 2 == 1) {
            response.getWriter().write("please  reload the page");

            return false;
        }

        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub
        System.out.println(modelAndView.getViewName());
        modelAndView.addObject("isok", "---------------");

        super.postHandle(request, response, handler, modelAndView);

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub
        super.afterCompletion(request, response, handler, ex);
    }


}
