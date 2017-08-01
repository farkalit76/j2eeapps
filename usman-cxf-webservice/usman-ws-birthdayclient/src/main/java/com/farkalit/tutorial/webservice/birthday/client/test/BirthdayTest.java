/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.tutorial.webservice.birthday.client.test;

import com.farkalit.tutorial.webservice.birthday.api.IBirthdayService;
import com.farkalit.tutorial.ws.birthday.BirthdayService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

/**
 *
 * @author fusman
 */
public class BirthdayTest {
    
    public static void main(String[] args) throws DatatypeConfigurationException
    {
        String serviceUrl = "http://localhost:8030/usman-ws-birthday/svc/ws/BirthdayControl";
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(IBirthdayService.class);
        factory.setAddress(serviceUrl);
        IBirthdayService birthService = (IBirthdayService) factory.create();
        //call the methods
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(getBirthdate());
        XMLGregorianCalendar xmlGDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
        birthService.setBirthday("usman", getBirthdate());

    }
    
     private static Date getBirthdate()
    {
        Date birthdate = null;
        String string_date = "30-May-2008 00:00:00";
        SimpleDateFormat f = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
        try
        {
            birthdate = f.parse(string_date);
            //birthdate = d.get d.getTime();//in millisecond
        } catch (ParseException e)
        {
            e.printStackTrace();
        }
        return birthdate;
    }
}
