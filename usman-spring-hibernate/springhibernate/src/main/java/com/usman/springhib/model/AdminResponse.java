/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.springhib.model;

/**
 *
 * @author 72010995
 */
public class AdminResponse
{

    private boolean result;
    private int resiltCode;
    private String message;

    public AdminResponse()
    {
//        this.result = true;
//        this.resiltCode = 0;
//        this.message = "";
        this(false, 0, "None");
    }

    public AdminResponse(boolean result)
    {
//        this.result = result;
//        this.resiltCode = 0;
//        this.message = "";
        this(result, 0, "None");
    }

    public AdminResponse(boolean result, int code)
    {
//        this.result = result;
//        this.resiltCode = code;
//        this.message = "";
        this(result, code, "None");
    }

    public AdminResponse(boolean result, int code, String message)
    {
        this.result = result;
        this.resiltCode = code;
        this.message = message;
    }

    public boolean isResult()
    {
        return result;
    }

    public void setResult(boolean result)
    {
        this.result = result;
    }

    public int getResiltCode()
    {
        return resiltCode;
    }

    public void setResiltCode(int resiltCode)
    {
        this.resiltCode = resiltCode;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

}
