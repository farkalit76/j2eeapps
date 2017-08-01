/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.farkalit.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author 72010995
 */
public class URLValidator {
 
    public static final String regexp = "^(http(?:s)?\\:\\/\\/[a-zA-Z0-9]+(?:(?:\\.|\\-)[a-zA-Z0-9]+)+(?:\\:\\d+)?(?:\\/[\\w\\-]+)*(?:\\/?|\\/\\w+\\.[a-zA-Z]{2,4}(?:\\?[\\w]+\\=[\\w\\-]+)?)?(?:\\&[\\w]+\\=[\\w\\-]+)*)$";
    public static final String testURls[] ={"http://pavo.orcom.com:8180/nextgen/",
                                            "http://pavo.orcom.com:8180/nextgen",
                                            "http://pavo.orcom.com:8180/",
                                            "http://pavo.orcom.com:8080",
                                            "http://pavo.orcom.com",
                                            "http://pavo.orcom.com/nextgen/",
                                            "http://pavo.orcom.com/nextgen",
                                            "pavo.orcom.com:8080/nextgen",
                                            "pavo.orcom.com:8080",
                                            "pavo.orcom.com"};
    public static void main(String[] args) {
        
        Pattern pat = Pattern.compile(regexp);
        for (String string : testURls) {
             Matcher match = pat.matcher(string);
            System.out.println("MAtch for String ["+string+"] : Result:"+ match.matches());
        }
       
        
    }
}
