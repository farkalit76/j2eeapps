/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.webreading.chapter3.calc;

import javax.xml.ws.Endpoint;

/**
 *
 * @author fusman
 */
public class SimpleCalculatorPublish {

    public static void main(String[] args)
    {
        System.out.println("Web service started...");
        // 1st argument is the publication URL
        // 2nd argument is an SIB instance
        Endpoint.publish("http://localhost:8040/calc", new SimpleCalculator());
        System.out.println("Web service completed.");
    }
}
