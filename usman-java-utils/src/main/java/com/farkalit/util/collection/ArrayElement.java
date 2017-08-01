/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.util.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author fusman
 */
public class ArrayElement {

    private static String[] array =
    {
        "aa", "ss", "dd", "ff"
    };

    public static void main(String[] args)
    {
        String[] removeEl = (String[])removeEl(array);
        //String[] removeEl = removeElements(array, "aa");
        for (String remv : removeEl)
        {
            System.out.println("remv:"+remv);
        }
        
        
    }

    public static String[] removeElements(String[] input, String deleteMe)
    {
        List result = new LinkedList();

        for (String item : input)
        {
            if (!deleteMe.equals(item))
            {
                result.add(item);
            }
        }

        return (String[])result.toArray(input);
    }
    
    private static String[] removeEl(String[] array)
    {
        System.out.println("array:" + array.toString());
        int n = array.length;

        List<String> list = new ArrayList<>();

        for (String arg : array)
        {
            list.add(arg);
        }
        list.remove("aa");
        
        return ((String[]) list.toArray(array));

    }
}
