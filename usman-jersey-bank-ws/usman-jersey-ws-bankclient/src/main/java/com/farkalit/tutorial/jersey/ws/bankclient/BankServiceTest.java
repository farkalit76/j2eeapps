/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.tutorial.jersey.ws.bankclient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import java.net.URI;
import javax.ws.rs.core.UriBuilder;


/**
 *
 * @author fusman
 */
public class BankServiceTest {

    private static final String WS_URL= "http://localhost:8088/usman-jersey-ws-bank/";
    
    public static void main(String[] args)
    {
        System.out.println("Test started...");

        String name = getBankName();
        System.out.println("name:" + name);
        String balance = getBalance();
        System.out.println("balance:" + balance);
        String deposit = deposit();
        System.out.println("deposit:" + deposit);
        String balance2 = getBalance();
        System.out.println("New balance:" + balance2);
        String withdraw = withdraw();
        System.out.println("withdraw:" + withdraw);
        String balance3 = getBalance();
        System.out.println("New balance:" + balance3);
    }

    private static String getBankName() throws RuntimeException, UniformInterfaceException, ClientHandlerException
    {
        Client client = Client.create();
        WebResource webResource = client.resource(WS_URL+"rest/bank/name");
        ClientResponse response = webResource.accept("text/plain").get(ClientResponse.class);
        if (response.getStatus() != 200)
        {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }
        String output = response.getEntity(String.class);
        return output;
    }
    
    private static String getBalance() throws RuntimeException, UniformInterfaceException, ClientHandlerException
    {
        Client client = Client.create();
        WebResource webResource = client.resource(WS_URL+"rest/bank/balance");
        ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
        if (response.getStatus() != 200)
        {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }
        String output = response.getEntity(String.class);
        return output;
    }

     private static String deposit() throws RuntimeException, UniformInterfaceException, ClientHandlerException
    {
        Client client = Client.create();
        WebResource webResource = client.resource(WS_URL+"rest/bank/deposit/5000");
        ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
        if (response.getStatus() != 200)
        {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }
        String output = response.getEntity(String.class);
        return output;
    }
     
      private static String withdraw() throws RuntimeException, UniformInterfaceException, ClientHandlerException
    {
        Client client = Client.create();
        WebResource webResource = client.resource(WS_URL+"rest/bank/withdraw/500");
        ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
        if (response.getStatus() != 200)
        {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }
        String output = response.getEntity(String.class);
        return output;
    }
//    private static URI getBaseURI()
//    {
//        return UriBuilder.fromUri(WS_URL).build();
//    }
//
//    public static void main(String[] args)
//    {
//        System.out.println("Test started...");
//        ClientConfig config = new ClientConfig();
//
//        Client client = ClientBuilder.newClient(config);
//
//        WebTarget target = client.target(getBaseURI());
//        
//        String response = target.path("bank").path("name").
//                            request().accept(MediaType.TEXT_PLAIN).get(Response.class).toString();
//        System.out.println("response:"+response);
//    }
}
