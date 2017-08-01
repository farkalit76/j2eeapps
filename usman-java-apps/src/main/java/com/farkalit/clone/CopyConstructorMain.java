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
public class CopyConstructorMain
{
    public static void main(String[] args)
    {
        //Person p1 = new Person(new Car(), "usman");
        Person p1 = new Person(new Mitsubishi(), "usman");
        Person p2 = new Person(p1);
        System.out.println(p1.toString());
        System.out.println(p2.toString());
    }
}
