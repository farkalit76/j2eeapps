/*
 * Copyright (c) Vertex Business Services.
 * All rights reserved.
 * 
 * No parts of this source code can be reproduced without written consent from
 * Vertex Business Services.
 */

package com.farkalit.util;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;

/**
 *
 * @author 72010995
 */
public class DesktopPopup
{
    final static String testUrl = "http://pavo.orcom.com:8180/nextgen/telephone/";
    
    
    public static void main(String[] args)
    {
        String value = "NOBLE Trk Grp 4";
        performDesktopBrowse(testUrl, value);
    }
    public static void performDesktopBrowse(String ecisPopupUrl, String value)
    {  

        if (Desktop.isDesktopSupported())
        {
            try
            {
                System.out.println(ecisPopupUrl);
                String temp=URLEncoder.encode(value,"UTF-8");
                
                System.out.println(temp);
                Desktop.getDesktop().browse(new URI(ecisPopupUrl+temp));
//                Desktop.getDesktop().browse(new URI(URLEncoder.encode(ecisPopupUrl,"UTF-8")));
            }
            catch (IOException | URISyntaxException e)
            {
                System.err.println("Given eCIS+ URL is not valid."+e.toString());
            }
        }
        else
        {
            Runtime runtime = Runtime.getRuntime();
            try
            {
                runtime.exec("xdg-open " + ecisPopupUrl);
            }
            catch (IOException e)
            {
                
                        
             }
        }
    }
}
