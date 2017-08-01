/*
 * Copyright (c) Vertex Business Services.
 * All rights reserved.
 * 
 * No parts of this source code can be reproduced without written consent from
 * Vertex Business Services.
 */
package com.farkalit.generic;

/**
 *
 * @author 72010995
 */
public class GenMain
{

    public static void main(String args[])
    {
        Gen<Integer> iOb = new Gen<Integer>(88);
        Gen2<Integer> iOb2 = new Gen2<Integer>(99);
        Gen2<String> strOb2 = new Gen2<String>("Generics Test");
        System.out.println("iOb2 is instance of Gen2 :" + (iOb2 instanceof Gen2<?>));
        System.out.println("iOb2 is instance of Gen :" + (iOb2 instanceof Gen<?>));
        System.out.println("strOb2 is instance of Gen2 :" + (strOb2 instanceof Gen2<?>));
        System.out.println("strOb2 is instance of Gen :" + (strOb2 instanceof Gen<?>));
        System.out.println("iOb is instance of Gen2 :" + (iOb instanceof Gen2<?>));
        System.out.println("iOb is instance of Gen :" + (iOb instanceof Gen<?>));
    }
}
