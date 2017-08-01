/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.pattern.structural.proxy;

/**
 *
 * @author 72010995
 */
public class CommandProxyTest
{

    public static void main(String[] args)
    {
        CommandExecutor executor = new CommandExecutorProxy("Usman", "Usman12");
        try
        {
            executor.runCommand("ls -ltr");
            executor.runCommand("C://Farkalit//using-liferay-portal-6.2.pdf");
            
//            executor.runCommand("ls -ltr");
//            executor.runCommand("rm -rf abc.pdf");
//            executor.runCommand("http://www.google.com");
//            executor.runCommand("www.google.com");
        }
        catch (Exception e)
        {
            System.out.println("Exception Message::" + e.getMessage());
        }
    }
}
