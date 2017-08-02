/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.webreading.chapter3.fibc;

import java.util.UUID;
import java.util.Set;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPConstants;
import java.io.IOException;

/**
 *
 * @author fusman
 */
public class UUIDHandler implements SOAPHandler<SOAPMessageContext> {

    private static final String LoggerName = "ClientSideLogger";
    private Logger logger;
    private final boolean log_p = true; // set    to false to turn off

    public UUIDHandler()
    {
        logger = Logger.getLogger(LoggerName);
    }

    @Override
    public boolean handleMessage(SOAPMessageContext ctx)
    {
        System.out.println("UUIDHandler.handleMessage.started");
        if (log_p)
        {
            //logger.info("UUIDHandler.handleMessage");
            System.out.println("UUIDHandler.handleMessage");
        }
        // Is this an outbound message, i.e., a  request  ?
        Boolean request_p = (Boolean) ctx.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        System.out.println("UUIDHandler.handleMessage.request_p:"+request_p);
        // Manipulate the SOAP only if it's a request
        if (request_p)
        {
            // Generate a UUID and a timestamp to place in the message header.
            UUID uuid = UUID.randomUUID();
            try
            {
                SOAPMessage msg = ctx.getMessage();
                SOAPEnvelope env = msg.getSOAPPart().getEnvelope();
                SOAPHeader hdr = env.getHeader();
                // Ensure that the SOAP message has a header.
                if (hdr == null)
                {
                    hdr = env.addHeader();
                }
                QName qname = new QName("http://chapter3.webreading.farkalit.com/fibc", "uuid");
                SOAPHeaderElement helem = hdr.addHeaderElement(qname);
                helem.setActor(SOAPConstants.URI_SOAP_ACTOR_NEXT);
                // default
                helem.addTextNode(uuid.toString());
                msg.saveChanges();
                // For tracking, write to standard output.
                msg.writeTo(System.out);
                System.out.println("");
            } catch (SOAPException e)
            {
                System.err.println("UUIDHandler.SOAPException:"+e);
            } catch (IOException e)
            {
                System.err.println("UUIDHandler.IOException:"+e);
            }
        }
         System.out.println("UUIDHandler.handleMessage.finished");
        return true; // continue down the chain
    }

    @Override
    public boolean handleFault(SOAPMessageContext ctx)
    {
        if (log_p)
        {
            //logger.info("handleFault");
            System.out.println("UUIDHandler.handleFault");
        }
        try
        {
            ctx.getMessage().writeTo(System.out);
        } catch (SOAPException e)
        {
            //System.err.println(e);
            System.err.println("UUIDHandler.SOAPException.Fault:"+e);
        } catch (IOException e)
        {
            //System.err.println(e);
            System.err.println("UUIDHandler.SOAPException.Fault:"+e);
        }
        return true;
    }

    @Override
    public Set<QName> getHeaders()
    {
        if (log_p)
        {
            //logger.info("getHeaders");
            System.out.println("UUIDHandler.getHeaders");
        }
        return null;
    }

    @Override
    public void close(MessageContext messageContext)
    {
        if (log_p)
        {
            //logger.info("close");
            System.out.println("UUIDHandler.close");
        }
    }
}
