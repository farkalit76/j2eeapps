/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author 72010995
 */
public class MainGeneric
{

    public static void main(String[] args)
    {
        System.out.println("MainGeneric started....");
        
        testOrderedPair();
        //testBox();
        System.out.println("MainGeneric completed.");
    }

    
    ///Test the OrderedPair<K,V> data////////////
    public static void testOrderedPair(){
        Pair<String, Integer> p1 = new OrderedPair<String, Integer>("Even", 8);
        System.out.println("testOrderedPair Integer--> "+p1.toString());
        Pair<String, String>  p2 = new OrderedPair<String, String>("Hello", "world");
        System.out.println("testOrderedPair String:--> "+p2.toString());
        
        //-------
        OrderedPair<String, Box<Integer>> pBOxInt = new OrderedPair<>("Primes", new Box<Integer>(881));
        System.out.println("testOrderedPair Key-String:--> "+pBOxInt.getKey()+ ",Value-Box Int:"+pBOxInt.getValue().getT());
        
        List<Integer> list = new ArrayList<Integer>();
        list.add(Integer.SIZE);
        list.add(Integer.MAX_VALUE);
        list.add(Integer.MIN_VALUE);
        OrderedPair<String, List<Integer>> pListInt = new OrderedPair<>("ListArray", list);
        System.out.println("testOrderedPair Key-String:--> "+pListInt.getKey());
        Iterator itr = pListInt.getValue().iterator();
        while( itr.hasNext())
        {
            System.out.println("testOrderedPair Values :--> "+itr.next());
        }
    }
    
    ///Test the Box<T> data////////////
    public static void testBox()
    {
        Box<Integer> boxInt = new Box<Integer>();
        boxInt.setT(Integer.SIZE);
        System.out.println("boxInt:" + boxInt.getT());
        
        Box<String> boxStr = new Box<String>();
        boxStr.setT("Box String data");
        System.out.println("boxStr:" + boxStr.getT());
    }
}
