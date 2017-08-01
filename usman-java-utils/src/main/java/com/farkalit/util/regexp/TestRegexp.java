/*
 * Copyright (c) Vertex Business Services.
 * All rights reserved.
 * 
 * No parts of this source code can be reproduced without written consent from
 * Vertex Business Services.
 */

package com.farkalit.util.regexp;

/**
 *
 * @author 72010995
 */
public class TestRegexp
{
    final static String pattern = "\\d{1,8}";
    
    public static void main(String[] args)
    {
         checkAccount("1234");
    }
    
    public static void checkAccount(String accountId)
    {
        System.out.println("Result:"+ accountId.matches(pattern));
    }
}
