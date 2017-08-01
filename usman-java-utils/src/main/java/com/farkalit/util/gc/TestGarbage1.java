/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.util.gc;

/**
 *
 * @author fusman
 */
public class TestGarbage1 {

    public void finalize()
    {
        System.out.println("object is garbage collected");
    }

    public static void main(String args[])
    {
        TestGarbage1 s1 = new TestGarbage1();
        TestGarbage1 s2 = new TestGarbage1();
        s1 = null;
        s2 = null;
        System.gc();
    }
}
