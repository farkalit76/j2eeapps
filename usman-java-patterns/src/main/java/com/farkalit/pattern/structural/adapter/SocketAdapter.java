/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.pattern.structural.adapter;

/**
 * Now we want to build an adapter that can produce 3 volts, 12 volts and
 * default 120 volts. So first of all we will create an adapter interface with
 * these methods.
 *
 * @author fusman
 */
public interface SocketAdapter {

    public Volt getSixtyVolt();

    public Volt getTwelveVolt();

    public Volt getThreeVolt();
}
