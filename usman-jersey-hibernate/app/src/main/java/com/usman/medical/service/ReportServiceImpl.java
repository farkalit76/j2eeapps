/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.service;

import com.usman.medical.api.ReportDao;
import com.usman.medical.data.Report;
import com.usman.medical.data.ReportSearch;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 72010995
 */
@Service
public class ReportServiceImpl implements ReportService
{

    @Autowired(required = true)
    private ReportDao reportDao;

    @Override
    @Transactional
    public List<Report> searchReportForDoctor(ReportSearch reportSearch)
    {
        return reportDao.searchReportForDoctor(reportSearch);
    }

    @Override
    @Transactional
    public List<Report> searchReportForPatient(ReportSearch reportSearch)
    {
        return reportDao.searchReportForPatient(reportSearch);
    }

    @Override
    @Transactional
    public List<Report> searchReportForPayment(ReportSearch reportSearch)
    {
        return reportDao.searchReportForPayment(reportSearch);
    }

}
