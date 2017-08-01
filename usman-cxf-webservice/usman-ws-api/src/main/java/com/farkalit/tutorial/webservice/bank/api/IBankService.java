/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.tutorial.webservice.bank.api;

/**
 *
 * @author fusman
 */
public interface IBankService {
    
    public double checkBAlance();
    
    public double depositAmount(double amount);
    
    public double withdrawAmount(double amount);
}
