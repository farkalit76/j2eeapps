/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.farkalit.util;


/**
 *
 * @author 72010995
 */
public class TestChildParent
{
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hello App on Net beans....");
        
        TestChildParent t = new TestChildParent();
        Child s = t.prepareTest();
        
         System.out.println("Message:"+s.getMessage()+"::"+s.getSup());
       
    }
    
    public Child prepareTest(){
        
        Child s = new Child();
        s.setMessage("This is child");
        s.setSup("super");
        return s;
    }
}
