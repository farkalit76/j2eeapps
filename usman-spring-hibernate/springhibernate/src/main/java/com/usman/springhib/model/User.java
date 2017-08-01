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
public class User
{
    private Integer userId;
    private String userName;
    private String createdBy;
    private Calendar createdDate;

    public Integer getUserId()
    {
        return userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
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
        return "User{" + "userId=" + userId + ", userName=" + userName + ", createdBy=" + createdBy + ", createdDate=" + createdDate + '}';
    }
    
    
}
