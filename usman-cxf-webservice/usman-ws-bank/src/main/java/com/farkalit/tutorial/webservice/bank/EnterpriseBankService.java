/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.tutorial.webservice.bank;

import com.farkalit.tutorial.webservice.bank.api.IBankService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author fusman
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@WebService(portName = "BankPort", name = "BankEndpoint", serviceName = "BankService", targetNamespace = "http://tutorial.farkalit.com/ws/bank")
public class EnterpriseBankService implements IBankService{

    private static double INITIAL_AMOUNT = 1000.0;

    @WebMethod
    @Override
    public double checkBAlance()
    {
        return this.INITIAL_AMOUNT;
    }

    @WebMethod
    @Override
    public double depositAmount(@WebParam(name = "amount") double amount)
    {
        this.INITIAL_AMOUNT += amount;
        System.out.println("Your amount :" + amount + " deposited.");
        return INITIAL_AMOUNT;
    }

    @WebMethod
    @Override
    public double withdrawAmount(@WebParam(name = "amount")double amount)
    {
        this.INITIAL_AMOUNT -= amount;
        System.out.println("Your amount :" + amount + " withdrawn.");
        return INITIAL_AMOUNT;
    }

    
}
