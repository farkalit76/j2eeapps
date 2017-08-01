/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.util.date;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author 72010995
 */
public class BusinessTimeTest {
    
    public BusinessTimeTest() {
        System.out.println("CT:"+BusinessTime.COUNTY.getCurrentTime().getTime());
        System.out.println("isOpen:"+BusinessTime.COUNTY.isOpen());
        System.out.println("isWorkingDay:"+BusinessTime.COUNTY.isWorkingDay());
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
     @Test
     public void timeTest() {
     
        boolean open = BusinessTime.COUNTY.isOpen();
        Assert.assertTrue(open);
     }
     
     @Test
     public void dayTest() {
     
        boolean open = BusinessTime.COUNTY.isWorkingDay();
        Assert.assertTrue(open);
     }
     
}
