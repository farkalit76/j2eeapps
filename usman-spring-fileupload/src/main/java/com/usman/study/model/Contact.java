/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.study.model;

/**
 *
 * @author 72010995
 */
public class Contact
{
    private String name;
    private int moblie;
    private String resident;

    public Contact(String name, int moblie, String resident)
    {
        this.name = name;
        this.moblie = moblie;
        this.resident = resident;
    }

    
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getMoblie()
    {
        return moblie;
    }

    public void setMoblie(int moblie)
    {
        this.moblie = moblie;
    }

    public String getResident()
    {
        return resident;
    }

    public void setResident(String resident)
    {
        this.resident = resident;
    }
    
    
    
}
