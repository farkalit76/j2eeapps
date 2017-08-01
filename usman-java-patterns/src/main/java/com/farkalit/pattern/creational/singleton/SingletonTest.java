/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.pattern.creational.singleton;

/**
 *
 * @author fusman
 */
public class SingletonTest {
    public static void main(String[] args) {
        
        ThreadSafeSingleton singleton = ThreadSafeSingleton.getInstance();
        
        System.out.println("singleton hashcode:"+singleton.hashCode());
        
        ThreadSafeSingleton singleton2 = ThreadSafeSingleton.getInstance();
        if( singleton.equals(singleton2))
        {
            System.out.println("singleton & singleton2 both are equal:");
        }
    }
}
