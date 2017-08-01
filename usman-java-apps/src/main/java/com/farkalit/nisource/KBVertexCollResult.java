/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.nisource;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author 72010995
 */
public class KBVertexCollResult {
    
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat fmt = new SimpleDateFormat("MMddyyyyHHmmss");
        String str = fmt.format(date);
        //System.out.println("date:"+str);
      
         for (int i = 0; i < inputs.length; i++) {
            //String input = inputs[i];
            System.out.println(inputs[i] +" "+str +"CZ          RESBS");
        }
    }
    
    //Change/copy all the missing values
     static String [] inputs = {
        "477007001 989923005",
        "499247008 030133008",
        "521903004 825603002"
        };
    
}
