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
public class ConstructorInfo {

    int roll;
    String name;

    ConstructorInfo(int roll, String name) {
        this.roll = roll;
        this.name = name;
    }

    /**
     * Copy or cloning the class value via constructor
     *
     * @param c1
     */
    private ConstructorInfo(ConstructorInfo c1) {
        roll = c1.roll;
        name = c1.name;
    }

    void display() {
        System.out.println(roll + "," + name);
    }

    public static void main(String[] args) {
        ConstructorInfo c1 = new ConstructorInfo(111, "usman");

        ConstructorInfo c2 = new ConstructorInfo(c1);
        if (c1.equals(c2)) {
            System.out.println("Both objects are equal.");
        }
        if (c1 == c2 ) {
            System.out.println("Both objects are == equal.");
        }
        c1.display();
        c2.display();
    }
}
