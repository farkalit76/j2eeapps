/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.util.string;

/**
 *
 * @author fusman
 */
public class StringEvaluation {
    
     public static void main(String[] args)
    {
        stringTest();
    }
    public static void stringTest()
    {
        String s1 = "Mississippi";
        String s2 = s1;
        s1 = s1.replace('i', '!');
        s1.replace('Q', '?');
        System.out.println(s1+":"+s2);
    }
    
    public String stringImmutable(String name)
    {
        String s1 = "Hello";
        System.out.println("hashCode1:"+s1.hashCode());
        s1+=name;
        System.out.println("hashCode2:"+s1.hashCode());
        return s1;
    }
    
    public String stringMutable(String name)
    {
        StringBuffer s1 = new StringBuffer("Hello");
        System.out.println("hashCode1:"+s1.hashCode());
        s1.append(name);
        System.out.println("hashCode2:"+s1.hashCode());
        return s1.toString();
    }
}
