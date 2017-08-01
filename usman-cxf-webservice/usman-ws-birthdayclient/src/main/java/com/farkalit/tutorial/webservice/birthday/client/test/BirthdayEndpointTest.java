/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.tutorial.webservice.birthday.client.test;

import com.farkalit.tutorial.webservice.birthday.client.BirthdayEndpointFactory;
import com.farkalit.tutorial.ws.birthday.Birthday;
import com.farkalit.tutorial.ws.birthday.BirthdayEndpoint;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;

/**
 * With Web Service Security
 * @author fusman
 */
public class BirthdayEndpointTest {

    private static final String WS_URL = "http://localhost:8030/usman-ws-birthday/svc/ws/BirthdayControl?wsdl";
    
    public static void main(String[] args) throws DatatypeConfigurationException, MalformedURLException
    {
        //Get the Birthday endpoint from factory class
        BirthdayEndpoint endpoint = BirthdayEndpointFactory.create();
        /* Set the User and password for WEb Service Security *****************/
         /*******************UserName & Password ******************************/
        Map<String, Object> req_ctx = ((BindingProvider)endpoint).getRequestContext();
        //URL urlFile = new URL(WS_URL);
        req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, WS_URL);

        Map<String, List<String>> headers = new HashMap<String, List<String>>();
        headers.put("Username", Collections.singletonList("usman"));
        headers.put("Password", Collections.singletonList("password"));
        req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
        /**********************************************************************/
        
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(getBirthdate());
        XMLGregorianCalendar xmlGDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
        System.out.println("Message:" + endpoint.setBirthday("ahmad", xmlGDate));
        System.out.println("Birthdate:" + endpoint.getBirthdate("ahmad"));
        Birthday bInfo = endpoint.getBirthdayInfo("ahmad");
        System.out.println("BirthdayInfo:" + bInfo.getDayOfMonth()+", Month:"+bInfo.getMonth());

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



