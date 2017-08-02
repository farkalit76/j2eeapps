/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.webreading.chapter1.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.JAXBException;
import com.farkalit.webreading.chapter1.ts.jaxws.GetTimeAsElapsedResponse;

/**
 *
 * @author fusman
 */
public class MarshalGTER {

    private static final String file_name  = "gter.mar";

    public static void main(String[] args)
    {
        new MarshalGTER().run_example();
    }

    private void run_example()
    {
        try
        {
            JAXBContext ctx   = JAXBContext.newInstance(GetTimeAsElapsedResponse.class);
            Marshaller m    = ctx.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            GetTimeAsElapsedResponse tr = new GetTimeAsElapsedResponse();
            tr.setReturn(new java.util.Date().getTime());
            m.marshal(tr, System.out);
        } catch (JAXBException e)
        {
            System.err.println(e);
        }
    }
}
