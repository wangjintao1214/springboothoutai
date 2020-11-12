package com.kgc.movie.movie.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author shkstart
 * @create 2020-11-12 11:01
 */
public class MyInterceptor implements HandlerInterceptor {
    //拦截器
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        HttpSession session=request.getSession();
        String name = (String) session.getAttribute("name");
        if(name==null){
            request.setAttribute("msg","对不起，请先登录！！！");
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }else{
            return true;
        }
    }
}
