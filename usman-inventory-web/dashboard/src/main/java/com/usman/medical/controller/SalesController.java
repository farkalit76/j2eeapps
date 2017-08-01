/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.controller;

import com.usman.medical.data.Company;
import com.usman.medical.data.Sale;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author fusman
 */
@Controller
@RequestMapping("/sales")
public class SalesController {
    
    private static final Logger LOG = LoggerFactory.getLogger(WelcomeController.class);
    
//    @Autowired
//    private ICompanyService companyService;

    @RequestMapping("/show")
    public ModelAndView showSale(HttpServletRequest request)
    { 
        LOG.info("Sales display ");
        Company company = new Company();
        ModelAndView model = new ModelAndView("sale");
        //List<Company> companies = companyService.listCompany();
        
        model.addObject("sales", getSales());
        return model;
    }
    
    private List<Sale> getSales()
    {
        List<Sale> sales = new ArrayList<Sale>();
        Sale sale = new Sale();
        sale.setModuleId(12122);
        sale.setProdId(123);
        sale.setProdName("XYZ");
        sale.setQuantity(22);
        sale.setAmount(12312.22);
        sale.setCustId(123);
        sale.setDescription("asdasdasdas");
        sale.setCreatedBy("usman");
        sale.setCreatedDate(null);
        sales.add(sale);

        return sales;
    }
}
