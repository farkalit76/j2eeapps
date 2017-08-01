/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.controller;

import com.usman.medical.data.AdminResponse;
import com.usman.medical.data.Customer;
import com.usman.medical.service.ICustomerService;
import com.usman.medical.util.CommonUtils;
import com.usman.medical.util.DateUtils;
import com.usman.medical.util.IDGenerator;
import com.usman.medical.validator.CustomerFormValidator;
import com.usman.medical.validator.DoctorFormValidator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author fusman
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
  
    private static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);
    private static final String DATE_FORMAT = "dd-MM-yyyy";// "yyyy-MM-dd";
    
     @Autowired
    private ICustomerService customerService;

    @Autowired
    CustomerFormValidator customerFormValidator;

    //Set a form validator
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(customerFormValidator);
    }
    
    @RequestMapping("/show")
    public ModelAndView showDoctor()
    {
        LOG.info("Customer display ");
        ModelAndView model = new ModelAndView("customer_list");

        List<Customer> customers = customerService.listCustomer();
        model.addObject("customers", customers);
      
        return model;
    }

    @RequestMapping("/new")
    public ModelAndView newCustomer()
    {
        LOG.info("Customer display ");
        ModelAndView model = new ModelAndView("customer", "customer", new Customer());
        model.addObject("sexdata", CommonUtils.getSexTypes());
        model.addObject("departments", CommonUtils.getDepartments());
        return model;

    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createCustomer(@ModelAttribute("customer") @Validated Customer customer, BindingResult result, Model model)
    {
        LOG.info("Customer create.....");
        try
        {
            LOG.info("customer:" + customer.toString());
            if(result.hasErrors()) {
                model.addAttribute("sexdata", CommonUtils.getSexTypes());
                model.addAttribute("departments", CommonUtils.getDepartments());
                return "customer";
            }
            else
            {
                customer.setDateOfBirth(DateUtils.getDate(customer.getDob(), DATE_FORMAT));
                customer.setModuleId(IDGenerator.getRandomNum());
                AdminResponse admResponse = customerService.createCustomer(customer);
    //            LOG.info("customer create done. ");
    //            List<Customer> customers = customerService.listCustomer();
    //            model.addAttribute("customers", customers);
                LOG.info("Customer create completed. ");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        //return "customer_list";
        //It wiil Prevent duplicate form submission
        return "redirect:/app/views/customer/registration-success";
    }
    
    @RequestMapping(value = "/registration-success", method = RequestMethod.GET)
    public String handleRegistrationDone(@ModelAttribute("customer") Customer customer,  Model model){
        System.out.println("customer....: "+customer);
        List<Customer> customers = customerService.listCustomer();
        model.addAttribute("customers", customers);
        return "customer_list";
    }

    @RequestMapping("/edit")
    public String updateCustomer(HttpServletRequest request, Model model)
    {
        LOG.info("Customer edit ");
        int custId = Integer.parseInt(request.getParameter("custId"));

        Customer customer = customerService.findCustomerById(custId);
        customer.setDob(DateUtils.getDateToString("yyyy-MM-dd", customer.getDateOfBirth()));
        model.addAttribute("customer", customer);
        model.addAttribute("action", "EDIT");
        model.addAttribute("sexdata", CommonUtils.getSexTypes());
        model.addAttribute("departments", CommonUtils.getDepartments());
        LOG.info("Customer edit completed.");
        return "customer";

    }
    
     @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String editCustomer(@ModelAttribute("customer") @Validated Customer customer, BindingResult result,Model model)
    {
        LOG.info("Customer update ");
        if(result.hasErrors()) {
              model.addAttribute("sexdata", CommonUtils.getSexTypes());
              model.addAttribute("departments", CommonUtils.getDepartments());
              return "customer";
        }
        else
        {
            customer.setDateOfBirth(DateUtils.getDate(customer.getDob(), DATE_FORMAT));
            AdminResponse admResponse = customerService.updateCustomer(customer);
            LOG.info("Customer update completged. ");
            List<Customer> customers =  customerService.listCustomer();
            model.addAttribute("customers", customers);
        }
     
        return "customer_list";

    }

    @RequestMapping("/delete")
    public String deleteCustomer(HttpServletRequest request, Model model)
    {
        LOG.info("Customer delete..... ");
        int custId = Integer.parseInt(request.getParameter("custId"));
        Customer customer = new Customer();
        customer.setModuleId(custId);

        customerService.deleteCustomer(customer);
        List<Customer> customers = customerService.listCustomer();
        model.addAttribute("customers", customers);
        LOG.info("Customer deleted. ");
        return "customer_list";
    }
}
