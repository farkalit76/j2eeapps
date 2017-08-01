/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.util.constructor;

/**
 *
 * @author fusman
 */
public class DogTest {
    
    private static Dog dd;
    public static void play(Dog d)
    {
        dd = new Dog("Tonny");
    }
    public static void main(String[] args)
    {
        Dog d = new Dog("Jakky");
        play(d);
        System.out.println("Name:"+d.getName());
        System.out.println("Name2:"+dd.getName());
    }
}
