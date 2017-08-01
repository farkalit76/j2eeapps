/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.tutorial.generics;

/**
 * Generic Classes
 * A generic class declaration looks like a non-generic class declaration, except that the class 
 * name is followed by a type parameter section.

 * As with generic methods, the type parameter section of a generic class can have one or more 
 * type parameters separated by commas. These classes are known as parameterized classes or 
 * parameterized types because they accept one or more parameters.
 * 
 * @author fusman
 * @param <T>
 */
public class Box<T> {

    private T t;

    public T getT()
    {
        return t;
    }

    public void setT(T t)
    {
        this.t = t;
    }

    public static void main(String[] args)
    {
        Box<Integer> integerBox = new Box<>();
        Box<String> stringBox = new Box<>();

        integerBox.setT(new Integer(10));
        stringBox.setT(new String("Hello World"));

        System.out.printf("Integer Value :%d\n\n", integerBox.getT());
        System.out.printf("String Value :%s\n", stringBox.getT());
    }
}
