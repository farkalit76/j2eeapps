/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.util;

/**
 *
 * @author 72010995
 */
public class DivideAndTest {
    
    public static final double NUMERATOR = 92352352352352309809898789156579.890;
    public static final int DENOMINATOR = 235235235;
    
    public static void main(String[] args) {
        
        long start = System.currentTimeMillis();
        System.out.println("start time:"+start);
        for ( int i=0; i<10000; i++ )
        {
        double answer = divide(NUMERATOR, DENOMINATOR);
        //System.out.println("Divide answer:"+answer);
        double test = test(answer, DENOMINATOR);
        System.out.println(" = Result:"+test);
        }
        long end = System.currentTimeMillis();
        System.out.println("end time:"+end);
        System.out.println("Time elapsed:"+((end- start)/1000)+ " seconds");
    }
    
    public static double divide( double numerator, int deno)
    {
        return numerator/deno;
    }
    
    public static double test( double value, int multiply)
    {
        return value * multiply;
    }
}
