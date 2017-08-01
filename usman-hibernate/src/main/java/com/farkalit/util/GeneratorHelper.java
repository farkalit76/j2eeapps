/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 72010995
 */
public class GeneratorHelper
{

    public static final double MEAN = 100.0f;
    
    public static final double VARIANCE = 5.0f;
    
    // array de 64+2 digitos 
    public final static char[] DIGITS66 =
    {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
        '-', '.', '_', '~'
    };

    public static String toIDString(long i)
    {
        char[] buf = new char[32];
        int z = 64; // 1 << 6;
        int cp = 32;
        long b = z - 1;
        do
        {
            buf[--cp] = DIGITS66[(int) (i & b)];
            i >>>= 6;
        }
        while (i != 0);
        return new String(buf, cp, (32 - cp));
    }

    public static SecureRandom getSecureRandom()
    {
        SecureRandom prng = null;
        try
        {
            prng = SecureRandom.getInstance("SHA1PRNG");
        }
        catch (NoSuchAlgorithmException ex)
        {
            Logger.getLogger(IdGenerator.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("ërror" + ex.getMessage());
        }
        return prng;
    }

    public static double getGaussian(double aMean, double aVariance)
    {
        Random fRandom = new Random();
        return aMean + fRandom.nextGaussian() * aVariance;
    }
}
