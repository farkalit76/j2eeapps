/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.controller;

import com.usman.medical.data.Hospital;
import com.usman.medical.service.HospitalService;
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
 * @author 72010995
 */
@Controller
@RequestMapping("/medical")
public class MedicalWelcomeController
{
    private static final Logger LOG = LoggerFactory.getLogger(MedicalWelcomeController.class);
    @Autowired
    private HospitalService hospitalService;

    @RequestMapping("/show")
    public ModelAndView showDoctor(HttpServletRequest request)
    { 
        LOG.info("Welcome Medical display ");
        Hospital hospital = new Hospital();
        ModelAndView model = new ModelAndView("welcome");
        List<Hospital> hospitals = hospitalService.getHospitals();
         LOG.info("hospitals size: "+hospitals.size());
        if (hospitals != null)
        {
            hospital = hospitals.get(0);//Get the first data to display name and address.
        }
        model.addObject("hospital", hospital);
        
        HttpSession session = request.getSession(true);
        LOG.info("set in session hospital: "+hospital.toString());
        session.setAttribute("hospital", hospital);
        return model;

    }
}
