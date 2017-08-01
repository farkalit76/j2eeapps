/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.generic.wildcards;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author 72010995
 */
public class NumberList
{

    public static void main(String[] args)
    {
        System.out.println("NumberList started....");
        List<Integer> li = Arrays.asList(1, 2, 3);
        System.out.println("sum = " + sumOfList(li));

        List<Double> ld = Arrays.asList(1.2, 2.3, 3.5);
        System.out.println("sum = " + sumOfList(ld));

        //Unbounded Wildcards
        List<Integer> lii = Arrays.asList(1, 2, 3);
        List<String> lss = Arrays.asList("one", "two", "three");
        printList(lii);
        printList(lss);
        
        List lii2 = Arrays.asList(1,2,3);
        List lss2 = Arrays.asList("one", "two", "three");
        printListObj(lii2);
        printListObj(lss2);

        System.out.println("NumberList completed.");
    }

    //Upper Bounded Wildcards
    public static double sumOfList(List<? extends Number> list)
    {
        double s = 0.0;
        for (Number n : list)
        {
            s += n.doubleValue();
        }
        return s;
    }

    //Unbounded Wildcards
    public static void printList(List<?> list)
    {
        for (Object elem : list)
        {
            System.out.print(elem + " ");
        }
        System.out.println();
    }
    
    //Unbounded Wildcards
    public static void printListObj(List<Object> list)
    {
        for (Object elem : list)
        {
            System.out.print(elem + " ");
        }
        System.out.println();
    }
}
