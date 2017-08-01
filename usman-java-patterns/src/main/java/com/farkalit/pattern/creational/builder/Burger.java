/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.pattern.creational.builder;

/**
 *
 * @author 72010995
 */
public abstract class Burger implements Item
{

    @Override
    public abstract String name();
   

    @Override
    public Packing packing()
    {
        return new Wrapper();
    }

    @Override
    public abstract float price();
   
    
}
