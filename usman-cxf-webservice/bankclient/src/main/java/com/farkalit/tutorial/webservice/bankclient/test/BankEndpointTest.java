/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.tutorial.webservice.bankclient.test;

import com.farkalit.tutorial.webservice.bankclient.BankEndpointFactory;
import com.farkalit.tutorial.ws.bank.BankEndpoint;

/**
 *
 * @author fusman
 */
public class BankEndpointTest {

    public static void main(String[] args)
    {

        BankEndpoint endpoint = BankEndpointFactory.create();
        System.out.println("Balance:" + endpoint.checkBAlance());
        System.out.println("Deposite Balance:" + endpoint.depositAmount(5000));
        System.out.println("Withdraw Balance:" + endpoint.withdrawAmount(3000));
    }
}
