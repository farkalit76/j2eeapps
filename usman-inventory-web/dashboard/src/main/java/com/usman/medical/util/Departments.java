/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.util;

/**
 *
 * @author 72010995
 */
public enum Departments
{

    GENERAL("ENG", "Engineer"),
    EYE("MBA", "Matser of Business Administration"),
    ENT("DOC", "Doctomer"),
    ORTH("LAW", "Lawyer"),
    HEART("BUS", "Business Man"),
    OTHERS("OTH", "Other");
    
//    GENERAL("GEN", "General Physician"),
//    EYE("EYE", "Eye Consultant"),
//    ENT("ENT", "E.N.T."),
//    ORTH("ORT", "Orthopedic"),
//    HEART("HRT", "Heart Specialist"),
//    OTHERS("OTH", "Other");

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
