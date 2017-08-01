/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.util;

import java.util.Random;
import java.util.UUID;

/**
 *
 * @author 72010995
 */
public class IDGenerator
{

    /**
     * Generate a number between 0 to 10000.
     *
     * @return
     */
    public static int getRandomNum()
    {
        //double random = Math.random() * 9999;
        Random rand = new Random();
        return rand.nextInt(9999);
    }

    /**
     * Generate a unique value of timestamp in millisecond.
     *
     * @return
     */
    public static long getTimeId()
    {
        return System.currentTimeMillis();
    }

    /**
     * Generate a string unique value of 36 character long.
     *
     * @return
     */
    public static String getUUID()
    {
        return UUID.randomUUID().toString();
    }
}
