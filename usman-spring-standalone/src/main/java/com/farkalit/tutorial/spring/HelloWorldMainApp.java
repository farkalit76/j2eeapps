/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.tutorial.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author fusman
 */
public class HelloWorldMainApp {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        HelloWorld hello = (HelloWorld) context.getBean("helloWorld");
        hello.getMessage();

        /**
         * Test of Singleton beans: Always return the same bean: That is single
         * instance
         */
        System.out.println("Test of Singleton beans: Always return the same bean: That is single instance");
        HelloWorld helloA = (HelloWorld) context.getBean("helloWorldS");
        helloA.setMessage("This is P Usman!");
        helloA.getMessage();

        HelloWorld helloB = (HelloWorld) context.getBean("helloWorldS");
        helloB.getMessage();

        /**
         * Test of Prototype beans: Always return the different bean: That is
         * multiple instance
         */
        System.out.println("Test of Prototype beans: Always return the different bean: That is multiple instance");
        HelloWorld helloP1 = (HelloWorld) context.getBean("helloWorldP");
        helloP1.setMessage("This is Usman!");
        helloP1.getMessage();

        HelloWorld helloP2 = (HelloWorld) context.getBean("helloWorldP");
        helloP2.getMessage();
        
         /**
         * Test of Initialization beans: It initialize and destroy the bean
         * multiple instance
         */
        System.out.println("Test of Initialization beans: It initialize and destroy the bean");
        AbstractApplicationContext  absContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        HelloWorld helloI = (HelloWorld) absContext.getBean("helloWorldI");
        helloI.setMessage("This is Usman!");
        helloI.getMessage();
        absContext.registerShutdownHook();
    }
}
