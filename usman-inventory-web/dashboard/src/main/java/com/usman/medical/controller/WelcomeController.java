/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.controller;

import com.usman.medical.data.Company;
import com.usman.medical.service.ICompanyService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author fusman
 */
@Controller
@RequestMapping("/inventory")
public class WelcomeController {
    
    private static final Logger LOG = LoggerFactory.getLogger(WelcomeController.class);
    
    @Autowired
    private ICompanyService companyService;

    @RequestMapping("/show")
    public ModelAndView showDoctor(HttpServletRequest request)
    { 
        LOG.info("Welcome Inventory display ");
        Company company = new Company();
        ModelAndView model = new ModelAndView("welcome");
        List<Company> companies = companyService.listCompany();
        if (companies != null)
        {
            LOG.info("companies size: "+companies.size());
            company = companies.get(0);//Get the first data to display name and address.
        }
        //LOG.info("set in session company: "+company.toString()); 
        model.addObject("company", company);
        
        HttpSession session = request.getSession(true);
        //it will display on all the pages
        session.setAttribute("company", company);
        return model;
    }
}
