/*
 * Copyright (c) Vertex Business Services.
 * All rights reserved.
 * 
 * No parts of this source code can be reproduced without written consent from
 * Vertex Business Services.
 */
package com.farkalit.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author 72010995
 */
public class PhoneValidation
{
    private static final String [] phones = {"(123)456-7890", "123-456-7890", "123456789222066", "(123)-456-7890","sdfasdf","124144", "asd123114","124141sdfsdf", "241 141 24" ,"12414 14" };
    public static void main(String[] args)
    {
//        for (String string : phones)
//        {
//            System.out.println("Phone {"+ string+"}:"+isPhoneNumberValid(string)); 
//        }
        String phones[] = {"121000","12100","121","231 4234","2314234","230423411","23 4234313131","234234313131"};
        for (String phone : phones)
        {
            testNumberWithSpace(phone);
        }
        
    }

    public static void  testNumberWithSpace(String phoneNumebr)
    {
        System.out.print("phoneNumebr:"+phoneNumebr);

       String pattern = "([\\s]*\\d[\\s]*){6,10}";//correct
        //String pattern ="^([\\s]*\\d{6,10})+$";
       // String pattern ="^[\\s[\\d{6,10}]]+$";
        System.out.println(","+phoneNumebr.matches(pattern));
    }
    /** isPhoneNumberValid: Validate phone number using Java reg ex.
     * This method checks if the input string is a valid phone number.
     *
     * @param phoneNumber String. Phone number to validate
     * @return boolean: true if phone number is valid, false otherwise.
     */
    public static boolean isPhoneNumberValid(String phoneNumber)
    {
        boolean isValid = false;
        /* Phone Number formats: (nnn)nnn-nnnn; nnnnnnnnnn; nnn-nnn-nnnn 
         ^\\(? : May start with an option "(" . 
         (\\d{3}): Followed by 3 digits. 
         \\)? : May have an optional ")"  
         [- ]? : May have an optional "-" after the first 3 digits or after optional ) character.  
         (\\d{3}) : Followed by 3 digits.  
         [- ]? : May have another optional "-" after numeric digits. 
         (\\d{4})$ : ends with four digits. 
 
         Examples: Matches following phone numbers: 
         (123)456-7890, 123-456-7890, 1234567890, (123)-456-7890 
 
         */
        //Initialize reg ex for phone number.   
        String expression = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{0,9})$";
        CharSequence inputStr = phoneNumber;
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches())
        {
            isValid = true;
        }
        return isValid;
    }
    
    
}
