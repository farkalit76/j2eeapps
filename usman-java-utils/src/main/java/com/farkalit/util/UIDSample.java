/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.util;

import java.rmi.server.UID;

/**
 * Finally, here is another method, using a java.rmi.server.UID. 
 * The Serializable identifiers generated by this class are unique on the host 
 * on which they are generated, provided that
 *      the host takes more than one millisecond to reboot
 *      the host's clock is never set to run backwards
 * 
 * In order to construct a UID that is globally unique, simply pair a UID with an InetAddress.
 *
 * @author 72010995
 */
public class UIDSample
{

    /**
     * Build and display some UID objects.
     */
    public static void main(String... arguments)
    {
        for (int idx = 0; idx < 10; ++idx)
        {
            UID userId = new UID();
            System.out.println("User Id: " + userId);
        }
    }
}
