/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.tutorial.jersey.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.representation.Form;
import java.net.URI;
import javax.ws.rs.core.UriBuilder;

/**
 *
 * @author fusman
 */
public class TodoJerseyClientTest {

    private static final String WS_URL = "http://localhost:8030/usman-rest-ws/";

    public static void main(String[] args)
    {
        System.out.println("Test started...");

        String hello = getHello();
        System.out.println("hello:" + hello);
        String todo = getTodo();
        System.out.println("todo:" + todo);
        String todos = getTodos();
        System.out.println("todos:" + todos);
        String count = getTodosCount();
        System.out.println("todos.count:" + count);
        String create = getTodosCreate();
        System.out.println("todos.create:" + create);

    }

    private static String getHello() throws RuntimeException, UniformInterfaceException, ClientHandlerException
    {
        Client client = Client.create();
        WebResource webResource = client.resource(getBaseURI() + "rest/hello");
        ClientResponse response = webResource.accept("text/plain").get(ClientResponse.class);
        if (response.getStatus() != 200)
        {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }
        String output = response.getEntity(String.class);
        return output;
    }

    private static String getTodo() throws RuntimeException, UniformInterfaceException, ClientHandlerException
    {
        Client client = Client.create();
        WebResource webResource = client.resource(getBaseURI() + "rest/todo");
        ClientResponse response = webResource.accept("text/xml").get(ClientResponse.class);
        if (response.getStatus() != 200)
        {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }
        String output = response.getEntity(String.class);
        return output;
    }

    private static String getTodos() throws RuntimeException, UniformInterfaceException, ClientHandlerException
    {
        Client client = Client.create();
        WebResource webResource = client.resource(getBaseURI() + "rest/todos");
        ClientResponse response = webResource.accept("text/xml").get(ClientResponse.class);
        if (response.getStatus() != 200)
        {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }
        String output = response.getEntity(String.class);
        return output;
    }

    private static String getTodosCount() throws RuntimeException, UniformInterfaceException, ClientHandlerException
    {
        Client client = Client.create();
        WebResource webResource = client.resource(getBaseURI() + "rest/todos/count");
        ClientResponse response = webResource.accept("text/plain").get(ClientResponse.class);
        if (response.getStatus() != 200)
        {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }
        String output = response.getEntity(String.class);
        return output;
    }

    private static String getTodosCreate() throws RuntimeException, UniformInterfaceException, ClientHandlerException
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
