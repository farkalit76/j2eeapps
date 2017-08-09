/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.data;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 72010995
 */
@XmlRootElement
public class Doctor extends Admin
{
    
    private String name;
    private String degree;
    private String profession;
    private Double experience;
    private String address;
    private Date dateOfBirth;
    private String dob;
    private Character sex;
    private String description;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDegree()
    {
        return degree;
    }

    public void setDegree(String degree)
    {
        this.degree = degree;
    }

    public String getProfession()
    {
        return profession;
    }

    public void setProfession(String profession)
    {
        this.profession = profession;
    }

    public Double getExperience()
    {
        return experience;
    }

    public void setExperience(Double experience)
    {
        this.experience = experience;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDob()
    {
        return dob;
    }

    public void setDob(String dob)
    {
        this.dob = dob;
    }

    public Character getSex()
    {
        return sex;
    }

    public void setSex(Character sex)
    {
        this.sex = sex;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    @Override
    public String toString()
    {
        return super.toString()+"Doctor{" + "name=" + name + ", degree=" + degree + ", profession=" + profession + ", experience=" + experience + ", address=" + address + ", dateOfBirth=" + dateOfBirth + ", dob=" + dob + ", sex=" + sex + ", description=" + description + '}';
    }
    

   
}
