/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.pattern.structural.proxy;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 *
 * @author 72010995
 */
public class CommandExecutorImpl implements CommandExecutor
{

    @Override
    public void runCommand(String cmd) throws Exception
    {
        try
        {
            System.err.println("Executing runCommand....");
            //Some heavy implementation
            //Runtime.getRuntime().exec(cmd);
            pdfReader(cmd);
            //openURL(cmd);
            System.out.println("Command [" + cmd + "] command executed.");
        }
        catch (IOException ex)
        {
            System.err.println("Error while executing the cmd[" + cmd + "]:-" + ex.getMessage());
        }
    }

    private static void pdfReader(String filePath) throws Exception
    {
        if (Desktop.isDesktopSupported())
        {
            try
            {
                System.out.println("Going to open pdf file...");
                File myFile = new File(filePath);
                Desktop.getDesktop().open(myFile);
            }
            catch (IOException ex)
            {
                System.err.println("Error while opening pdf file:" + ex.getMessage());
            }
        }
        else
        {
            System.out.println("NOT supported to open pdf file...");
        }
    }

    private static void openURL(String url) throws Exception
    {

        if (Desktop.isDesktopSupported())
        {
            Desktop desktop = Desktop.getDesktop();
            try
            {
                desktop.browse(new URI(url));
            }
            catch (IOException | URISyntaxException e)
            {
                System.err.println("IOError:" + e.getMessage());
            }
        }
        else
        {
            Runtime runtime = Runtime.getRuntime();
            try
            {
                runtime.exec("xdg-open " + url);
            }
            catch (IOException e)
            {
                System.err.println("IOError xdg-open:" + e.getMessage());
            }
        }
    }
}
