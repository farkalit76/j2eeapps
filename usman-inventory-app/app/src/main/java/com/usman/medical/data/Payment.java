/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.data;

/**
 *
 * @author 72010995
 */
public class Payment extends Admin
{
    private Long patientId;
    private String feeType;
    private double amount;
    private String department;
    private Long doctorId;
    private String description;

    public Payment()
    {
        this.department="";
        this.doctorId=0l;
        this.description="";
    }
    public Long getPatientId()
    {
        return patientId;
    }

    public void setPatientId(Long patientId)
    {
        this.patientId = patientId;
    }

    public String getFeeType()
    {
        return feeType;
    }

    public void setFeeType(String feeType)
    {
        this.feeType = feeType;
    }

    public double getAmount()
    {
        return amount;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }

    public String getDepartment()
    {
        return department;
    }

    public void setDepartment(String department)
    {
        this.department = department;
    }

    public Long getDoctorId()
    {
        return doctorId;
    }

    public void setDoctorId(Long doctorId)
    {
        this.doctorId = doctorId;
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
        return super.toString() +"Payment{" + "patientId=" + patientId + ", feeType=" + feeType + ", amount=" + amount + ", department=" + department + ", doctorId=" + doctorId + ", description=" + description + '}';
    }
    
}
