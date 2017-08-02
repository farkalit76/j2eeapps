/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.webreading.chapter3.calc;

/**
 *
 * @author fusman
 */
public class CalcException extends Exception {

    private String details;

    public CalcException(String reason, String details)
    {
        super(reason);
        this.details = details;
    }

    public String getFaultInfo()
    {
        return details;
    }
}
