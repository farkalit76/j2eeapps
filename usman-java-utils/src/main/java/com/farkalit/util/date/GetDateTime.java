/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.util.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author 72010995
 */
public class GetDateTime
{

     //private final TimeZone timeZone;

     
    public GetDateTime()
    {

    }

//    public GetDateTime(String timeZoneID)
//    {
//        this.timeZone = TimeZone.getTimeZone(timeZoneID);
//    }
    public static void main(String[] args) throws ParseException {
        System.out.println("New Date:"+ GetDateTime.getCallByDate());
    }

   
//    public Calendar getCurrentTime()
//    {
//        return Calendar.getInstance(timeZone);
//    }
//
//    public TimeZone getTimeZone()
//    {
//        return timeZone;
//    }
    
     public static Date getCallByDate() {
        Calendar caln = Calendar.getInstance();
        caln.setTime(new Date()); // Now use today date.
        caln.add(Calendar.DATE, 3); // Adding 3 days
        return caln.getTime();
    }

}
