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
public class ObjectCloning implements Cloneable {

    int roll;
    String name;

    ObjectCloning(int roll, String name) {
        this.roll = roll;
        this.name = name;
    }

    void display() {
        System.out.println(roll + "," + name);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) {
        try {

            ObjectCloning c1 = new ObjectCloning(111, "usman");

            ObjectCloning c2 = (ObjectCloning) c1.clone();
            if (c1.equals(c2)) {
                System.out.println("Both objects are equal.");
            }
            if (c1 == c2) {
                System.out.println("Both objects are == equal.");
            }
            c1.display();
            c2.display();
        } catch (CloneNotSupportedException e) {
        }
    }

}
