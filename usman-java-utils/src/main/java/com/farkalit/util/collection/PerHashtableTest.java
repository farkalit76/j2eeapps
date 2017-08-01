/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.util.collection;

import java.util.Hashtable;

/**
 *
 * @author fusman
 */
public class PerHashtableTest {
    
    public static void main(String[] args)
    {
        Hashtable<Person, String> person = new Hashtable<>();
        //person.put(new Person(12, null, "address"), "young");//Null pointer Exception
        person.put(new Person(22, "name", "address"), "young");
        person.put(new Person(22, "name", "address"), "youngest");//Override the value if key is same
        System.out.println("person:"+person.get(new Person(22, "name", "address")));
    }
}
