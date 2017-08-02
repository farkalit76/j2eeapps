/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.webreading.chapter3.attach;

import javax.xml.ws.Endpoint;

/**
 *
 * @author fusman
 */
public class SkiImageServicePublish {
    public static void main(String[] args)
    {
        // 1st argument is the publication URL
        // 2nd argument is an SIB instance
        Endpoint.publish("http://localhost:8040/attach", new SkiImageService());
        System.out.println("Web service completed.");
    }
}
