/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.util.calc;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fusman
 */
public class AccountTest {
    
    public AccountTest()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @Test
    public void defaultAccountCreationTest() {
        Account account = new Account();
        assertEquals(account.getId().length(), 6);
        assertEquals(account.getStatus(), true);//, equalTo(true));
        assertEquals(account.getZone(), Account.Zone.ZONE_1);
        assertEquals(0.0, account.getAmount(), 0.0);
    }
 
    @Test
    public void customAccountCreationTest() {
        Account account = new Account(false, Account.Zone.ZONE_3, 125.95);
        assertEquals(account.getId().length(), 6);
        assertEquals(account.getStatus(), equals(false));
        assertEquals(account.getZone().getName(), Account.Zone.ZONE_3.getName());
        assertEquals(125.95, account.getAmount(), 0.0);
    }
 
    @Test(expected = IllegalArgumentException.class)
    public void negativeBalanceTest() {
        Account account = new Account(false, Account.Zone.ZONE_3, -200);
    }
    
}
