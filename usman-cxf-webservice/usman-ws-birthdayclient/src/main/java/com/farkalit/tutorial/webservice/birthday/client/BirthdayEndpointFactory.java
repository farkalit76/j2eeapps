/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.tutorial.webservice.birthday.client;

import com.farkalit.tutorial.ws.birthday.BirthdayEndpoint;
import com.farkalit.tutorial.ws.birthday.BirthdayService;
import java.net.MalformedURLException;
import java.net.URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author fusman
 */
public class BirthdayEndpointFactory {
    
    private static final Logger LOG = LoggerFactory.getLogger(BirthdayEndpointFactory.class);

    private static final BirthdayEndpointFactory INSTANCE = new BirthdayEndpointFactory();
    
    private URL url;
   
    private BirthdayService service;
    
    private BirthdayEndpointFactory()
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
        String urlFile = "/usman-ws-birthday/svc/ws/BirthdayControl?wsdl";
        try
        {
            // Construct the WSDL URL
            this.url = new URL(urlProtocol, urlHost, urlPort, urlFile);
        }
        catch (MalformedURLException e)
        {
            System.err.println("Unable to form {} URL"+ e.getMessage());
        }
    }
   
    public static BirthdayEndpoint create()
    {
        // Create a new port using the singleton instance
        return INSTANCE.createPort();
    }

   
    private BirthdayEndpoint createPort()
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
            return service.getBirthdayPort();
        }
    }
   
    private void createService()
    {
        synchronized (this)
        {
            // Create a new service object from the WSDL URL
            this.service = new BirthdayService(url);
        }
    }
}
