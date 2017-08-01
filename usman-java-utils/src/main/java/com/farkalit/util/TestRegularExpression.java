/*
 * Copyright (c) Vertex Business Services.
 * All rights reserved.
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
public class TestRegularExpression
{
   final static Pattern p = Pattern.compile(
           "(@)?(http://)?(https://)?[a-zA-Z_0-9\\-]+(\\.\\w[a-zA-Z_0-9\\-]+)+(/[#&\\n\\-=?\\+\\%/\\.\\w]+)?");  
   final static String[] urlTest ={"","test","test.com","www.google.com","http://www.google.com","https://www.google.com","http://www.google.com/test/","http://pavo.orcom.com:8180/nextgen/"};
   
    public static void main(String[] args)
    {
       TestRegularExpression.testUrl(urlTest);
    }
    
    public static void testUrl(String[] urlTest){
        for (String string : urlTest)
        {
            Matcher match = p.matcher(string);   
            System.out.println("Results:"+match.matches());
        }
         
    }
            
}
