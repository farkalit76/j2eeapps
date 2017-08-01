/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 72010995
 */
public class JavaFileTest
{
    
    public static void main(String[] args)
    {
        
        try
        {
            File file = new File("");
            System.out.println("Path"+file.getAbsolutePath());
            FileReader reader = new FileReader("test.txt");
            
        }
        catch (FileNotFoundException ex)
        {
            
            Logger.getLogger(JavaFileTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
