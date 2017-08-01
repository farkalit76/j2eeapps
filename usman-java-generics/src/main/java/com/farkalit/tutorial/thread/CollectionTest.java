/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.tutorial.thread;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author fusman
 */
public class CollectionTest {

    public static void main(String[] args)
    {
        LinkedList<String> linklist = new LinkedList<>();
        linklist.add(0, "Usmans");
        linklist.add(1, "Usman");
        linklist.add(2, "Farkalit");
        linklist.add(3, "Farkalits");
        linklist.add(4, "Jamil");

        for (String val : linklist)
        {
            System.out.println("val:" + val);
        }

        System.out.println("ssss:" + linklist.size());
        Iterator itr = linklist.iterator();
        Iterator<String> desc = linklist.descendingIterator();
        for (Iterator<String> iterator = linklist.descendingIterator(); iterator.hasNext();)
        {
            String next = iterator.next();
            System.out.println("next:" + next);
        }

        ArrayList<String> arraylist = new ArrayList<>();
        arraylist.add(0, "Usmans");
        arraylist.add(1, "Usmans");
        arraylist.add(2, "Farkalit");
        arraylist.add(3, "Farkalits");
        arraylist.add(4, "Jamil");

        for (String val : arraylist)
        {
            System.out.println("valsss:" + val);
        }

        arraylist.size();
        //arraylist.nodesc

        Set<String> set = new HashSet<>();
        set.add(null);
        set.add(null);
        Iterator iter = set.iterator();
        while (iter.hasNext())
        {
            System.out.println("set:"+iter.next());
        }
    }
}
