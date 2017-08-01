/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.pattern.structural.proxy;

/**
 *
 * @author 72010995
 */
public class ImageProxyTest
{
    public static void main(String[] args)
    {
        Image image = new ProxyImage("test_10mb.jpg");
        Image image1 = new ProxyImage("...test_10mb.jpg");

        //image will be loaded from disk
        image.display();
        System.out.println("");

        //image will not be loaded from disk
        image.display();
        image.display();
        image1.display();
        image1.display();
        image1.display();
    }
 
}
