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
public class StringFormatTest
{

    public static void main(String[] args)
    {
        getControlName(null, null);
        getControlName(null, "MainMode");
        getControlName("test", "MainMode");
        getControlName("tesing", null);

    }

    
    public static void getControlName( String experience, String name)
    {

         String controlName;
        // If the specified experience is null or empty
        if (experience == null || experience.isEmpty())
        {
            // Use the raw name with no experience appended
            controlName = name;
        }
        else
        {
            // Append the experience to the name to generate the control name
            controlName = String.format("%s_%s", name, experience);
        }
         System.out.println("controlName:=" + controlName);       
    }
}
