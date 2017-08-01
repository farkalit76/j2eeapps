/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.tutorial.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author fusman
 */
public class MyAspectJMainApp {
    public static void main(String[] args) {
      ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
      
      MyStudent student = (MyStudent) context.getBean("mystudent");
      student.getName();
      student.getAge();
      student.printThrowException();
   }
}
