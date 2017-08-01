/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.pattern.creational.factory;

/**
 *
 * @author fusman
 */
public class FactoryTest {
    
    public static void main(String[] args) {
        ComputerFactory factory = new ComputerFactory();
        
        Computer computer = factory.getComputer("PC");
        System.out.println("PComputer config:"+computer.toString());
        Computer computer2 = factory.getComputer("Server");
        System.out.println("Server config:"+computer2.toString());
    }
}
