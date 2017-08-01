package com.farkalit.email;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*
 * Copyright (c) Vertex Business Services.
 * All rights reserved.
 * 
 * No parts of this source code can be reproduced without written consent from
 * Vertex Business Services.
 */
/**
 *
 * @author 72010995
 */
public class PropertyFileReader
{

    static String result = "";
    static InputStream inputStream;

    public static Properties prop = new Properties();
    public static String propFileName = "mailing-info.properties";

    public static Properties getProps()
    {
        try
        {
            inputStream = PropertyFileReader.class.getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null)
            {
                prop.load(inputStream);
            }
            else
            {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
        }
        catch (Exception e)
        {
            System.out.println("Exception: " + e);
        }
        finally
        {
            try
            {
                inputStream.close();
            }
            catch (IOException ex)
            {
                System.out.println("Input Stream Exception: " + ex);
            }
        }
        return prop;
    }

    public String getPropValues() throws IOException
    {
        try
        {
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null)
            {
                prop.load(inputStream);
            }
            else
            {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            // get the property value and print it out
            String fromemail = prop.getProperty("from-email");
            String toemail = prop.getProperty("to-email");

            result = "Company List = " + fromemail + ", " + toemail;
            System.out.println(result);
        }
        catch (Exception e)
        {
            System.out.println("Exception: " + e);
        }
        finally
        {
            inputStream.close();
        }
        return result;
    }

    public static void main(String[] args) throws IOException
    {
        PropertyFileReader propReader = new PropertyFileReader();
        propReader.getPropValues();
    }
}
