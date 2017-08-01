/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.util;

import java.util.Random;
import java.util.UUID;

/**
 *
 * @author 72010995
 */
public class IdGenerator extends GeneratorHelper
{

    public static void main(String[] args)
    {
        System.out.println("Random Id:" + getRandomNum());
        System.out.println("Gaussian Random Id:" + getGaussRandomNum());
        System.out.println("Secure Random Id:" + getSecureRandomId());
        System.out.println("UUID:" + getUUID());
        System.out.println("Short UUID:" + getShortUUID());
        System.out.println("Time Id:" + getTimeId());
    }

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
     * Generate a number between 0 to 10000.
     *
     * @return
     */
    public static long getGaussRandomNum()
    {
        return (long) (getGaussian(MEAN, VARIANCE) * 1000000000);
    }

    /**
     * Generate a unique value of secure random object.
     *
     * @return
     */
    public static long getSecureRandomId()
    {
        return getSecureRandom().nextInt();
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

    /**
     * Generate a string unique value of 22 character long.
     *
     * @return
     */
    public static String getShortUUID()
    {
        UUID id = UUID.randomUUID();
        return toIDString(id.getMostSignificantBits()) + toIDString(id.getLeastSignificantBits());
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

}
