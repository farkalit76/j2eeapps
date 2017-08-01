/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.tutorial.webservice.helloworld;

import javax.jws.WebService;

/**
 *
 * @author fusman
 */
@WebService(endpointInterface = "com.farkalit.tutorial.webservice.helloworld.IHelloWorld",  serviceName="helloworldService")
public class HelloWorldImpl implements IHelloWorld {

    @Override
    public String sayHi(String name)
    {
        System.out.println("sayHello is called by " + name);
        return "Hello " + name;
    }

}
