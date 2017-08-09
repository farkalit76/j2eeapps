/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.service;

import com.usman.medical.data.Report;
import com.usman.medical.data.ReportSearch;
import java.util.List;

/**
 *
 * @author 72010995
 */
public interface ReportService
{
    List<Report> searchReportForDoctor(ReportSearch reportSearch);
    List<Report> searchReportForPatient(ReportSearch reportSearch);
    List<Report> searchReportForPayment(ReportSearch reportSearch);
    
}
