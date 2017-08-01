/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.tutorial.generics;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fusman
 */
public class GenericMethodTest {

    // generic method printArray
    public static <E> void printArray(E[] inputArray)
    {
        // Display array elements
        for (E element : inputArray)
        {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }

    public static void main(String args[])
    {
        // Create arrays of Integer, Double and Character
        Integer[] intArray =
        {
            1, 2, 3, 4, 5
        };
        Double[] doubleArray =
        {
            1.1, 2.2, 3.3, 4.4
        };
        Character[] charArray =
        {
            'H', 'E', 'L', 'L', 'O'
        };

        String [] strArray ={"This","is","my","string","example"};
        
        System.out.println("Array integerArray contains:");
        printArray(intArray);   // pass an Integer array

        System.out.println("\nArray doubleArray contains:");
        printArray(doubleArray);   // pass a Double array

        System.out.println("\nArray characterArray contains:");
        printArray(charArray);   // pass a Character array
        
        System.out.println("\nArray stringArray contains:");
        printArray(strArray);   // pass a String array
        
        //Pass integer list which extends Number
        List<Integer> nums = new ArrayList<>();
        nums.add(4); nums.add(44); nums.add(444); nums.add(44444); 
        System.out.println("\nList integer List contains:");
        printLists(nums);
        //Pass double list which extends Number
        List<Double> dbl = new ArrayList<>();
        dbl.add(4.0); dbl.add(44.44); dbl.add(444.444); dbl.add(44444.4444);
        System.out.println("\nList double List contains:");
        printLists(dbl);
        
    }
    
    public static void printLists(List<? extends Number> list)
    {
        for (Number list1 : list)
        {
            System.out.print(list1+",");
        }
        System.out.println();
    }
}
