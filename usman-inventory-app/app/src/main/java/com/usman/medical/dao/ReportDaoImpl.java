/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.dao;

import com.usman.medical.api.ReportDao;
import com.usman.medical.data.Report;
import com.usman.medical.data.ReportSearch;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 72010995
 */
@Repository
public class ReportDaoImpl implements ReportDao
{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Report> searchReportForDoctor(ReportSearch reportSearch)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Report> searchReportForPatient(ReportSearch reportSearch)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Report> searchReportForPayment(ReportSearch reportSearch)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
