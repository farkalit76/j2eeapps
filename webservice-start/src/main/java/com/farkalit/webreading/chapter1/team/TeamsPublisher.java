/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.webreading.chapter1.team;

import javax.xml.ws.Endpoint;

/**
 *
 * @author fusman
 */
public class TeamsPublisher {

    public static void main(String[] args)
    {
        int port = 8030;
        String url = "http://localhost:" + port + "/teams";
        System.out.println("Publishing Teamson port " + port);
        Endpoint.publish(url, new Teams());
    }
}
