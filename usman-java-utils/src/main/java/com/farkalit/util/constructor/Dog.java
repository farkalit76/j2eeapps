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
public class Dog {
    
    private String name;
    
    public Dog(String name){
        this.name = name;
        System.out.println("Name set.");
    }
    
    public String getName()
    {
        return name;
    }
}

