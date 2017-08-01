/*
 * Copyright (c) Vertex Business Services.
 * All rights reserved.
 * 
 * No parts of this source code can be reproduced without written consent from
 * Vertex Business Services.
 */

package com.farkalit.util;

import java.util.AbstractSet;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author 72010995
 */
public class SetCollectionTest {
    
    public static final String[] urls = {"A","A","B","Z","A"};
    
    public static void main(String[] args) {
        
        Set<String> setUrl = new HashSet<String>();
        
        for (String string : urls) {
           boolean flag = setUrl.add(string);
            System.out.println("flag:"+flag);
        }
    }
}
