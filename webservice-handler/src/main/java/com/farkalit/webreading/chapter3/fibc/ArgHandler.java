/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.webreading.chapter3.fibc;

import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.ws.LogicalMessage;
import javax.xml.ws.handler.LogicalHandler;
import javax.xml.ws.handler.LogicalMessageContext;
import javax.xml.ws.handler.MessageContext;

/**
 *
 * @author fusman
 */
public class ArgHandler implements LogicalHandler<LogicalMessageContext> {

    private static final String LoggerName = "ArgLogger";
    private Logger logger;
    private final boolean log_p = true; // set    to false to turn off

    public ArgHandler()
    {
        logger = Logger.getLogger(LoggerName);
    }
    // If outgoing message argument is negative,  make non  -negative.

    @Override
    public boolean handleMessage(LogicalMessageContext ctx)
    {
        System.out.println("ArgHandler.handleMessage.started");
        Boolean outbound_p = (Boolean) ctx.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        System.out.println("ArgHandler.handleMessage.outbound_p:" + outbound_p);
        if (outbound_p)
        {
            if (log_p)
            {
                //logger.info("ArgHandler.handleMessage");
                System.out.println("ArgHandler.handleMessage");
            }
            LogicalMessage msg = ctx.getMessage();
            try
            {
                JAXBContext jaxb_ctx = JAXBContext.newInstance("fibCHR");
                Object payload = msg.getPayload(jaxb_ctx);
                if (payload instanceof JAXBElement)
                {
                    Object obj = ((JAXBElement) payload).getValue();
                    System.out.println("ArgHandler.handleMessage.obj:" + obj.toString());
                    if (obj instanceof fibCHR.CountRabbits)
                    {
                        System.out.println("CountRabbits.obj:" + obj.toString());
                        fibCHR.CountRabbits obj_cr = (fibCHR.CountRabbits) obj;
                        int n = obj_cr.getNum();
                        System.out.println("ArgHandler.handleMessage.counter:" + n);
                        // current value
                        if (n < 0)
                        {
                            System.out.println("ArgHandler.handleMessage..convert to non negative...");
                            // negative argument?
                            obj_cr.setNum(Math.abs(n));
                            // make non-negative
                            // Update the message.
                            ((JAXBElement) payload).setValue(obj_cr);
                            msg.setPayload(payload, jaxb_ctx);
                        }
                    } else if (obj instanceof fibCHR.CountRabbitsResponse)
                    {
                        System.out.println("CountRabbitsResponse.obj:" + obj.toString());
                    }
                }
            } catch (JAXBException e)
            {
                System.out.println("ArgHandler.handleMessage.error:" + e);
            }
        }
        System.out.println("ArgHandler.handleMessage.finished");
        return true;
    }

    @Override
    public boolean handleFault(LogicalMessageContext ctx)
    {
        System.out.println("ArgHandler.handleFault");
        return true;
    }

    @Override
    public void close(MessageContext ctx)
    {
        System.out.println("ArgHandler.close");
    }

}
