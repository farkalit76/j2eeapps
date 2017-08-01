/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.tutorial.jersey.ws.bank;

import com.farkalit.tutorial.jersey.bank.api.IBankService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author fusman
 */
@Path("/bank")
public class BankService implements IBankService {

    private static double INIT_AMOUNT = 2000.00;

    //http://localhost:8030/usman-jersey-ws-bank/rest/bank/name
    @GET
    @Path("/name")
    @Produces(MediaType.TEXT_PLAIN)
    public String getBankName()
    {
        return "Welcome to Usman Bank of India.";
    }

    // This method is called if XML is request

    @GET
     @Path("/namexml")
    @Produces(MediaType.TEXT_XML)
    public String getXMLName()
    {
        return "<?xml version=\"1.0\"?>" + "<name> Welcome to Usman Bank of India" + "</name>";
    }

    // This method is called if HTML is request
    @GET
     @Path("/namehtml")
    @Produces(MediaType.TEXT_HTML)
    public String getHTMLName()
    {
        return "<html> " + "<title>" + "Bank Pvt Ltd" + "</title>"
                + "<body><h1>" + "Welcome to Usman Bank of India" + "</body></h1>" + "</html> ";
    }

    @GET
    @Path("/balance")
    @Produces(MediaType.APPLICATION_JSON)
    public String checkBalance()
    {
        System.out.println("Your Current Balance is :" + INIT_AMOUNT);
        return "Your Current Balance is :" + INIT_AMOUNT;
    }

    //http://localhost:8030/usman-jersey-ws-bank/rest/bank/deposit/100
    @GET
    @Path("/deposit/{amount}")
    @Produces(MediaType.APPLICATION_JSON)
    public String depositAmount(@PathParam(value = "amount") double amount)
    {
        System.out.println("Your Deposit Amount is :" + amount);
        INIT_AMOUNT +=  amount;
        return "Your Deposit Amount is :" + INIT_AMOUNT ;
    }

    //http://localhost:8030/usman-jersey-ws-bank/rest/bank/withdraw/50
    @GET
    @Path("/withdraw/{amount}")
    @Produces(MediaType.APPLICATION_JSON)
    public String withdrawAmount(@PathParam(value = "amount") double amount)
    {
        System.out.println("Your Withdrawal  Amount is :" + amount);
        INIT_AMOUNT -= amount;
        return "Your Withdrawal  Amount is :" + INIT_AMOUNT ;
    }

}
