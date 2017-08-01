/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.springhib.ws.client;

import java.net.MalformedURLException;
import java.net.URL;
import com.usman.springhib.entity.ws.EntityEndpoint;
import com.usman.springhib.entity.ws.EntityService;

/**
 *
 * @author 72010995
 */
public class EntityEndpointFactory
{

    private URL url;

    private EntityService service;
    private static final EntityEndpointFactory INSTANCE = new EntityEndpointFactory();

    private static final String HTTP = "http";
    private static final String HOST = "localhost";
    private static final int PORT = 8088;
    private static final String WEBSERVICE_NAME = "/webservicetest/EntityService?wsdl";

    private EntityEndpointFactory()
    {
        try
        {
            // Construct the WSDL URL
            this.url = new URL(HTTP, HOST, PORT, WEBSERVICE_NAME);
        }
        catch (MalformedURLException exp)
        {
            System.err.println("Error:" + exp.getMessage());
            exp.printStackTrace();
        }
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Service Creation Methods">
    /**
     * Creates a new {@link EntityEndpoint} instance using the
     * {@link EntityEndpointFactory} singleton.
     *
     * @see #createPort()
     * @since 1.0
     * @return a new {@link ClassifierEndpoint} instance using the
     * {@link ClassifierEndpointFactory} singleton.
     */
    public static EntityEndpoint create()
    {
        // Create a new port using the singleton instance
        return INSTANCE.createPort();
    }

    /**
     * Creates a new {@link EntityEndpoint} using the {@link #service}
     * associated with this {@link EntityEndpointFactory}.
     *
     * @see #createService()
     * @see SessionService#getSessionPort()
     * @since 1.0
     * @return a {@link EntityEndpoint} instance.
     */
    private EntityEndpoint createPort()
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
            return service.getEntityPort();
        }
    }

    /**
     * Creates the {@link #service} instance responsible for creating endpoint
     * instances. <strong>WARNING: </strong> The {@link #service} field will
     * be set to a {@code null} value in the event the service WSDL is not
     * accessible via the {@link #url} associated with this
     * {@link EntityEndpointFactory}.
     *
     * @see EntityService#EntityService(java.net.URL)
     * @since 1.0
     */
    private void createService()
    {
        synchronized (this)
        {
            // Create a new service object from the WSDL URL
            this.service = new EntityService(url);
        }
    }
//</editor-fold>
}
