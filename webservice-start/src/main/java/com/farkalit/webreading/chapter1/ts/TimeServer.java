/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.webreading.chapter1.ts;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 * The annotation @WebService signals that this is the SEI (Service Endpoint
 * Interface). @WebMethod signals that each method is a service operation.
 * 
 * The @SOAPBinding annotation impacts the under-the-hood construction of the
 * service contract, the WSDL (Web Services Definition Language) document.
 * Style.RPC simplifies the contract and makes deployment easier.
 *
 * @author fusman
 */
@WebService
@SOAPBinding //(style = Style.RPC) // more on this later
public interface TimeServer {

    @WebMethod
    String getTimeAsString();

    @WebMethod
    long getTimeAsElapsed();
}
