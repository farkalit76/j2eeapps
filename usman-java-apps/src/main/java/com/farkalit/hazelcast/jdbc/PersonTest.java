/*
 * Copyright (c) Vertex Business Services.
 * All rights reserved.
 * 
 * No parts of this source code can be reproduced without written consent from
 * Vertex Business Services.
 */
package com.farkalit.hazelcast.jdbc;

import com.farkalit.spring.jdbc.Customer;
import com.farkalit.spring.jdbc.CustomerDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author 72010995
 */
public class PersonTest
{
     public static void main(String[] args)
    {
        ApplicationContext context= new ClassPathXmlApplicationContext("Person-Module.xml");

        PersonDAO personDAO = (PersonDAO) context.getBean("personDAO");
        long id = (long)(Math.random() * 100);
        Person person = new Person(id, "usman");
        personDAO.insert(person);

        Person p1 = personDAO.findByPersonId(id);
        System.out.println(p1);
    }
    
}
