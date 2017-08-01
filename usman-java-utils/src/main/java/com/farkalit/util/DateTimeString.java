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
public class DateTimeString
{

    public static void main(String[] args)
    {
        runResult();
    }

    public static void runResult()
    {
        String dt = "03142016";
        int hr = 10;
        int mm = 33;
        int ss = 10;
        for (int i = 0; i < 163; i++)
        {

            if (ss >= 60)
            {
                ss = 15;
            }
            else
            {
                if ((ss + 27) < 59)
                {
                    ss = ss + 27;
                }
                else
                {
                    ss = ss - 5;
                }
            }
            if ((i % 10) == 0)
            {
                mm++;
            }
            if ((i % 30) == 0)
            {
                hr++;
            }
            System.out.println(dt + "" + hr + "" + mm + "" + ss);
        }
    }
}
