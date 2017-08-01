/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.util.memory;

import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fusman
 */
public class MyClass {
    public static void main(String[] args)
    {
        System.out.println("class Class Object");
        try
        {
            int count = 0;
            //Class c = Class.forName("com.farkalit.util.memory.HeapStackMemory");
            Class c = Class.forName("java.util.List");
            //Method[] m = c.getMethods();
            Method[] m = c.getDeclaredMethods();
            for (Method m1 : m)
            {
                count++;
                System.out.println("Method Name:"+m1);
            }
            System.out.println("Count:"+count);
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(MyClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
