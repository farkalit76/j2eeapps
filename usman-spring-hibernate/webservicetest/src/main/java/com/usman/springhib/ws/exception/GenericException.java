/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.springhib.ws.exception;

import javax.xml.ws.WebFault;

/**
 *
 * @author 72010995
 */
@WebFault(name = "genericException") //Indicates a generic exception that the operation/web service method can throw.
public class GenericException extends Exception
{

    private static final long serialVersionUID = 1L;

    private GenericException()
    {
    }

    public GenericException(String message)
    {
        super(message);
    }

    public GenericException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
