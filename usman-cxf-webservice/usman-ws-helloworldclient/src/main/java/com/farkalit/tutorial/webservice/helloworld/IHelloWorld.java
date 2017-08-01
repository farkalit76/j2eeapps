/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.tutorial.webservice.helloworld;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author fusman
 */
@WebService
public interface IHelloWorld {
    @WebMethod
    String sayHi(@WebParam(name="name") String name);
}
