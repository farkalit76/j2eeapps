/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.util.enums;

/**
 *
 * @author 72010995
 */
public final class LuhnCalculator {
    
    //<editor-fold defaultstate="collapsed" desc="Constructors">
    /**
     * A default constructor to prevent external instantiation.
     *
     * @since 1.2.5
     */
    private LuhnCalculator()
    {
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Luhn Algorithm Calculation Methods">
    /**
     * Calculates the check digit of the specified number.
     *
     * @since 1.2.5
     * @param number the {@link String} to calculate the check digit for.
     * @return the check digit to append to the the specified number to make the
     * specified number conform to the Luhn algorithm.
     */
    public static int calculateChecksum(String number)
    {
        // Append a 0 to the end of the specified number
        String paddedNumber = String.format("%s0", number);
        // Check the checksum of the modfied account number
        int checksum = getChecksum(paddedNumber);
        // If the checksum is 0, the check digit is 0 else it is (10 - checksum)
        int checkDigit = (10 - checksum) % 10;
        // Return the calculated check digit
        return checkDigit;
    }

    /**
     * Gets the checksum value of the specified number.
     *
     * @since 1.2.5
     * @param number the {@link String} to checksum.
     * @return the checksum of the specified number.
     */
    public static int getChecksum(String number)
    {
        // Parse the specified string as a base 10 number
        long value = Long.parseLong(number, 10);
        int sum = 0;
        // Get the length of the specified number
        int numberLength = number.length();
        // For each character in the string
        for (int rindex = 0; rindex < numberLength; rindex++)
        {
            // Get the coefficient for the current number
            int coeffecient = 1 + (rindex % 2);
            // Get the right-most digit of the value
            long digit = value % 10;
            // Multiply the digit by the coeffecient
            long addend = coeffecient * digit;
            // If the addend is multiple digits
            if (addend > 9)
            {
                // Use the sum of the digits (equivalent to subtracting 9)
                addend -= 9;
            }
            // Add the addend to the sum
            sum += addend;
            // Drop the least significant digit from the value
            value /= 10;
        }
        // Get the least significant digit as the checksum
        int checksum = sum % 10;
        // Return the checksum
        return checksum;
    }
    //</editor-fold>
}
