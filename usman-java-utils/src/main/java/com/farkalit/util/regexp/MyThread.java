/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.util.regexp;

/**
 *
 * @author fusman
 */
public class MyThread extends Thread{
    
    public static void main(String[] args)
    {
        MyThread th = new MyThread();
        th.start();
    }
    
    @Override
    public void run()
    {
        for (int i = 0; i < 10; i++)
        {
            System.out.println("i:"+i);
        }
    }
}
