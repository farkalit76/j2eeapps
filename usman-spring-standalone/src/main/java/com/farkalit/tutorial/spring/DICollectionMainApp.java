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
public class DICollectionMainApp {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");


        DICollection coll = (DICollection) context.getBean("diCollection");
        coll.getAddressList();
        coll.getAddressSet();
        coll.getAddressMap();
        coll.getAddressProp();
        coll.getAddList();

    }
}
