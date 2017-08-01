/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.farkalit.library.test;

/**
 *
 * @author 72010995
 */
public class LibraryException extends Exception
{
    
    public LibraryException(){
        super();
    }
    
    public LibraryException(String message){
        super(message);
    }
    
    public LibraryException(Throwable exp){
        super(exp);
    }
    
    public LibraryException(String message, Throwable exp){
        super(message, exp);
    }
}
