/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.springhib.controller;

import com.usman.springhib.api.IDoctor;
import com.usman.springhib.model.Doctor;
import java.util.List;
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
@RequestMapping("/doctor")
public class DoctorController
{
    private static final Logger LOG = LoggerFactory.getLogger(DoctorController.class);
    
    @Autowired
    private IDoctor doctorDao;

    @RequestMapping("/show")
    public ModelAndView showDoctor()
    {
        LOG.info("Doctor display ");
        ModelAndView model = new ModelAndView("doctor_list");
        //DoctorDao dao = new DoctorDao();
        List<Doctor> doctors = doctorDao.listDoctor();
        model.addObject("doctors", doctors);
        return model;

    }

//    @RequestMapping("/new")
//    public ModelAndView newDoctor()
//    {
//        System.out.println("Doctor display ");
//        ModelAndView model = new ModelAndView("doctor", "doctor", new Doctor());
//        model.addObject("sexdata", CommonUtils.getSexTypes());
//        return model;
//
//    }
//
//    @RequestMapping(value = "/create", method = RequestMethod.POST)
//    public String createDoctor(@ModelAttribute("doctor") Doctor doctor, BindingResult result, Model model)
//    {
//        System.out.println("Doctor create.....");
//        try
//        {
//            System.out.println("Doctor:" + doctor.toString());
//            doctor.setDateOfBirth(DateUtils.getDate(doctor.getDob(), "yyyy-MM-dd"));
//            doctor.setModuleId(IDGenerator.getRandomNum());
//            //DoctorDao dao = new DoctorDao();
//            AdminResponse admResponse = doctorDao.createDoctor(doctor);
//            System.out.println("Doctor create done. ");
//            List<Doctor> doctors = doctorDao.listDoctor();
//            model.addAttribute("doctors", doctors);
//            System.out.println("Doctor create completed. ");
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//        return "doctor_list";
//    }
//
//    @RequestMapping("/edit")
//    public String updateDoctor(HttpServletRequest request, Model model)
//    {
//        System.out.println("Doctor edit ");
//        int docId = Integer.parseInt(request.getParameter("docId"));
//
//        //DoctorDao dao = new DoctorDao();
//        Doctor doctor = doctorDao.findDoctorById(docId);
//        doctor.setDob(DateUtils.getDateToString("yyyy-MM-dd", doctor.getDateOfBirth()));
//        model.addAttribute("doctor", doctor);
//        model.addAttribute("action", "EDIT");
//        model.addAttribute("sexdata", CommonUtils.getSexTypes());
//        System.out.println("Doctor edit completed.");
//        return "doctor";
//
//    }
//    
//     @RequestMapping(value = "/update", method = RequestMethod.POST)
//    public String editDoctor(@ModelAttribute("doctor") Doctor doctor, BindingResult result,Model model)
//    {
//        System.out.println("Doctor update ");
//        //DoctorDao dao = new DoctorDao();
//        doctor.setDateOfBirth(DateUtils.getDate(doctor.getDob(), "yyyy-MM-dd"));
//        AdminResponse admResponse = doctorDao.updateDoctor(doctor);
//        System.out.println("Doctor update completged. ");
//        List<Doctor> doctors =  doctorDao.listDoctor();
//        model.addAttribute("doctors", doctors);
//     
//        return "doctor_list";
//
//    }
//
//    @RequestMapping("/delete")
//    public String deleteDoctor(HttpServletRequest request, Model model)
//    {
//        System.out.println("Doctor delete..... ");
//        int docId = Integer.parseInt(request.getParameter("docId"));
//        Doctor doctor = new Doctor();
//        doctor.setModuleId(docId);
//        //DoctorDao dao = new DoctorDao();
//        doctorDao.deleteDoctor(doctor);
//        List<Doctor> doctors = doctorDao.listDoctor();
//        model.addAttribute("doctors", doctors);
//        System.out.println("Doctor deleted. ");
//        return "doctor_list";
//    }

}
