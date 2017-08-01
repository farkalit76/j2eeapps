/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.study.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Handler interceptors are configured in Spring’s web application context, 
 * so they can make use of any container features and refer to any beans declared in the container. 
 * A handler interceptor can be registered for particular URL mappings, 
 * so it only intercepts requests mapped to certain URLs.
 *
 * Each handler interceptor must implement the HandlerInterceptor interface, 
 * which contains three callback methods for you to implement: preHandle(), postHandle(), and afterCompletion().
 *
 * @author 72010995
 */
public class CustomRequestHandler extends HandlerInterceptorAdapter
{

    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response,
            Object handler)
            throws Exception
    {
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            ModelAndView modelAndView)
            throws Exception
    {
        long startTime = (Long) request.getAttribute("startTime");
        request.removeAttribute("startTime");

        long endTime = System.currentTimeMillis();
        modelAndView.addObject("totalTime", endTime - startTime);

        System.out.println("Request Prcessing Time :: " + (endTime - startTime));
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            Exception exceptionIfAny)
            throws Exception
    {
        System.out.println("View Rendered !!");
    }
}
