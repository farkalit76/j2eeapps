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
public class EmployeeDIMainApp {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        EmployeeDISetter empSeter = (EmployeeDISetter) context.getBean("empSetter");
        empSeter.display();

        System.out.println("-------------------------------------------------");
        EmployeeDI objA = (EmployeeDI) context.getBean("employee");
        objA.show();
        System.out.println("-------------------------------------------------------");
        EmployeeDI employObj = (EmployeeDI) context.getBean("employObj");
        employObj.showAll();
    }
}
