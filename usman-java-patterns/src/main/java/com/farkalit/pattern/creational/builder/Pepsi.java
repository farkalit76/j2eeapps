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
public class Pepsi extends ColdDrink
{

     @Override
    public String name()
    {
        return "Pepsi";
    }

    @Override
    public float price()
    {
        return 12.0f;
    }
    
}
