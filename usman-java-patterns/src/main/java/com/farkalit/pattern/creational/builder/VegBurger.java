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
public class VegBurger extends Burger
{

    @Override
    public String name()
    {
        return "Veg Burger";
    }

    @Override
    public float price()
    {
        return 25.50f;
    }
    
}
