/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.study.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author 72010995
 */
@Controller
@RequestMapping("/aspect")
public class EmployeeAspectTestController
{
    @Autowired
    private EmployeeManager manager;
    
    @RequestMapping("/test")
    public ModelAndView showEmployee()
    {
        System.out.println("Aspect display ");
        
        manager.getEmployeeById(1);
         
        manager.createEmployee(new EmployeeDTO());
         
        manager.deleteEmployee(100);
        
        ModelAndView model = new ModelAndView("aspect_test");
        
        return model;

    }
}
