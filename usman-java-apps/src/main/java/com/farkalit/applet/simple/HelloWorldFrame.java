/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.applet.simple;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author 72010995
 */
public class HelloWorldFrame extends JFrame {

    public static void main(String args[]) {
        new HelloWorldFrame();
    }

    public HelloWorldFrame() {
        JLabel jlbHelloWorld = new JLabel("Hello World");
        add(jlbHelloWorld);
        this.setSize(100, 100);
        // pack();
        setVisible(true);
    }
}
