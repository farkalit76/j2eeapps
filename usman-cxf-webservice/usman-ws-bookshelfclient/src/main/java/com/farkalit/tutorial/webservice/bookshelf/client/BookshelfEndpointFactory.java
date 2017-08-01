/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.tutorial.webservice.bookshelf.client;

import com.vertexgroup.tutorial.ws.bookshelf.BookshelfEndpoint;
import com.vertexgroup.tutorial.ws.bookshelf.BookshelfService;
import java.net.MalformedURLException;
import java.net.URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author fusman
 */
public class BookshelfEndpointFactory {
    private static final Logger LOG = LoggerFactory.getLogger(BookshelfEndpointFactory.class);

    private static final BookshelfEndpointFactory INSTANCE = new BookshelfEndpointFactory();
    
    private URL url;
   
    private BookshelfService service;
    
    private BookshelfEndpointFactory()
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
        String urlFile = "/usman-ws-bookshelf/svc/ws/BookshelfControl?wsdl";
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
   
    public static BookshelfEndpoint create()
    {
        // Create a new port using the singleton instance
        return INSTANCE.createPort();
    }

   
    private BookshelfEndpoint createPort()
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
            return service.getBookshelfPort();
        }
    }
   
    private void createService()
    {
        synchronized (this)
        {
            // Create a new service object from the WSDL URL
            this.service = new BookshelfService(url);
        }
    }
}
