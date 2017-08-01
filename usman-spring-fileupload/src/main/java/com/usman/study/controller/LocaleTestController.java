/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.study.controller;

import com.usman.study.service.EmployeeManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author 72010995
 */
@Controller
@RequestMapping("/locale")
public class LocaleTestController
{
    private static final Logger LOG = LoggerFactory.getLogger(LocaleTestController.class);
    
    @Autowired
    EmployeeManager manager;
     
    @RequestMapping("/test")
    public ModelAndView showEmployee()
    {
        LOG.info("showEmployee started....");
        System.out.println("Locale display ");
        ModelAndView model = new ModelAndView("locale_test");
        model.addObject("employees",manager.getAllEmployees());
        return model;

    }
    
}
