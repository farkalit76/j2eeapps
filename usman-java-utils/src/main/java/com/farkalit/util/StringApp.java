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
public class StringApp
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
        System.out.println("Hello App on Net beans....");
        //System.out.println(System.getProperty("java.io.tmpdir"));
        //chnageString();
        // randomNumber();
        //checkString();
        //System.out.println("Value:" + Short.valueOf("010099"));
        String consumerId="0362939                 $1,007.17 $1,007.17"; 
        String str = replaceComma(consumerId);
        System.out.println("str replaced:"+str);
    }

    public static String replaceComma(String value)
    {
        //value= value.replaceAll(",", " ");
        return value.replaceAll(",", " ");
    }
    
    
    public static void randomNumber()
    {
        String num = "" + (int) Math.round((double) Math.random() * 9999);
        System.out.println("num:" + num);
    }

    public static void chnageString()
    {

        String s = "ABC";//String value immutible (not chnaged)
        System.out.println(s);
        System.out.println(s.toLowerCase());
        System.out.println(s);
    }

    public static void checkString()
    {

        String skill = "VTX_ADHOC_ACCOUNT_ACTIONS";
        if (skill.contains("ADHOC"))
        {
            System.out.println("ADHOC");
        }
        else
        {
            System.out.println("OTHERS");
        }
    }
    
    
}
