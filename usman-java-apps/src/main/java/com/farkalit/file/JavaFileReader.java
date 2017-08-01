/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author 72010995
 */
public class JavaFileReader {

    public static void main(String[] args) {
        getDCWReport();
    }

    public static String getDCWReport() {
        BufferedReader br = null;
        StringBuilder builder = new StringBuilder();
        try {

            try {
                br = new BufferedReader(new FileReader("test.txt"));
            } catch (FileNotFoundException ex) {
                System.err.println("File Not Found Error.");
                ex.printStackTrace();
            }

            String line = br.readLine();

            while (line != null) {
                builder.append(line);
                builder.append(System.lineSeparator());
                line = br.readLine();
            }

            System.out.println("Result Print:\n" + builder.toString());
        } catch (IOException ex) {
            System.err.println("Openeing Exception");
            ex.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ex) {
                    System.err.println("Closing Exception");
                    ex.printStackTrace();
                }
            }
        }
        return builder.toString();
    }
}
