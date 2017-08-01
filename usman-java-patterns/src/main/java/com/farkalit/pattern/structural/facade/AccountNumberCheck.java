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
public class AccountNumberCheck
{
    private int accountNumber = 12345678;

    public int getAccountNumber()
    {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber)
    {
        this.accountNumber = accountNumber;
    }
    
    public boolean accountActive(int accountNumToCheck)
    {
        if( accountNumToCheck == accountNumber)
        {
            System.out.println("Account number exists.");
            return true;
        }else{
            System.out.println("Account number does NOT exists.");
            return false;
        }
    }
}
