/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.pattern.structural.adapter;

import java.util.Arrays;

/**
 * An Adapter Pattern says that just "converts the interface of a class into 
 * another interface that a client wants".
 * 
 * The Adapter Pattern is also known as Wrapper.
 * 
 * Adapter design pattern is one of the structural design pattern and its used
 * so that two unrelated interfaces can work together. The object that joins
 * these unrelated interface is called an Adapter.
 *
 * One of the great real life example of Adapter design pattern is mobile
 * charger. Mobile battery needs 3 volts to charge but the normal socket
 * produces either 120V (US) or 220V (India). So the mobile charger works as an
 * adapter between mobile charging socket and the wall socket.
 *
 * We will try to implement multi-adapter using adapter design pattern here. So
 * first of all we will have two classes – Volt (to measure volts) and Socket
 * (producing constant volts of 120V).
 *
 * Adapter Design Pattern Example in JDK

 * Some of the adapter design pattern example I could easily find in JDK classes are;

 * java.util.Arrays#asList()
 * java.io.InputStreamReader(InputStream) (returns a Reader)
 * java.io.OutputStreamWriter(OutputStream) (returns a Writer)
 * 
 * @author fusman
 */
public class Volt {

    private int volts;

    public Volt(int v)
    {
        this.volts = v;
    }

    public int getVolts()
    {
        return volts;
    }

    public void setVolts(int volts)
    {
        this.volts = volts;
    }
    
    public void testJDKAdapter()
    {
        String[] names ={"cat", "dog","hen"};
        Arrays.sort(names);
        System.out.println("names:"+names.toString());
        Arrays.asList(names);
    }
}
