/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.oops.inheritence;

/**
 *
 * @author fusman
 */
public class TestOverloading4 {

    public static void main(String[] args) {
        System.out.println("main with String[]");
        TestOverloading4 tt = new TestOverloading4();
        tt.main("test");
        tt.main();
             
    }

    public static void main(String args) {
        System.out.println("main with String "+args);
    }

    public static void main() {
        System.out.println("main without args");
    }
}
