/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.webreading.chapter1.ts;

//import com.sun.xml.internal.ws.api.server.SDDocument.WSDL;
//import static java.lang.System.in;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 *
 * @author fusman
 */
public class TimeClient {

    public static void main(String args[]) throws Exception
    {
        URL url = new URL("http://localhost:8030/ts?wsdl");
        // Qualified name of the service:
        // 1st arg is the service URI
        // 2nd is the service name published in the WSDL 
        QName qname = new QName("http://ts.chapter1.webreading.farkalit.com/", "TimeServerImplService");
        // Create, in effect, a factory for theservice.
        Service service = Service.create(url, qname);
        // Extract the endpoint interface, the service "port".
        TimeServer eif  = service.getPort(TimeServer.class);
        System.out.println(eif.getTimeAsString());
        System.out.println(eif.getTimeAsElapsed());
    }

}
