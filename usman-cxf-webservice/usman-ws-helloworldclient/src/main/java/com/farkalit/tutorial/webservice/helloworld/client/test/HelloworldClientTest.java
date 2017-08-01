/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.tutorial.webservice.helloworld.client.test;

import com.farkalit.tutorial.webservice.helloworld.IHelloWorld;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

/**
 *
 * @author fusman
 */
public class HelloworldClientTest {

    public static void main(String[] args)
    {
        String serviceUrl = "http://localhost:8030/usman-ws-helloworld/helloworldservice";
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(IHelloWorld.class);
        factory.setAddress(serviceUrl);
        IHelloWorld hello = (IHelloWorld) factory.create();
        System.out.println(hello.sayHi("Usman"));

    }
}
