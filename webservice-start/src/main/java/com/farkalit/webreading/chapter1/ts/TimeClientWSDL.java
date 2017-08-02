/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.webreading.chapter1.ts;

import client.TimeServer;
import client.TimeServerImplService;

/**
 *
 * @author fusman
 */
public class TimeClientWSDL {

    public static void main(String[] args)
    {
        // The TimeServerImplService class is theJava type bound to
        // the service section of the WSDLdocument.
        TimeServerImplService service = new TimeServerImplService();
        // The TimeServer interface is the Java type bound to
        // the portType section of the WSDL document.
        TimeServer eif = service.getTimeServerImplPort();
        // Invoke the methods.
        System.out.println(eif.getTimeAsString());
        System.out.println(eif.getTimeAsElapsed());
    }

}
