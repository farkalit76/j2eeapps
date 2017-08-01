 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.farkalit.applet.toolbar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 *
 * @author 72010995
 */
public class ToolbarButtons {
    
    private static JFrame frame = null;
    
    public static void createAndShowGUI() {
        //Create and set up the window.
        frame = new JFrame("MenuToolbar");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        createMenuToolbar();

        //Display the window. 
        frame.setPreferredSize(new Dimension(400, 100));
        frame.setResizable(true);
        frame.pack();
        frame.setVisible(true);
    }

    public static void createMenuToolbar() {

        //Create a GridLayout
        //frame.setLayout( new GridLayout(1,3));

        JPanel panel = new JPanel(new FlowLayout());
        JButton btnA= new JButton("Btn-A");
        btnA.setSize(new Dimension(50, 50));
        
       
        JButton btnB= new JButton("Btn-B");
        
         JButton btnC= new JButton("Btn-C");
         
        btnC.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                //statusLabel.setText("Ok Button clicked.");
                ToolbarSettings.createAndShowGUI();
            }
        });
        //Set layout in the Frame and display it
        panel.add(btnA);
        panel.add(btnB);
        panel.add(btnC);
        
        frame.add(panel);
      
    }
}
