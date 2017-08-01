/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.springhib.model;

import java.util.Calendar;

/**
 *
 * @author 72010995
 */
public class Admin
{

    private long moduleId;
    private String createdBy;
    private Calendar createdDate;

    public Admin()
    {
        createdBy = "usman";
        createdDate = Calendar.getInstance();
    }
    public long getModuleId()
    {
        return moduleId;
    }

    public void setModuleId(long moduleId)
    {
        this.moduleId = moduleId;
    }

    public String getCreatedBy()
    {
        return createdBy;
    }

    public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
    }

    public Calendar getCreatedDate()
    {
        return createdDate;
    }

    public void setCreatedDate(Calendar createdDate)
    {
        this.createdDate = createdDate;
    }

    @Override
    public String toString()
    {
        return "Admin{" + "moduleId=" + moduleId + ", createdBy=" + createdBy + ", createdDate=" + createdDate.getTimeInMillis() + '}';
    }

}
