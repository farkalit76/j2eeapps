/*
 * Copyright (c) Vertex Business Services.
 * All rights reserved.
 * 
 * No parts of this source code can be reproduced without written consent from
 * Vertex Business Services.
 */
package com.farkalit.util;

/**
 *
 * @author 72010995
 */
public class SortingTest
{
    public static int numbers [] = {1,3,5,3,8,0,5,2323,576};
    public static void main(String[] args)
    {
        sortInt();
    }

    public static void sortInt()
    {
        int temp=0;
    
        for(int i=0; i< numbers.length-1; i++)
        {
            if(numbers[i] > numbers[i+1])
            {
                temp = numbers[i];
            }
        }
        System.out.println("Max number: "+temp);
    }
    
    
}
