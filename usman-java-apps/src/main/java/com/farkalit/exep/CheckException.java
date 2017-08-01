/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.exep;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * It is an exception that is typically a user error or a problem that 
 * cannot be foreseen by the programmer. For example, if a file is to be 
 * opened, but the file cannot be found, an exception occurs. 
 * These exceptions cannot simply be ignored at the time of compilation.
 * eg; FileNotFoundException
 *
 * @author 72010995
 */
public class CheckException
{

    public static void main(String[] args)
    {
//         FileReader file = new FileReader("C:\\test\\a.txt");
//        BufferedReader fileInput = new BufferedReader(file);
//         
//        // Print first 3 lines of file "C:\test\a.txt"
//        for (int counter = 0; counter < 3; counter++) 
//            System.out.println(fileInput.readLine());
//         
//        fileInput.close();
        
        
        FileReader file = null;
        try
        {
            file = new FileReader("C:\\test\\a.txt");
        }
        catch (FileNotFoundException ex)
        {
            Logger.getLogger(CheckException.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedReader fileInput = new BufferedReader(file);

        // Print first 3 lines of file "C:\test\a.txt"
        for (int counter = 0; counter < 3; counter++)
        {
            try
            {
                System.out.println(fileInput.readLine());
            }
            catch (IOException ex)
            {
                Logger.getLogger(CheckException.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        try
        {
            fileInput.close();
        }
        catch (IOException ex)
        {
            Logger.getLogger(CheckException.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
