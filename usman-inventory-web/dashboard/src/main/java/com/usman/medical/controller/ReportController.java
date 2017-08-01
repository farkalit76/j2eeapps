/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.controller;

import com.usman.medical.data.Report;
import com.usman.medical.data.ReportSearch;
import com.usman.medical.service.ReportService;
import java.util.List;
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
@RequestMapping("/report")
public class ReportController
{

    private static final Logger LOG = LoggerFactory.getLogger(ReportController.class);

    @Autowired
    private ReportService reportService;

    @RequestMapping("/show")
    public ModelAndView showDoctor()
    {
        LOG.info("Report display ");

        ModelAndView model = new ModelAndView("report_list", "reportSearch", new ReportSearch());

        return model;
    }

    @RequestMapping(value = "/searchDoctor", method = RequestMethod.POST)
    public String searchReportForDoctor(@ModelAttribute("reportSearch") ReportSearch report, BindingResult result, Model models)
    {
        LOG.info("Patient search ");
        models.addAttribute("reportSearch", report);
        //ModelAndView model = new ModelAndView("patient_list", "patientSearch", new Patient());
        //ReportDao dao = new ReportDao();
        List<Report> doctorReports = reportService.searchReportForDoctor(report);
        models.addAttribute("doctorReports", doctorReports);
        models.addAttribute("reportSearch", report);//set for report search page

        return "report_list";

    }
}
