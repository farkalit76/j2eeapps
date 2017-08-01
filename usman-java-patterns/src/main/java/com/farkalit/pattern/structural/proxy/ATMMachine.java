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
public class ATMMachine implements ATMDataToGet
{

    ATMState atmState;
    int cashInMachine = 2000;
   
    public ATMMachine ()
    {
        atmState = new ATMState( true, 2000, 123 );
    }
    
    @Override
    public ATMState getATMData()
    {
        return atmState;
    }

    @Override
    public int getCashInMachine()
    {
        return atmState.getAvailableCash();
    }

}
