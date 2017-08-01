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
public class ComputerFactory {

    public static Computer getComputer(String type)
    {
        if ("PC".equalsIgnoreCase(type))
        {
            return new PComputer();
        } else if ("Server".equalsIgnoreCase(type))
        {
            return new Server();
        }

        return null;
    }
}
