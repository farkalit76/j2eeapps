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
public enum SexData
{

    MALE('M', "Male"),
    FEMALE('F', "Female"),
    OTHERS('O', "Other");

    private final Character key;
    private final String value;

    private SexData(Character k, String v)
    {
        key = k;
        value = v;
    }

    public Character getKey()
    {
        return key;
    }

    public String getValue()
    {
        return value;
    }

}
