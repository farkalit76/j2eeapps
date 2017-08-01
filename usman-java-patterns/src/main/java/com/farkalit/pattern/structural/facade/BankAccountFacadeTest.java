/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.pattern.structural.facade;

/**
 * Provide a unified interface to a set of interfaces in a subsystem. Facade Pattern 
 * defines a higher-level interface that makes the subsystem easier to use
 * 
 * OR- Facade Pattern is used to help client applications to easily interact with the system.
 * 
 * When you create a simplified interface that performs many other actions behind the scenes.
 * 
 * @author 72010995
 */
public class BankAccountFacadeTest
{
    public static void main(String[] args)
    {
        BankAccountFacade accessingBank = new BankAccountFacade(12345678,1234);
        accessingBank.withdrawCash(55.00);
        accessingBank.withdrawCash(905.00);
        accessingBank.depositCash(255.00);
        accessingBank.withdrawCash(500.00);
    }
}