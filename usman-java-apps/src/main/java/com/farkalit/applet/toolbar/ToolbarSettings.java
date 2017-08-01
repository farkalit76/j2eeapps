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
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author 72010995
 */
public class ToolbarSettings {

    private static JFrame frame = null;

    public static void createAndShowGUI() {
        //Create and set up the window.
        frame = new JFrame("Seeting");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createSettingLayout();

        //Display the window.
        frame.setLocationRelativeTo(null);
        frame.setPreferredSize(new Dimension(400, 300));
        frame.setResizable(true);
        frame.pack();
        frame.setVisible(true);
    }

    public static void createSettingLayout() {

        //Create a GridLayout
        frame.setLayout(new GridLayout(2, 2));

        //Left side Panel
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setPreferredSize(new Dimension(150, 100));
        leftPanel.setBackground(Color.red);
        //leftPanel.setVisible(true);

        String listDate[] = new String[]{"Toolbar Settings", "Display Logs"};
        JList<String> list = new JList<>(listDate);

        list.setSelectionMode(
        ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setSelectedIndex(0);
        
          //Right side Panel
        final JPanel rightPanel = new JPanel(new BorderLayout());
        
        list.addListSelectionListener( new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                 boolean adjust = e.getValueIsAdjusting();
                System.out.println(", Adjusting? " + adjust);
                if (!adjust) {
                    JList list = (JList) e.getSource();
                    int selections[] = list.getSelectedIndices();
                    System.out.println(" Selections size: "+selections.length);
                    Object selectionValues[] = list.getSelectedValues();
                    for (int i = 0, n = selections.length; i < n; i++) {
                        System.out.println(" int count "+i);
                        if (i == 0) {
                            System.out.println(" Selections: It is first one. ");
                        }
                        System.out.println(selections[i] + "/" + selectionValues[i] + " ");
                        if( selections[i] == 0) {
                            //createToolbarPanel(rightPanel);
                            JCheckBox checkBox = new JCheckBox("Type-A");
                            rightPanel.add(checkBox);
                        }else{
                            //createLogPanel(rightPanel);
                            JTextField text = new JTextField();
                            rightPanel.add(text);
                        }
                    }
                }
            }
        });
      
        
        ListSelectionListener listSelectionListener = new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
               // System.out.println("First index: " + listSelectionEvent.getFirstIndex());
               // System.out.println(", Last index: " + listSelectionEvent.getLastIndex());
                boolean adjust = listSelectionEvent.getValueIsAdjusting();
                System.out.println(", Adjusting? " + adjust);
                if (!adjust) {
                    JList list = (JList) listSelectionEvent.getSource();
                    int selections[] = list.getSelectedIndices();
                    System.out.println(" Selections size: "+selections.length);
                    Object selectionValues[] = list.getSelectedValues();
                    for (int i = 0, n = selections.length; i < n; i++) {
                        System.out.println(" int count "+i);
                        if (i == 0) {
                            System.out.println(" Selections: It is first one. ");
                        }
                        System.out.println(selections[i] + "/" + selectionValues[i] + " ");
                        if( selections[i] == 0) {
                            //createToolbarPanel(rightPanel);
                            JCheckBox checkBox = new JCheckBox("Type-A");
                            rightPanel.add(checkBox);
                        }else{
                            //createLogPanel(rightPanel);
                            JTextField text = new JTextField();
                            rightPanel.add(text);
                        }
                    }
                }
            }
        };
        //list.addListSelectionListener(listSelectionListener);

        leftPanel.add(list);

        //Right side Panel
        //Panel rightPanel = new Panel(new BorderLayout());
        //JCheckBox checkBox = new JCheckBox("Type-A");
        //rightPanel.add(checkBox);

        //Set layout in the Frame and display it
        frame.add(leftPanel);
        frame.add(rightPanel);

        Panel closePanel = new Panel(new FlowLayout());
        JButton closeBtn = new JButton("Close");
        closeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        closePanel.add(closeBtn);
        frame.add(closePanel);

    }

    public static void createToolbarPanel(JPanel rightPanel){
        System.out.println(" createToolbarPanel is called. ");
         JCheckBox checkBox = new JCheckBox("Type-A");
         rightPanel.add(checkBox);
    }
    
    public static void createLogPanel(JPanel rightPanel){
        System.out.println(" createLogPanel is called. ");
        JTextField text = new JTextField();
        rightPanel.add(text);
    }
//    public class SharedListSelectionHandler implements ListSelectionListener {
//
//        public void valueChanged(ListSelectionEvent e) {
//            ListSelectionModel lsm = (ListSelectionModel) e.getSource();
//
//            int firstIndex = e.getFirstIndex();
//            int lastIndex = e.getLastIndex();
//            boolean isAdjusting = e.getValueIsAdjusting();
//
//            if (lsm.isSelectionEmpty()) {
//                //output.append(" <none>");
//            } else {
//                // Find out which indexes are selected.
//                int minIndex = lsm.getMinSelectionIndex();
//                int maxIndex = lsm.getMaxSelectionIndex();
//                for (int i = minIndex; i <= maxIndex; i++) {
//                    if (lsm.isSelectedIndex(i)) {
//                        //output.append(" " + i);
//                    }
//                }
//            }
//
//        }
//    }

}
