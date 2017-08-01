/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.util.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author fusman
 */
public class MapUtil {
    
    public static void main(String[] args)
    {
        mapTest();
    }
    
    
    public static void mapTest()
    {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        
        Set<Map.Entry<String, String>> entry = map.entrySet();
        for (Map.Entry<String, String> entrySet : map.entrySet())
        {
            String key = entrySet.getKey();
            String value = entrySet.getValue();
            System.out.println(key+":"+value);
        }
    }
}
