/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.util.memory;

/**
 *
 * @author fusman
 */
public class HeapStackMemory {

    public static void main(String[] args)
    { 
        int i = 1; // Line 2
        Object obj = new Object(); // Line 3
        HeapStackMemory mem = new HeapStackMemory(); // Line 4
        mem.foo(obj); // Line 5
    } 

    private void foo(Object param)
    {
        String str = param.toString(); //// Line 7
        System.out.println(str);
    }
}
