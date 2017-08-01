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
public class ATMProxyTest
{
    
    public static void main(String[] args)
    {
        ATMCashRequest request = new ATMCashRequest(123, 100);
        ATMDataToGet atmProxy = new ATMProxy(request);
        System.out.println("Current ATM State:"+atmProxy.getATMData());
        System.out.println("Cash in ATM Machine:"+atmProxy.getCashInMachine());
    }
}
