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
public class BankAccountFacade {

    private int accountNumber;

    private int securityCode;

    WelcomeToBank welcomeToBank;
    AccountNumberCheck accountChecker;
    SecurityCodeCheck codeChecker;
    FundsCheck fundChecker;

    public BankAccountFacade(int acctNum, int secCode)
    {
        this.accountNumber = acctNum;
        this.securityCode = secCode;

        welcomeToBank = new WelcomeToBank();

        accountChecker = new AccountNumberCheck();

        codeChecker = new SecurityCodeCheck();

        fundChecker = new FundsCheck();

    }

    public int getAccountNumber()
    {
        return accountNumber;
    }

    public int getSecurityCode()
    {
        return securityCode;
    }

    public void withdrawCash(double withdrawAmount)
    {
        System.out.println("Your withdrawing amount is:"+withdrawAmount);
        if (authenticateAccount() && fundChecker.haveEnoughMoney(withdrawAmount))
        {
            System.out.println("Transaction Completed: \n");
        } else
        {
            System.out.println("Transaction Failed: \n");
        }
    }

    public void depositCash(double depositAmount)
    {
         System.out.println("Your deposite amount is:"+depositAmount);
        if (authenticateAccount())
        {
            fundChecker.makeDesposit(depositAmount);
            System.out.println("Transaction Completed: \n");
        } else
        {
            System.out.println("Transaction Failed: \n");
        }
    }

    private boolean authenticateAccount()
    {
        if (accountChecker.accountActive(getAccountNumber()) && codeChecker.isCodeCorrect(getSecurityCode()))
        {
            System.out.println("Account is authenticated!");
            return true;
        }else
        {
            System.out.println("Account is NOT authenticated!!!");
            return false;
        }
        
    }
}
