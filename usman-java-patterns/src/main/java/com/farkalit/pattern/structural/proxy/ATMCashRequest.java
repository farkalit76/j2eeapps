/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.pattern.structural.proxy;

/**
 *
 * @author 72010995
 */
public class ATMCashRequest
{
    int pinEntered;
    int cashRequest;
    
    public ATMCashRequest(int pinEntered, int cashRequest)
    {
        this.pinEntered = pinEntered;
        this.cashRequest=cashRequest;
    }

    public int getPinEntered()
    {
        return pinEntered;
    }

    public void setPinEntered(int pinEntered)
    {
        this.pinEntered = pinEntered;
    }

    public int getCashRequest()
    {
        return cashRequest;
    }

    public void setCashRequest(int cashRequest)
    {
        this.cashRequest = cashRequest;
    }
    
    
}
