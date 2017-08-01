/*
 * Copyright (c) Vertex Business Services.
 * All rights reserved.
 * 
 * No parts of this source code can be reproduced without written consent from
 * Vertex Business Services.
 */
package com.usman.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author 72010995
 */
@Controller
@RequestMapping("/first")
public class FirstPageController
{

    @RequestMapping("/employee")
    public ModelAndView showEmployee()
    {
        System.out.println("employee display ");
        ModelAndView model = new ModelAndView("employee");
        return model;

    }
    
    @RequestMapping("/customer")
    public String showCustomer(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model)
    {
        System.out.println("customer display ");
        model.addAttribute("name", name);
        //returns the view name
        return "customer";

    }

    
}
