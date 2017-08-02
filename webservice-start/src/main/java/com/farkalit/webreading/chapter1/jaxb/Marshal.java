/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.webreading.chapter1.jaxb;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.JAXBException;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author fusman
 */
public class Marshal {

    private static final String file_name  = "bd_mar.txt";

    public static void main(String[] args)
    {
        new Marshal().run_example();
    }

    private void run_example()
    {
        try
        {
            JAXBContext ctx  = JAXBContext.newInstance(Skier.class);
            Marshaller m   = ctx.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            // Marshal a Skier object: 1st to stdout, 2nd to file 
            System.out.println("Marshal a Skier object: 1st to stdout, 2nd to file");
            Skier skier = createSkier();
            m.marshal(skier, System.out);
            FileOutputStream out = new FileOutputStream(file_name);
            m.marshal(skier, out);
            out.close();
            // Unmarshal as proof of concept
            System.out.println("Unmarshal as proof of concept");
            Unmarshaller u  = ctx.createUnmarshaller();
            Skier bd_clone = (Skier) u.unmarshal(new File(file_name));
            System.out.println();
            m.marshal(bd_clone, System.out);
        } catch (JAXBException e)
        {
            System.err.println(e);
        } catch (IOException e)
        {
            System.err.println(e);
        }
    }

    private Skier createSkier()
    {
        Person bd = new Person("Bjoern Daehlie",  41, "Male");
        List<String> list = new ArrayList<String>();
        list.add("12 Olympic Medals");
        list.add("9 World Championships");
        list.add("Winningest Winter Olympian");
        list.add("Greatest Nordic Skier");
        return new Skier(bd, "Norway", list);
    }
}
