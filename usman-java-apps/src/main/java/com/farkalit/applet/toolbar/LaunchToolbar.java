/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.applet.toolbar;

/**
 *
 * @author 72010995
 */
public class LaunchToolbar {

    ToolbarSettings setting = new ToolbarSettings();

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //ToolbarSettings.createAndShowGUI();
                ToolbarButtons.createAndShowGUI();
                
            }
        });
    }
}
