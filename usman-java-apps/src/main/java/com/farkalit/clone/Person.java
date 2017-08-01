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
public class Person
{
    private Car car;
    private String name;
    
    public Person(Car c, String n){
        this.car=c;
        this.name=n;
    }
    
    public Person(Person clone){
        this.car = new Car(clone.car);
        this.name=clone.name;
    }

    @Override
    public String toString()
    {
        return "This person "+name+", has car :"+car;
    }
    
}
