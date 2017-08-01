/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.mapping.model;

/**
 *
 * @author 72010995
 */
public class VoterAddress
{
    private Long addId;
    private String addStreet;
    private String addCity;
    private String addState;
    private String addZipCode;

    public VoterAddress()
    {
    }

    public VoterAddress( String addStreet, String addCity, String addState, String addZipCode)
    {
        this.addStreet = addStreet;
        this.addCity = addCity;
        this.addState = addState;
        this.addZipCode = addZipCode;
    }

    
    public Long getAddId()
    {
        return addId;
    }

    public void setAddId(Long addId)
    {
        this.addId = addId;
    }

    public String getAddStreet()
    {
        return addStreet;
    }

    public void setAddStreet(String addStreet)
    {
        this.addStreet = addStreet;
    }

    public String getAddCity()
    {
        return addCity;
    }

    public void setAddCity(String addCity)
    {
        this.addCity = addCity;
    }

    public String getAddState()
    {
        return addState;
    }

    public void setAddState(String addState)
    {
        this.addState = addState;
    }

    public String getAddZipCode()
    {
        return addZipCode;
    }

    public void setAddZipCode(String addZipCode)
    {
        this.addZipCode = addZipCode;
    }

    @Override
    public String toString()
    {
        return "Address{" + "addId=" + addId + ", addStreet=" + addStreet + ", addCity=" + addCity + ", addState=" + addState + ", addZipCode=" + addZipCode + '}';
    }
    
}
