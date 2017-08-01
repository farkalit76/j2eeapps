/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.farkalit.clone;

/**
 *
 * @author 72010995
 */
public class Car
{
    private String color;
    public Car(){}
    public Car(Car clone){
        this.color = clone.color;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }
    
}
