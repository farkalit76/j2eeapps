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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 72010995
 */
public enum BusinessTime
{

    //COUNTY("US/Eastern", 8, 0, 17, 0);
    COUNTY("US/Eastern", 1, 0, 17, 0);
    private final String timeZoneID;
    private final TimeZone timeZone;
    private final int openHour;
    private final int openMinute;
    private final int closeHour;
    private final int closeMinute;
    private static final String DATE_FORMAT = "dd-MM-yyyy hh:mm:ss a";

    private BusinessTime(String timeZoneID, int openHour, int openMinute, int closeHour, int closeMinute)
    {
        this.timeZoneID = timeZoneID;
        this.timeZone = TimeZone.getTimeZone(timeZoneID);
        this.openHour = openHour;
        this.openMinute = openMinute;
        this.closeHour = closeHour;
        this.closeMinute = closeMinute;
    }

    public boolean isOpen()
    {
        Calendar now = getCurrentTime();
        System.out.println("C1:"+ (openHour < now.get(Calendar.HOUR_OF_DAY)) );
        System.out.println("C2:"+ (now.get(Calendar.HOUR_OF_DAY) < closeHour) );
        System.out.println("C3:"+ (openHour == now.get(Calendar.HOUR_OF_DAY)) );
        System.out.println("C4:"+ (openMinute <= now.get(Calendar.MINUTE)) );
        System.out.println("C5:"+ (closeHour == now.get(Calendar.HOUR_OF_DAY)) );
        System.out.println("C6:"+ (now.get(Calendar.MINUTE) < closeMinute) );
        
        if(!isWorkingDay()) 
        {
            System.out.println("Returning from isWorkingDay");
            return false; 
        }else{
            System.out.println("Returning from else...");
            return (openHour < now.get(Calendar.HOUR_OF_DAY) && now.get(Calendar.HOUR_OF_DAY) < closeHour)
                || (openHour == now.get(Calendar.HOUR_OF_DAY) && openMinute <= now.get(Calendar.MINUTE))
                || (closeHour == now.get(Calendar.HOUR_OF_DAY) && now.get(Calendar.MINUTE) < closeMinute);
        }

    }
    
    public boolean isWorkingDay()
    {
        boolean working;
        Calendar now = getCurrentTime();
        switch(now.get(Calendar.DAY_OF_WEEK))
        {
            case Calendar.SATURDAY:
                working=false;
                break;
            case Calendar.SUNDAY:
                working=false;
                break;
            case Calendar.WEDNESDAY:
                working=false;
                break;
            default :
                working=true;
                break;
        }
        //System.out.println("isWorkingDay:"+working);
        return working;
    }

//     public Calendar getCurrentTime()
//    {
//        return Calendar.getInstance(timeZone);
//    }
    public Calendar getCurrentTime()
    {
        Calendar calendar = Calendar.getInstance();
        try
        {
            DateFormat dfmt = new SimpleDateFormat(DATE_FORMAT);
            dfmt.setTimeZone(TimeZone.getTimeZone(timeZoneID));

            SimpleDateFormat formats = new SimpleDateFormat(DATE_FORMAT);
            Date dateTest = formats.parse(dfmt.format(new Date()));
            calendar.setTime(dateTest);
        }
        catch (ParseException ex)
        {
            Logger.getLogger(BusinessTime.class.getName()).log(Level.SEVERE, null, ex);
        }
        return calendar;
    }
     
    public TimeZone getTimeZone()
    {
        return timeZone;
    }
}

