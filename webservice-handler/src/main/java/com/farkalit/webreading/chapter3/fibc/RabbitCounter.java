/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.webreading.chapter3.fibc;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author fusman
 */
@WebService(name = "RabbitCounter", targetNamespace = "http://chapter3.webreading.farkalit.com/fibc")
//@SOAPBinding(style=SOAPBinding.Style.DOCUMENT, use=SOAPBinding.Use.LITERAL, parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)
@HandlerChain(file = "handler-chain.xml")
//@BindingType(value ="http://java.sun.com/xml/ns/jaxws/2003/05/soap/bindings/HTTP/")
public class RabbitCounter {
    // stores previously computed values

    private Map<Integer, Integer> cache = Collections.synchronizedMap(new HashMap<Integer, Integer>());

    @WebMethod
    public int countRabbits(@WebParam(name = "num")int n) throws FibException
    {
        System.out.println("RabbitCounter.countRabbits.n"+n);
        // Throw a fault if n is negative.
        if (n < 0)
        {
            throw new FibException("Negative args not allowed.", n + " < 0");
        }
        // Easy cases.
        if (n < 2)
        {
            return n;
        }
        // Return cached values if present.
        if (cache.containsKey(n))
        {
            return cache.get(n);
        }
        if (cache.containsKey(n - 1) && cache.containsKey(n - 2))
        {
            cache.put(n, cache.get(n - 1) + cache.get(n - 2));
            return cache.get(n);
        }
        // Otherwise, compute from scratch, cache, and return.
        int fib = 1, prev = 0;
        for (int i = 2; i <= n; i++)
        {
            int temp = fib;
            fib += prev;
            prev = temp;
        }
        cache.put(n, fib); // cache value for later lookup
        
         System.out.println("RabbitCounter.countRabbits.completed...");
        return fib;
    }
}
