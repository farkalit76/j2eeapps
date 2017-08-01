/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.pattern.structural.adapter;

/**
 *
 * @author fusman
 */
public class Socket {

    public Volt getVolt()
    {
        return new Volt(120);
    }
}
