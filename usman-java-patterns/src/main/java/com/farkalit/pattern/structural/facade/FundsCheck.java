/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.pattern.structural.facade;

/**
 *
 * @author 72010995
 */
public class FundsCheck
{
    private double cashInAccount = 1000.00;

    public FundsCheck()
    {
        System.out.println("Fund check initiated....");
        System.out.println("Your current amount is: "+this.getCashInAccount());
    }
    public double getCashInAccount()
    {
        return cashInAccount;
    }

    public void decreaseCachInAccount(double cashWithdrawn)
    {
        cashInAccount -= cashWithdrawn;
    }
    
    public void increaseCachInAccount(double cashDeposited)
    {
        cashInAccount += cashDeposited;
    }
    
    public boolean haveEnoughMoney( double cashToWithdrawl)
    {
        if( cashToWithdrawl >  getCashInAccount())
        {
            System.out.println("You dont have enogh money!");
            System.out.println("Current Balance is:"+getCashInAccount());
            return false;
        }else{
            
            decreaseCachInAccount(cashToWithdrawl);
            System.out.println("Withdrawl Completed: Current Balance is:"+getCashInAccount());
            return  true;
        }
        
    }
    
    public void makeDesposit(double cashToDeposit)
    {
        increaseCachInAccount(cashToDeposit);
        System.out.println("Deposit Completed: Current Balance is:"+getCashInAccount());
    }
}
