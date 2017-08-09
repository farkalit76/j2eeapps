/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.controller;

import com.usman.medical.data.AdminResponse;
import com.usman.medical.data.Patient;
import com.usman.medical.service.PatientService;
import com.usman.medical.util.CommonUtils;
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
@RequestMapping("/patient")
public class PatientController
{

    private static final Logger LOG = LoggerFactory.getLogger(PatientController.class);
    @Autowired
    private PatientService patientService;
    
    @RequestMapping("/show")
    public ModelAndView showPatient(@ModelAttribute("patientSearch") Patient patient, BindingResult result, Model models)
    {
        LOG.info("Patient display ");

        // ModelAndView model = new ModelAndView("patient_list", "patientSearch", new Patient());
        ModelAndView model = new ModelAndView("patient_list");
        //PatientDao dao = new PatientDao();
        List<Patient> patients = patientService.listPatient();
        model.addObject("patients", patients);
        return model;

    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchPatient(@ModelAttribute("patientSearch") Patient patient, BindingResult result, Model models)
    {
        LOG.info("Patient search ");
        models.addAttribute("patientSearch", patient);
        //ModelAndView model = new ModelAndView("patient_list", "patientSearch", new Patient());
        //PatientDao dao = new PatientDao();
        List<Patient> patients = patientService.findPatient(patient);
        models.addAttribute("patients", patients);

        return "patient_list";
    }

    @RequestMapping("/new")
    public ModelAndView newPatient()
    {
        LOG.info("Patient display ");
        ModelAndView model = new ModelAndView("patient", "patient", new Patient());
        model.addObject("sexdata", CommonUtils.getSexTypes());
        return model;

    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createPatient(@ModelAttribute("patient") Patient patient, BindingResult result, Model model)
    {
        LOG.info("start patient creation.....");
        try
        {
            LOG.info("patient:" + patient.toString());
            patient.setModuleId(IDGenerator.getRandomNum());
            //PatientDao dao = new PatientDao();
            AdminResponse admResponse = patientService.createPatient(patient);
            LOG.info("Patient created. ");
            List<Patient> patients = patientService.listPatient();
            model.addAttribute("patients", patients);
            model.addAttribute("patientSearch", new Patient());//added for search form
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return "patient_list";
    }

    @RequestMapping("/edit")
    public String updatePatient(HttpServletRequest request, Model model)
    {
        LOG.info("Patient edit ");
        int patsId = Integer.parseInt(request.getParameter("patsId"));

        //PatientDao dao = new PatientDao();
        Patient patient = patientService.findPatientById(patsId);
        model.addAttribute("patient", patient);
        model.addAttribute("action", "EDITS");
        model.addAttribute("sexdata", CommonUtils.getSexTypes());
        LOG.info("Patient edit completed.");
        return "patient";

    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String editPatient(@ModelAttribute("patient") Patient patient, BindingResult result, Model model)
    {
        LOG.info("Patient update ");
        //PatientDao dao = new PatientDao();
        AdminResponse admResponse = patientService.updatePatient(patient);
        LOG.info("Patient update completged. ");
        List<Patient> patients = patientService.listPatient();
        model.addAttribute("patients", patients);
        model.addAttribute("patientSearch", new Patient());//added for search form
        return "patient_list";

    }

    @RequestMapping("/delete")
    public String deletePatient(HttpServletRequest request, Model model)
    {
        LOG.info("Patient delete..... ");
        int patsId = Integer.parseInt(request.getParameter("patsId"));
        Patient patient = new Patient();
        patient.setModuleId(patsId);
        //PatientDao dao = new PatientDao();
        patientService.deletePatient(patient);
        List<Patient> patients = patientService.listPatient();
        model.addAttribute("patients", patients);
        model.addAttribute("patientSearch", new Patient());//added for search form
        LOG.info("Patient deleted. ");
        return "patient_list";

    }
}
