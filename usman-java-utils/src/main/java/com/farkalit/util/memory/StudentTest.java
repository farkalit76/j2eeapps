/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.util.memory;

/**
 *
 * @author fusman
 */
public class StudentTest {
    
    public static void main(String[] args)
    {
        Student s1 = new Student();//("usman",12);
        Class c1 = s1.getClass();
        Student s2 = new Student();//("usmani",22);
        Class c2 = s2.getClass(); //Only one class Class object got created....
        System.out.println("c1:"+c1.hashCode());
        System.out.println("c2:"+c2.hashCode());
        System.out.println(c1 == c2);
        System.out.println(s1 == s2);
        
    }
}
