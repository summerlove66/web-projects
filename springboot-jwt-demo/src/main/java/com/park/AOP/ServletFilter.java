package com.park.AOP;


import com.park.utils.JWTUtils;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class ServletFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化 Filter: " + filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        servletResponse.setContentType("application/json; charset=utf-8");
        servletResponse.setCharacterEncoding("UTF-8");

        if (servletRequest instanceof HttpServletRequest)

        {
            int flag = 1;
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            String url = request.getRequestURL().toString();
            System.out.println("url  ---" + url);
            if (url.contains("protected")) {

                String token = request.getParameter("token");
                System.out.println("token " + token);
                try {
                    JWTUtils.parseJWT(token);
                    flag = 2;
                    filterChain.doFilter(servletRequest, servletResponse);
                } catch (Exception e) {
                    e.printStackTrace();
                    flag = 3;
                    RequestDispatcher rd = request.getRequestDispatcher("/badtoken");
                    rd.forward(servletRequest, servletResponse);

                }
            }
            if (flag == 1) {
                filterChain.doFilter(servletRequest, servletResponse);
            }

        }
    }

    @Override
    public void destroy() {
        System.out.println("destory Filter");
    }
}