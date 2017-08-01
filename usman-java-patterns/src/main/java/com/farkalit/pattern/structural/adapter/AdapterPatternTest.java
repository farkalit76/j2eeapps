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
public class AdapterPatternTest {

    public static void main(String[] args)
    {

        testClassAdapter();
        //testObjectAdapter();
    }

//    private static void testObjectAdapter()
//    {
//        SocketAdapter sockAdapter = new SocketObjectAdapterImpl();
//        Volt v3 = getVolt(sockAdapter, 3);
//        Volt v12 = getVolt(sockAdapter, 12);
//        Volt v120 = getVolt(sockAdapter, 120);
//        System.out.println("v3 volts using Object Adapter=" + v3.getVolts());
//        System.out.println("v12 volts using Object Adapter=" + v12.getVolts());
//        System.out.println("v120 volts using Object Adapter=" + v120.getVolts());
//    }
    private static void testClassAdapter()
    {
        SocketAdapter sockAdapter = new SocketAdapterImpl();
        Volt v3 = getVolt(sockAdapter, 3);
        Volt v12 = getVolt(sockAdapter, 12);
        Volt v60 = getVolt(sockAdapter, 60);
        System.out.println("v3 volts using Class Adapter=" + v3.getVolts());
        System.out.println("v12 volts using Class Adapter=" + v12.getVolts());
        System.out.println("v60 volts using Class Adapter=" + v60.getVolts());
    }

    private static Volt getVolt(SocketAdapter sockAdapter, int i)
    {
        switch (i)
        {
            case 3:
                return sockAdapter.getThreeVolt();
            case 12:
                return sockAdapter.getTwelveVolt();
            case 60:
                return sockAdapter.getSixtyVolt();
            default:
                return sockAdapter.getSixtyVolt();
        }
    }
}
