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
public class CalcPercentage
{
    private static double AMOUNT = 1500.0;
   // private static double RESULT = 400.0;
    
    public static void main(String[] args)
    {
        double result = result(AMOUNT, 25);
        percentage(AMOUNT, result);
    }

    
    public static double result(double amount, double percentage)
    {
        double result = amount * (percentage / 100 );
        System.out.println("Result Amount: "+result + " Rupees");
        return result;
    }
    
    public static void percentage(double amount, double result)
    {
        double percentage = ( result / amount ) * 100 ;
        System.out.println("Result percentage: "+percentage + " %");
    }
    
}
