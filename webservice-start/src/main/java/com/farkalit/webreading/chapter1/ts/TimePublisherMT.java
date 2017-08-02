/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.webreading.chapter1.ts;

import javax.xml.ws.Endpoint;

/**
 *
 * @author fusman
 */
public class TimePublisherMT { // MT for multithreaded

    private Endpoint endpoint;

    public static void main(String[] args)
    {
        TimePublisherMT self = new TimePublisherMT();
        self.create_endpoint();
        self.configure_endpoint();
        self.publish();
    }

    private void create_endpoint()
    {
        endpoint = Endpoint.create(new TimeServerImpl());
    }

    private void configure_endpoint()
    {
        endpoint.setExecutor(new MyThreadPool());
    }

    private void publish()
    {
        int port = 8030;
        String url = "http://localhost:" + port + "/ts";
        endpoint.publish(url);
        System.out.println("Publishing TimeServer on port " + port);
    }
}
