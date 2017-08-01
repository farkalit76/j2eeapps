/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.data;

import java.util.Calendar;

/**
 *
 * @author 72010995
 */
public class ReportSearch
{

    private String doctorName;
    private String strDateFrom;
    private String strDateTo;
    
    private Calendar dateFrom;
    private Calendar dateTo;

    public ReportSearch()
    {
        //set default date from 1 day back from current date.
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        this.dateFrom = cal;
        this.dateTo = Calendar.getInstance();
    }

    public String getDoctorName()
    {
        return doctorName;
    }

    public void setDoctorName(String doctorName)
    {
        this.doctorName = doctorName;
    }

    public Calendar getDateFrom()
    {
        return dateFrom;
    }

    public void setDateFrom(Calendar dateFrom)
    {
        this.dateFrom = dateFrom;
    }

    public Calendar getDateTo()
    {
        return dateTo;
    }

    public void setDateTo(Calendar dateTo)
    {
        this.dateTo = dateTo;
    }

    public String getStrDateFrom()
    {
        return strDateFrom;
    }

    public void setStrDateFrom(String strDateFrom)
    {
        this.strDateFrom = strDateFrom;
    }

    public String getStrDateTo()
    {
        return strDateTo;
    }

    public void setStrDateTo(String strDateTo)
    {
        this.strDateTo = strDateTo;
    }

}
