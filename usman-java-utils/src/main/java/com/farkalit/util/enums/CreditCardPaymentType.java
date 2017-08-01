/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.util.enums;

import java.util.Calendar;

/**
 *
 * @author 72010995
 */
public enum CreditCardPaymentType {

    /**
     * An American Express credit card payment. American Express account numbers
     * start with a {@code 34} or {@code 37} and are 15 digits long.
     *
     * @since 1.0
     */
    AMERICAN_EXPRESS("3[47]\\d{13}"),
    /**
     * A Discover credit card payment. Discover account numbers start with a
     * {@code 6} and are 16 digits long.
     *
     * @since 1.0
     */
    DISCOVER("6\\d{15}"),
    /**
     * A MasterCard credit card payment. MasterCard account numbers start with a
     * {@code 51}, {@code 52}, {@code 53}, {@code 54} or {@code 55} and are 16
     * digits long.
     *
     * @since 1.0
     */
    MASTERCARD("5[12345]\\d{14}|2\\d{15}"),
    /**
     * A Visa credit card payment. Visa account numbers start with a {@code 4}
     * and are 16 digits long.
     *
     * @since 1.0
     */
    VISA("4\\d{15}");

    //<editor-fold defaultstate="collapsed" desc="Constants">
    /**
     * The maximum value of an expiration month.
     *
     * @since 1.1
     */
    private static final int MAX_MONTH = 12;
    /**
     * The minimum value of an expiration month.
     *
     * @since 1.1
     */
    private static final int MIN_MONTH = 1;
    /**
     * The base year to add to expiration years.
     *
     * @since 1.2
     */
    private static final int Y2K = 2000;
    /**
     * The maximum period (in years) for which a credit card is valid.
     *
     * @since 1.2.6
     */
    private static final int YEAR_CUTOFF = 10;
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Fields">
    /**
     * The regular expression pattern that identifies potential account numbers.
     *
     * @since 1.0
     */
    private final String pattern;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructors">
    /**
     * Creates a new {@link CreditCardPaymentType} with the specified account
     * number regular expression.
     *
     * @since 1.0
     * @param regex the regular expression pattern that identifies potential
     * account numbers.
     */
    private CreditCardPaymentType(String regex)
    {
        this.pattern = regex;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Validation Helper Methods">
    /**
     * Indicates whether or not the specified {@link String} could be a valid
     * account number of this {@link CreditCardPaymentType}.
     *
     * @param number the {@link String} to test.
     * @return {@code true} if the specified {@link String} could be a valid
     * account number of this {@link CreditCardPaymentType}.
     * @since 1.0
     */
    private boolean isValid(String number)
    {
        boolean valid = false;
        // If the specified account number matches the pattern and has a checksum of 0
        if (number.matches(pattern) && LuhnCalculator.getChecksum(number) == 0)
        {
            // Mark the number as valid
            valid = true;
        }
        // Return the validity flag
        return valid;
    }

    /**
     * Gets the {@link CreditCardPaymentType} of the specified {@link String}.
     *
     * @param accountNumber the {@link String} to test.
     * @return the {@link CreditCardPaymentType} of the specified
     * {@link String}.
     * @since 1.0
     */
    public static CreditCardPaymentType getCreditCardPaymentType(String accountNumber)
    {
        CreditCardPaymentType retVal = null;
        // For each potential payment type
        System.out.println("accountNumber:"+accountNumber);
        for (CreditCardPaymentType type : values())
        {
            // If the specified account number is valid for the type
            if (type.isValid(accountNumber))
            {
                // Assign the return value to the current type
                retVal = type;
                // Break out of the loop
                break;
            }
        }
        // Return the matched type
        return retVal;
    }

    /**
     * Gets a {@link Calendar} instance representing the first day of the month
     * after the month in which the credit card expires.
     *
     * @since 2.0
     * @param expirationMonth the expiration month (1-12) of the credit card.
     * @param expirationYear the expiration year (00-99) of the credit card.
     * @return {@code true} if the specified expiration date is in the future,
     * {@code false} otherwise.
     */
    public static Calendar getExpirationDate(int expirationMonth, int expirationYear)
    {
        // Clone the current time calendar
        Calendar expirationDate = Calendar.getInstance();
        // Set the fields for the expiration date to the first day of the expiration month
        expirationDate.set(Calendar.MILLISECOND, 0);
        expirationDate.set(Calendar.SECOND, 0);
        expirationDate.set(Calendar.MINUTE, 0);
        expirationDate.set(Calendar.HOUR, 0);
        expirationDate.set(Calendar.DAY_OF_MONTH, 1);
        expirationDate.set(Calendar.MONTH, expirationMonth - 1);
        expirationDate.set(Calendar.YEAR, Y2K + expirationYear);
        // Set the fields for the expiration date to the first after the expiration month
        expirationDate.add(Calendar.MONTH, 1);
        return expirationDate;
    }

    /**
     * Determines if the current time is before the specified expiration date.
     *
     * @since 1.1
     * @param expirationMonth the expiration month (1-12) to test.
     * @param expirationYear the expiration year (00-99) to test.
     * @return {@code true} if the specified expiration date is in the future,
     * {@code false} otherwise.
     */
    public static boolean isExpirationDateValid(int expirationMonth, int expirationYear)
    {
        boolean valid = false;
        // If the expiration month is between the maximum and minimum values
        if (expirationMonth >= MIN_MONTH && expirationMonth <= MAX_MONTH)
        {
            // Clone the current time calendar
            Calendar expirationDate = getExpirationDate(expirationMonth, expirationYear);
            // Get the current time
            Calendar now = Calendar.getInstance();
            // Clone the current time calendar
            Calendar cutoffDate = (Calendar) now.clone();
            // Set the fields for the cutoff date to the first day of the month 10 years from now
            cutoffDate.set(Calendar.MILLISECOND, 0);
            cutoffDate.set(Calendar.SECOND, 0);
            cutoffDate.set(Calendar.MINUTE, 0);
            cutoffDate.set(Calendar.HOUR, 0);
            cutoffDate.set(Calendar.DAY_OF_MONTH, 1);
            cutoffDate.add(Calendar.MONTH, 1);
            cutoffDate.add(Calendar.YEAR, YEAR_CUTOFF);
            // Determine if the expiration date is between the current date and cutoff date
            valid = expirationDate.after(now) && expirationDate.before(cutoffDate);
        }
        // Return the validity flag
        return valid;
    }
    //</editor-fold>
}
