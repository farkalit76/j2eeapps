/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.util.decimal;

import java.text.DecimalFormat;

/**
 *
 * @author 72010995
 */
public class DecimalRemovalTests {
    
    public static void main(String[] args) {
        
        double amounts[]={ 408.34, 343.00,078.08, 3434.80 };
        
        for (double amount : amounts) {
            test(amount);
        }
        
    }

    private static String test(double amount) {
        
        DecimalFormat df = new DecimalFormat("###.00");
        String decimalAmount = df.format(amount);
        String truncatedValue = decimalAmount.replace(".", "");
        
        System.out.println("truncatedValue:"+truncatedValue);
        return truncatedValue;
    }
}
