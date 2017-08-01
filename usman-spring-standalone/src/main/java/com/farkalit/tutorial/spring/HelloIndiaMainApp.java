/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.tutorial.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author fusman
 */
public class HelloIndiaMainApp {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        HelloWorld objA = (HelloWorld) context.getBean("hello");
        objA.getMessage1();
        objA.getMessage2();

        HelloIndia objB = (HelloIndia) context.getBean("helloIndia");
        objB.getMessage1();
        objB.getMessage2();
        objB.getMessage3();
        
        System.out.println("---------------------------------------------------");
        HelloIndia helloTemp = (HelloIndia) context.getBean("helloIndiaT");
        helloTemp.getMessage1();
        helloTemp.getMessage2();
        helloTemp.getMessage3();
    }
}
