/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.util.collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author 72010995
 */
public class CollectionTest
{

    public static void main(String[] args)
    {
        testRun();
        StringBuffer buff = new StringBuffer();//synchronized
        StringBuilder build = new StringBuilder(); // not synchronized
    }

    public static void testRun()
    {

        try
        {

            HashSet<String> newset = new HashSet<>();
            newset.add("Learning");
            Iterator iterator = newset.iterator();
            while (iterator.hasNext())
            {
                System.out.println("Value: " + iterator.next() + " ");
            }

            Map<String, String> mapSet = new HashMap<>();
            mapSet.put("one", "ONE");
            Iterator it = mapSet.entrySet().iterator();
            while (it.hasNext())
            {
                Map.Entry pair = (Map.Entry) it.next();
                System.out.println(pair.getKey() + " = " + pair.getValue());
            }
            System.exit(0);
            System.out.println("after exit block.");
        }
        catch (Exception e)
        {
            System.err.println("Error:"+e.getMessage());
        }
        finally{
            System.out.println("Finally block.");
        }
    }
}
