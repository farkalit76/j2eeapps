/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.pattern.structural.proxy;

/**
 *
 * @author 72010995
 */
public class ATMState
{

    private boolean hasCard;
    private int availableCash;
    private int pin;
    
    public ATMState()
    {
        
    }
    
    public ATMState(boolean hasCard,int availableCash,int pin)
    {
        this.hasCard=hasCard;
        this.pin=pin;
        this.availableCash=availableCash;
    }

    public boolean isHasCard()
    {
        return hasCard;
    }

    public void setHasCard(boolean hasCard)
    {
        this.hasCard = hasCard;
    }

    public int getAvailableCash()
    {
        return availableCash;
    }

    public void setAvailableCash(int availableCash)
    {
        this.availableCash = availableCash;
    }

   
    public int getPin()
    {
        return pin;
    }

    public void setPin(int pin)
    {
        this.pin = pin;
    }

    @Override
    public String toString()
    {
        return "ATMState{" + "hasCard=" + hasCard + ", availableCash=" + availableCash + ", pin=xxx" + pin + '}';
    }
        
    
}
