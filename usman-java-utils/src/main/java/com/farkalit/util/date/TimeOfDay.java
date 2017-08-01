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
public enum TimeOfDay
{

    AFTERNOON,
    EVENING,
    MORNING;

    private static final String DATE_FORMAT = "dd-M-yyyy hh:mm:ss a";

    public static TimeOfDay getTimeOfDay(String zone)
    {
        Calendar calendar = Calendar.getInstance();
        try
        {
            //return getTimeOfDay(TimeZone.getTimeZone(zone));
            DateFormat dfmt = new SimpleDateFormat(DATE_FORMAT);
            dfmt.setTimeZone(TimeZone.getTimeZone(zone));

            SimpleDateFormat formats = new SimpleDateFormat(DATE_FORMAT);
            Date dateTest = formats.parse(dfmt.format(new Date()));
            calendar.setTime(dateTest);
        }
        catch (ParseException ex)
        {
            Logger.getLogger(TimeOfDay.class.getName()).log(Level.SEVERE, null, ex);
        }
        return getTimeOfDay(calendar);
    }

    public static TimeOfDay getTimeOfDay(TimeZone zone)
    {
        return getTimeOfDay(Calendar.getInstance(zone));
    }

    public static TimeOfDay getTimeOfDay(Calendar calendar)
    {
        TimeOfDay currentTime;
        switch (calendar.get(Calendar.HOUR_OF_DAY))
        {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                currentTime = MORNING;
                break;
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
                currentTime = AFTERNOON;
                break;
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            default:
                currentTime = EVENING;
                break;
        }
        return currentTime;
    }
}

