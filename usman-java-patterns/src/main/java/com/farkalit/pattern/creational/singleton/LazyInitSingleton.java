/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.pattern.creational.singleton;

/**
 * Singleton pattern restricts the instantiation of a class and ensures that only 
 * one instance of the class exists in the java virtual machine. The singleton 
 * class must provide a global access point to get the instance of the class. 
 * Singleton pattern is used for logging, drivers objects, caching and thread pool.
 * 
 * Lazy initialization method to implement Singleton pattern creates the instance 
 * in the global access method. Here is the sample code for creating Singleton 
 * class with this approach.
 * 
 * @author fusman
 */
public class LazyInitSingleton {
    
    private static LazyInitSingleton instance = null;
    
    //private constructor to avoid client applications to use constructor
    private LazyInitSingleton(){}
    
    public static LazyInitSingleton getInstance()
    {
        if( instance == null)
        {
            instance = new LazyInitSingleton();
        }
        return instance;
    }
}
