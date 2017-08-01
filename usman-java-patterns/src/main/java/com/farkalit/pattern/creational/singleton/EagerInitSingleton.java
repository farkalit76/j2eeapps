/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.pattern.creational.singleton;

/**
 * In eager initialization, the instance of Singleton Class is created at the 
 * time of class loading, this is the easiest method to create a singleton 
 * class but it has a drawback that instance is created even though client 
 * application might not be using it.
 * 
 * @author fusman
 */
public class EagerInitSingleton {
    
    private static EagerInitSingleton instance = new EagerInitSingleton();
    
    //private constructor to avoid client applications to use constructor
    private EagerInitSingleton(){}
    
    public static EagerInitSingleton getInstance()
    {
        return instance;
    }
}
