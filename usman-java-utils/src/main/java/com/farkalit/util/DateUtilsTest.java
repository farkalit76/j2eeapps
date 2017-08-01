/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.util;

import java.util.Date;

/**
 *
 * @author 72010995
 */
public class DateUtilsTest
{
    public static void main(String[] args)
    {
       // 10/01/2015 12:00 AM
        //Date date = DateUtils.getDate("2015-10-01 10:10:15", "yyyy-MM-dd hh:mm:ss");
         Date date = DateUtils.getDate("10/01/2015 12:00 AM", "MM/dd/yyyy hh:mm a");
        
        System.out.println("Date:"+ date );
        
        String strDate = DateUtils.formatDate(date, "yyyy-MM-dd hh:mm:ss");
        
        System.out.println("Str Date:"+ strDate );
    }
    
}
