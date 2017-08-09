/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.controller;

import com.usman.medical.data.AdminResponse;
import com.usman.medical.data.Doctor;
import com.usman.medical.jersey.client.DoctorJerseyClient;
import com.usman.medical.service.DoctorService;
import com.usman.medical.util.CommonUtils;
import com.usman.medical.util.DateUtils;
import com.usman.medical.util.IDGenerator;
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
@RequestMapping("/doctor")
public class DoctorController
{
    private static final Logger LOG = LoggerFactory.getLogger(DoctorController.class);
    private static final String DATE_FORMAT = "dd-MM-yyyy";// "yyyy-MM-dd";
    
     @Autowired
    private DoctorService doctorService;

    @RequestMapping("/show")
    public ModelAndView showDoctor()
    {
        LOG.info("Doctor display ");
        ModelAndView model = new ModelAndView("doctor_list");
        //DoctorDao dao = new DoctorDao();
        //List<Doctor> doctors = doctorService.listDoctor();
        List<Doctor> doctors = DoctorJerseyClient.getGenericType();
        System.out.println("doctors:"+doctors.size());
        model.addObject("doctors", doctors);
      
        return model;
    }

    @RequestMapping("/new")
    public ModelAndView newDoctor()
    {
        LOG.info("Doctor display ");
        ModelAndView model = new ModelAndView("doctor", "doctor", new Doctor());
        model.addObject("sexdata", CommonUtils.getSexTypes());
        model.addObject("departments", CommonUtils.getDepartments());
        return model;

    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createDoctor(@ModelAttribute("doctor") Doctor doctor, BindingResult result, Model model)
    {
        LOG.info("Doctor create.....");
        try
        {
            LOG.info("Doctor:" + doctor.toString());
            doctor.setDateOfBirth(DateUtils.getDate(doctor.getDob(), DATE_FORMAT));
            doctor.setModuleId(IDGenerator.getRandomNum());
            //DoctorDao dao = new DoctorDao();
            AdminResponse admResponse = doctorService.createDoctor(doctor);
            LOG.info("Doctor create done. ");
            List<Doctor> doctors = doctorService.listDoctor();
            model.addAttribute("doctors", doctors);
            LOG.info("Doctor create completed. ");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return "doctor_list";
    }
    

    @RequestMapping("/edit")
    public String updateDoctor(HttpServletRequest request, Model model)
    {
        LOG.info("Doctor edit ");
        int docId = Integer.parseInt(request.getParameter("docId"));

        //DoctorDao dao = new DoctorDao();
        Doctor doctor = doctorService.findDoctorById(docId);
        doctor.setDob(DateUtils.getDateToString("yyyy-MM-dd", doctor.getDateOfBirth()));
        model.addAttribute("doctor", doctor);
        model.addAttribute("action", "EDIT");
        model.addAttribute("sexdata", CommonUtils.getSexTypes());
        model.addAttribute("departments", CommonUtils.getDepartments());
        LOG.info("Doctor edit completed.");
        return "doctor";

    }
    
     @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String editDoctor(@ModelAttribute("doctor") Doctor doctor, BindingResult result,Model model)
    {
        LOG.info("Doctor update ");
        //DoctorDao dao = new DoctorDao();
        doctor.setDateOfBirth(DateUtils.getDate(doctor.getDob(), DATE_FORMAT));
        AdminResponse admResponse = doctorService.updateDoctor(doctor);
        LOG.info("Doctor update completged. ");
        List<Doctor> doctors =  doctorService.listDoctor();
        model.addAttribute("doctors", doctors);
     
        return "doctor_list";

    }

    @RequestMapping("/delete")
    public String deleteDoctor(HttpServletRequest request, Model model)
    {
        LOG.info("Doctor delete..... ");
        int docId = Integer.parseInt(request.getParameter("docId"));
        Doctor doctor = new Doctor();
        doctor.setModuleId(docId);
        //DoctorDao dao = new DoctorDao();
        doctorService.deleteDoctor(doctor);
        List<Doctor> doctors = doctorService.listDoctor();
        model.addAttribute("doctors", doctors);
        LOG.info("Doctor deleted. ");
        return "doctor_list";
    }

}
