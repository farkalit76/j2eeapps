/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.webreading.chapter3.fibc;

import fibCHR.RabbitCounterService;
import java.util.ArrayList;
import java.util.List;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

/**
 *
 * @author fusman
 */
public class FibClientHR {

    public static void main(String[] args)
    {
        RabbitCounterService service = new RabbitCounterService();
        service.setHandlerResolver(new ClientHandlerResolver());
        fibCHR.RabbitCounter port = service.getRabbitCounterPort();
        try
        {
            int n = 10;
            int countRabbits = port.countRabbits(n);
            System.out.printf("fib(%d) = %d\n",  n, countRabbits);
            
            n = -27; // It will be converted to +27 by ArgHandler
            countRabbits = port.countRabbits(n);
            System.out.printf("fib(%d) = %d\n",  n, countRabbits);
        } catch (Exception e)
        {
            System.err.println(e);
        }
    }
}

class ClientHandlerResolver implements  HandlerResolver {

    @Override
    public List<Handler>  getHandlerChain(PortInfo port_info)
    {
        List<Handler> hchain = new ArrayList<>();
        hchain.add(new UUIDHandler());
        hchain.add(new ArgHandler());
        //hchain.add(new TestHandler()); // for illustration only
        return hchain;
    }
}
