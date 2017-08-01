/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.springhib.util;

/**
 *
 * @author 72010995
 */
public enum Departments
{

    GENERAL("GEN", "General Physician"),
    EYE("EYE", "Eye Consultant"),
    ENT("ENT", "E.N.T."),
    ORTH("ORT", "Orthopedic"),
    HEART("HRT", "Heart Specialist"),
    OTHERS("OTH", "Other");

    private final String key;
    private final String value;

    private Departments(String k, String v)
    {
        key = k;
        value = v;
    }

    public String getKey()
    {
        return key;
    }

    public String getValue()
    {
        return value;
    }
    

}
