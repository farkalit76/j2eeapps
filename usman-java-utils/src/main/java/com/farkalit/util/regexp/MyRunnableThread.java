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
public class MyRunnableThread implements Runnable{

    public static void main(String[] args)
    {
        MyRunnableThread rth = new MyRunnableThread();
        rth.run();
        //OR
        //(new Thread(rth)).start();
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
