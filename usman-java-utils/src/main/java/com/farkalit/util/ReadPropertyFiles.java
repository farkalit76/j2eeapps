/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 72010995
 */
public class ReadPropertyFiles
{

    public static void main(String[] args)
    {
        ReadPropertyFiles file = new ReadPropertyFiles();
        try
        {
            file.getPropValues();
        }
        catch (IOException ex)
        {
            Logger.getLogger(ReadPropertyFiles.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getPropValues() throws IOException
    {

        String result = "";
        Properties prop = new Properties();
        String propFileName = "ecisplus-config.properties";

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

        if (inputStream != null)
        {
            prop.load(inputStream);
        }
        else
        {
            throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
        }

        for (Map.Entry<Object, Object> entry : prop.entrySet())
        {
            String object = (String)entry.getKey();
            String object1 = (String)entry.getValue();
            System.out.println(object +", "+ object1 );
        }
        // get the property value and print it out
        String company = prop.getProperty("A");
        String company1 = prop.getProperty("C");
        String company2 = prop.getProperty("T");
        String company3 = prop.getProperty("E");

        result = "URL List = " + company1 + ", " + company2 + ", " + company3 +", "+company;
        System.out.println(result );
        return result;
    }
}
