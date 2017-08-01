/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.controller;

import com.usman.medical.data.AdminResponse;
import com.usman.medical.data.Doctor;
import com.usman.medical.data.Payment;
import com.usman.medical.service.DoctorService;
import com.usman.medical.service.PaymentService;
import com.usman.medical.util.CommonUtils;
import com.usman.medical.util.IDGenerator;
import com.usman.medical.util.KeyValues;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author 72010995
 */
@Controller
@RequestMapping("/payment")
public class PaymentController
{
    private static final Logger LOG = LoggerFactory.getLogger(PaymentController.class);
    @Autowired
    private PaymentService paymentService;
    
    @Autowired
    private DoctorService doctorService;

    @RequestMapping("/show")
    public ModelAndView showPayment()
    {
        LOG.info("Payment display ");
        ModelAndView model = new ModelAndView("payment_list");
        //PaymentDao dao = new PaymentDao();
        List<Payment> listPayment = paymentService.listPayment();
        LOG.info("Payment size: " + listPayment.size());
        model.addObject("payments", listPayment);
        return model;
    }

    @RequestMapping("/new")
    public ModelAndView newPayment(HttpServletRequest request, Model models)
    {
        LOG.info("Payment New ");
        int patsId = Integer.parseInt(request.getParameter("patsId"));
        ModelAndView model = new ModelAndView("payment", "payment", new Payment());
        model.addObject("patsId", "" + patsId);

        //Add drop down values
        model.addObject("feetypes", CommonUtils.getFeeTypes());
        model.addObject("departments", CommonUtils.getDepartments());
        model.addObject("doctors", getDoctors());
        return model;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createPayment(@ModelAttribute("payment") Payment payment, BindingResult result, Model model)
    {
        LOG.info("start patient creation.....");
        try
        {
            LOG.info("Payment:" + payment.toString());
            payment.setModuleId(IDGenerator.getRandomNum());
            //PaymentDao dao = new PaymentDao();
            AdminResponse admResponse = paymentService.createPayment(payment);
            LOG.info("Payment created. ");
            List<Payment> payments = paymentService.listPayment();
            model.addAttribute("payments", payments);
        }
        catch (Exception e)
        {
            System.err.println("PAyment error:"+e.getMessage());
        }
        return "payment_list";
    }

    @RequestMapping("/edit")
    public String updatePayment(HttpServletRequest request, Model model)
    {
        LOG.info("Payment edit ");
        int paysId = Integer.parseInt(request.getParameter("paysId"));

        //PaymentDao dao = new PaymentDao();
        Payment payment = paymentService.findPaymentById(paysId);
        model.addAttribute("payment", payment);
        model.addAttribute("action", "EDIT");
        
         //Add drop down values
        model.addAttribute("feetypes", CommonUtils.getFeeTypes());
        model.addAttribute("departments", CommonUtils.getDepartments());
        model.addAttribute("doctors", getDoctors());
        LOG.info("payment edit completed.");
        return "payment";

    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String editPayment(@ModelAttribute("payment") Payment payment, BindingResult result, Model model)
    {
        LOG.info("Payment update ");
        //PaymentDao dao = new PaymentDao();
        AdminResponse admResponse = paymentService.updatePayment(payment);
        LOG.info("Payment update completged. ");
        List<Payment> payments = paymentService.listPayment();
        model.addAttribute("payments", payments);

        return "payment_list";
    }

    
    private List<KeyValues> getDoctors()
    {
        List<KeyValues> doctors = new ArrayList<KeyValues>();
        for (Doctor docs : doctorService.listDoctor())
        {
            doctors.add(new KeyValues(""+docs.getModuleId(), docs.getName()));
        }
        return doctors;
    }
}
