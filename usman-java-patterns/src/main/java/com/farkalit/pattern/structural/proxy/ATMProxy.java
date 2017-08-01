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
public class ATMProxy implements ATMDataToGet
{   
    ATMCashRequest atmRequest;
    
    public ATMProxy(ATMCashRequest request)
    {
        this.atmRequest=request;

    }
    @Override
    public ATMState getATMData()
    {
        ATMMachine atmMachine = new ATMMachine();
        if( atmMachine.getATMData().getPin() == atmRequest.getPinEntered())
        {
            return atmMachine.getATMData();
        }else{
            System.out.println("Your pin is not valid.");
            return null;
        }
    }

    @Override
    public int getCashInMachine()
    {
        ATMMachine atmMachine = new ATMMachine();
        if( atmMachine.getATMData().getAvailableCash() >= atmRequest.getCashRequest())
        {
            return atmMachine.getCashInMachine();
        }else{
            System.out.println("Your requested amount is bigger than the available.");
            return 0;
        }
    }
    
}
