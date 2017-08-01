/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.tutorial.webservice.birthday.api;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author fusman
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "birthday")
@XmlType
public class Birthday {

    @XmlElement(required = true)
    private String myName;
    @XmlElement(required = true)
    private Date myBirthdate;
    @XmlElement(required = false)
    private int dayOfMonth;
    @XmlElement(required = false)
    private String month;

    private static final String MONTHS[] =
    {
        "JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE",
        "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"
    };

    //JAXB required an empty constructor
    public Birthday()
    {
    }

    public Birthday(String name, Date birthDay)
    {
        this.myName = name;
        this.myBirthdate = birthDay;
        Calendar cal = Calendar.getInstance();
        cal.setTime(birthDay);
        this.dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        int mon = cal.get(Calendar.MONTH);
        System.out.println("mon:" + mon);
        this.month = MONTHS[mon];
    }

    public String getMonth()
    {
        System.out.println("month:" + this.month);
        return this.month;
    }

    public int getDayOfMonth()
    {
        return dayOfMonth;
    }

    public String getMyName()
    {
        return myName;
    }

    public Date getMyBirthdate()
    {
        return myBirthdate;
    }

    public void setMyBirthdate(Date myDate)
    {
        this.myBirthdate = myDate;
    }

    @Override
    public String toString()
    {
        return "Birthday{" + "name=" + myName + ", myBirthdate=" + myBirthdate + ", dayOfMonth=" + dayOfMonth + ", month=" + month + '}';
    }

}
