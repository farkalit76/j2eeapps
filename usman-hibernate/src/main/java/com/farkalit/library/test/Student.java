/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.farkalit.library.test;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author 72010995
 */
public class Student implements Serializable
{
    
    private int id;
    private String firstName;
    private String lastName;
    private String className;
    private Date birthDate;
    private char sex;
    private  String section;
    private Date admissionYear;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getClassName()
    {
        return className;
    }

    public void setClassName(String className)
    {
        this.className = className;
    }

    public Date getBirthDate()
    {
        return birthDate;
    }

    public void setBirthDate(Date birthDate)
    {
        this.birthDate = birthDate;
    }

    public char getSex()
    {
        return sex;
    }

    public void setSex(char sex)
    {
        this.sex = sex;
    }

    public String getSection()
    {
        return section;
    }

    public void setSection(String section)
    {
        this.section = section;
    }

    public Date getAdmissionYear()
    {
        return admissionYear;
    }

    public void setAdmissionYear(Date admissionYear)
    {
        this.admissionYear = admissionYear;
    }

    @Override
    public String toString()
    {
        return "Student{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", className=" + className + ", birthDate=" + birthDate + ", sex=" + sex + ", section=" + section + ", admissionYear=" + admissionYear + '}';
    }
}
