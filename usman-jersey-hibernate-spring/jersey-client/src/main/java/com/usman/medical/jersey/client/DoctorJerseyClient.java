/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.jersey.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.representation.Form;
import com.usman.medical.data.Doctor;
import java.net.URI;
import java.util.List;
import javax.ws.rs.core.UriBuilder;

/**
 *
 * @author fusman
 */
public class DoctorJerseyClient {
    
     private static final String WS_URL = "http://localhost:8030/jersey-web/";

    public static void main(String[] args)
    {
        System.out.println("Test started...");

        String text = getText();
        System.out.println("text:" + text);
        getList();
        getGenericType();
        //String create = getTodosCreate();
        //System.out.println("todos.create:" + create);

    }
    
    public static List<Doctor> getGenericType()
    {
        
        List<Doctor> list = Client.create().resource(getBaseURI()+"rest/doctor/list")
                .get(new GenericType<List<Doctor>>(){});
        for (Doctor doc : list)
        {
            System.out.println("Result:"+doc.toString());
        }
        return list;
    }

    private static String getText() throws RuntimeException, UniformInterfaceException, ClientHandlerException
    {
        Client client = Client.create();
        WebResource webResource = client.resource(getBaseURI() + "rest/doctor/text");
        ClientResponse response = webResource.accept("text/plain").get(ClientResponse.class);
        if (response.getStatus() != 200)
        {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }
        String output = response.getEntity(String.class);
        return output;
    }

  
    private static void getList() throws RuntimeException, UniformInterfaceException, ClientHandlerException
    {
        Client client = Client.create();
        WebResource webResource = client.resource(getBaseURI() + "rest/doctor/list");
        ClientResponse response = webResource.accept("text/xml").get(ClientResponse.class);
        if (response.getStatus() != 200)
        {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }
        
        //response.getEntity(List<String>);
        String output = response.getEntity(String.class);
        System.out.println("doclist:" + output);
    }

        private static String getCreate() throws RuntimeException, UniformInterfaceException, ClientHandlerException
    {
//        Client client = Client.create();
//        WebResource webResource = client.resource(WS_URL + "rest/todos");

        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource webResource = client.resource(UriBuilder.fromUri(getBaseURI()+"rest/todos").build());

        Form form = new Form();
        form.add("id", "5");
        form.add("summary", "Java Book");
        form.add("description", "Java API for version 1.8");

        //ClientResponse response = webResource.path("create").accept(MediaType.APPLICATION_FORM_URLENCODED_TYPE).post(ClientResponse.class, form);
        ClientResponse response = webResource.path("create").accept("text/plain").post(ClientResponse.class, form);
        if (response.getStatus() != 200)
        {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }
        String output = response.getEntity(String.class);
        return output;
    }
    private static URI getBaseURI()
    {
        return UriBuilder.fromUri(WS_URL).build();
    }
}
