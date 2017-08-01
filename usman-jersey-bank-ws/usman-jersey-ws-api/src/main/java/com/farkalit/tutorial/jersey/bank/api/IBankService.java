/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.tutorial.jersey.bank.api;

/**
 *
 * @author fusman
 */
public interface IBankService {
    
    public String getBankName();
    
    public String checkBalance();
    
    public String depositAmount(double amount);
    
    public String withdrawAmount(double amount);
}
