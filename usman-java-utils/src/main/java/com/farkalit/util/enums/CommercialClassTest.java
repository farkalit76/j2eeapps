/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.util.enums;

import java.util.ArrayList;

/**
 *
 * @author 72010995
 */
public class CommercialClassTest {
 
    public static void main(String[] args) {
        
        ArrayList<CommercialClass> list = new ArrayList<>();
        for (CommercialClass commCode : CommercialClass.values()) {
            //list.add(comm);
            System.out.println("Code & Description:"+ commCode.getCode() +":"+commCode.getDescription());
        }
    }
}
