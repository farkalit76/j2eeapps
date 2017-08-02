/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.webreading.chapter3.fibc;

import fibC.RabbitCounterService;
import fibC.RabbitCounter;
/**
 *
 * @author fusman
 */
public class FibClient {

    public static void main(String[] args)
    {
        RabbitCounterService service = new RabbitCounterService();
        RabbitCounter port  = service.getRabbitCounterPort();
        try
        {

            int n = 10;
            System.out.println("fib(" + n + ") =" + port.countRabbits(n));
            n = 145;
            System.out.println("fib(" + n + ") =" + port.countRabbits(n));
            n = -45;
            System.out.println("fib(" + n + ") =" + port.countRabbits(n));
        } catch (Exception e)
        {
            System.err.println(e);
        }
    }
}
