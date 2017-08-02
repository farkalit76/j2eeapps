/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.webreading.chapter3.calc;

import java.io.ByteArrayOutputStream;
import java.util.Set;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

/**
 *
 * @author fusman
 */
public class LoggingHandler implements SOAPHandler<SOAPMessageContext> {

    @Override
    public Set<QName> getHeaders()
    {
        System.out.println("getHeaders");
        return null;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context)
    {
        System.out.println("handleMessage");
        logToSystemOut(context,"handleMessage");
        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context)
    {
        System.out.println("handleFault");
        logToSystemOut(context,"handleFault");
        return true;
    }

    @Override
    public void close(MessageContext context)
    {
        System.out.println("close");
    }

    private void logToSystemOut(SOAPMessageContext smc, String type)
    {
        Boolean outboundProperty = (Boolean) smc.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        System.out.println("outboundProperty.booleanValue():"+outboundProperty.booleanValue());
        try
        {
            if (!outboundProperty.booleanValue())
            {
                SOAPMessage message = smc.getMessage();
                System.out.println(type+" Incoming message:");
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                message.writeTo(stream);

                System.out.println(stream.toString());
                System.out.println("=====================================");
            }
        } catch (Exception e)
        {
            System.out.println("Exception in handler: " + e);
        }
    }
}
