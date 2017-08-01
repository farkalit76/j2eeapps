/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.pattern.structural.facade;

/**
 *
 * @author 72010995
 */
public class SecurityCodeCheck
{
    
    private int securityCode = 1234;

    public int getSecurityCode()
    {
        return securityCode;
    }

    
    
    public boolean isCodeCorrect(int secCodeToCheck)
    {
        if( secCodeToCheck == securityCode)
        {
            System.out.println("Security code is correct.");
            return true;
        }else{
            System.out.println("Security code is NOT correct.");
            return false;
        }
    }
}
