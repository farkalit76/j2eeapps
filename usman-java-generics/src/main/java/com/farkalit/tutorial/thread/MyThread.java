/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.tutorial.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fusman
 */
public class MyThread extends Thread {

    @Override
    public void run()
    {
        System.out.println("Run method executed..");

        for (int i = 0; i < 10; i++)
        {
            System.out.println("i=" + i);
            try
            {
                Thread.sleep(1000);
            } catch (InterruptedException ex)
            {
                System.err.println("Error in thread sleep:" + ex.getMessage());
            }

        }
    }

    public static void main(String args[])
    {
        System.out.println("Main method executed..");
        try
        {
            MyThread t1 = new MyThread();
            t1.start();
            t1.run();

        } catch (Exception e)
        {
            System.err.println("Thread error:" + e.getMessage());
        }

        Map<String, String> map = new HashMap<>();
    }

}
