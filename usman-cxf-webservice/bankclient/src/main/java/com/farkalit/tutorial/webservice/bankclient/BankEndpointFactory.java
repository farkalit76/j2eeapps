/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.tutorial.webservice.bankclient;

import com.farkalit.tutorial.ws.bank.BankEndpoint;
import com.farkalit.tutorial.ws.bank.BankService;
import java.net.MalformedURLException;
import java.net.URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author fusman
 */
public class BankEndpointFactory {
    private static final Logger LOG = LoggerFactory.getLogger(BankEndpointFactory.class);

    private static final BankEndpointFactory INSTANCE = new BankEndpointFactory();

    private URL url;

    private BankService service;

    private BankEndpointFactory()
    {
        // Get the WSDL protocol property
        String urlProtocol = "http";
        // Get the WSDL host property
        String urlHost = "localhost";
        // Get the WSDL port property
        String port = "8030";
        // Parse the WSDL property as an integer
        int urlPort = Integer.parseInt(port);
        // Get the WSDL file property
        String urlFile = "/usman-ws-bank/svc/ws/BankControl?wsdl";
        try
        {
            // Construct the WSDL URL
            this.url = new URL(urlProtocol, urlHost, urlPort, urlFile);
            System.out.println("Bank WS URL:" + this.url);
        } catch (MalformedURLException e)
        {
            System.err.println("Unable to form {} URL" + e.getMessage());
        }
    }

    public static BankEndpoint create()
    {
        // Create a new port using the singleton instance
        return INSTANCE.createPort();
    }

    private BankEndpoint createPort()
    {
        synchronized (this)
        {
            // If the service object is null
            if (this.service == null)
            {
                // Create a new service object
                createService();
            }
            // Return a new port from the service
            System.out.println("Bank WS port:" + service.getBankPort());
            return service.getBankPort();
        }
    }

    private void createService()
    {
        synchronized (this)
        {
            // Create a new service object from the WSDL URL
            this.service = new BankService(url);
        }
    }
}
