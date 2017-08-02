/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.webreading.chapter3.calc;

import calcC.SimpleCalculatorService;
import calcC.SimpleCalculator;

/**
 *
 * @author fusman
 */
public class SimpleCalculatorClient {

    public static void main(String[] args)
    {
        SimpleCalculatorService service = new SimpleCalculatorService();
        SimpleCalculator port = service.getSimpleCalculatorPort();
        try
        {
            System.out.println("Result=" + port.operation("555+100"));
            System.out.println("Result=" + port.operation("555-100"));
            System.out.println("Result=" + port.operation("555*100"));
            System.out.println("Result=" + port.operation("555/100"));
            System.out.println("Result=" + port.operation("555#100"));
        } catch (Exception e)
        {
            System.err.println(e);
        }
    }
}
