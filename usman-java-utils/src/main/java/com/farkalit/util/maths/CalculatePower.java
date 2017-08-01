/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.util.maths;

/**
 *
 * @author 72010995
 */
public class CalculatePower
{
    public static void main(String[] args)
    {
        power(4,5);
    }
    
    private static void power(int base, int power )
    {
        long start = System.currentTimeMillis();
        System.out.println("");
        double result = 0;
         double temp = base;
         System.out.println("temp:"+temp);
        for (int i = 1; i < power; i++)
        {
            result = temp * base;
            temp = result;
            System.out.println("i:"+i+", temp:"+temp+",result (temp*base):"+result);
        }
        System.out.println("Power result:"+result);
        System.out.println("Elapsed Time:"+(System.currentTimeMillis() -start)+" mill seconds");
    }
}
