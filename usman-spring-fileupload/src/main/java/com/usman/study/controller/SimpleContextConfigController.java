/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.study.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;

/**
 * How to get ServletContext and ServletConfig object in a Spring Bean?
 * Simply implement ServletContextAware and ServletConfigAware interfaces and override below methods
 * 
 * @author 72010995
 */
@Controller
@RequestMapping(value = "/context")
public class SimpleContextConfigController implements ServletContextAware, ServletConfigAware {
 
    private ServletContext context;
    private ServletConfig config;
 
    @Override
    public void setServletConfig(final ServletConfig servletConfig) {
        this.config = servletConfig;
 
    }
 
    @Override
    public void setServletContext(final ServletContext servletContext) {
        this.context = servletContext;
    }
     
    @RequestMapping("/test")
    public ModelAndView showEmployee()
    {
        System.out.println("Config/context display ");
       
        List<String> lists = new ArrayList<>();
        
        final Enumeration<String> attributeNames = context.getAttributeNames();
        
        while (attributeNames.hasMoreElements())
        {
            String nextElement = attributeNames.nextElement();
            System.out.println("context:"+nextElement);
            lists.add("context:"+nextElement+ ", value:"+ context.getInitParameter(nextElement)+"</br>");
            
        }
        final Enumeration<String> initParam = config.getInitParameterNames();
        
        while (initParam.hasMoreElements())
        {
            String nextElement = initParam.nextElement();
            System.out.println("config:"+nextElement);
            lists.add("config name:"+nextElement+ ", value:"+ config.getInitParameter(nextElement) +"</br>");
        }  
        ModelAndView model = new ModelAndView("config_test"); 
        model.addObject("contextList", lists);
        return model;

    }
    
    //other code
}
