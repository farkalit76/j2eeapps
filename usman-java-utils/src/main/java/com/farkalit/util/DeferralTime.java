/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.farkalit.util;

import java.util.Calendar;

/**
 *
 * @author 72010995
 */
public class DeferralTime {
    
    public static void main(String[] args) {
        long duration = 0L;
         Calendar deferralTime = Calendar.getInstance();
         System.out.println("deferralTime:"+deferralTime.getTimeInMillis());
        deferralTime.setTimeInMillis(System.currentTimeMillis() + duration);
        System.out.println("deferralTime after:"+deferralTime.getTimeInMillis());
    }
}
