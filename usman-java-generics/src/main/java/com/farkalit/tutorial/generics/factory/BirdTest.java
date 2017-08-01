/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.tutorial.generics.factory;

/**
 *
 * @author fusman
 * @param <B>
 */
public class BirdTest <B extends Birds>{
    
    private B b;

    public B getB()
    {
        return b;
    }

    public void setB(B b)
    {
        this.b = b;
    }

     public static void main(String[] args)
    {
        BirdTest<Crow> crow = new BirdTest<>();
        BirdTest<Peacock> peack = new BirdTest<>();

        crow.setB(new Crow());
        peack.setB(new Peacock());

        System.out.println("Crow Speaks :\n"+ crow.getB().speak());
        System.out.println("Peacock Speaks :\n"+ peack.getB().speak());

    }
}
