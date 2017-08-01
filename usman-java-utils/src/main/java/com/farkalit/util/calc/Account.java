/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.util.calc;

import java.math.BigDecimal;

/**
 *
 * @author fusman
 */
public class Account {

    private String id = RandomStringUtils.randomAlphanumeric(6);
    private boolean status = true;
    private Zone zone =  Zone.ZONE_1;
    private double amount;

    public Account()
    {
    }

    public Account(boolean status, Zone zone, double amount)
    {
        this.status = status;
        this.zone = zone;
        if (amount < 0)
            throw new IllegalArgumentException("The balance can not be negative");
        this.amount = createBigDecimal(amount);
    }

    public enum Zone {

        ZONE_1("IST"), 
        ZONE_2("GST"),
        ZONE_3("CST");
        
        private String name=null;
        
        private Zone(String name){
            this.name=name;
        }
        
        public String getName()
        {
            return name;
        }
    }

    public static double createBigDecimal(double total)
    {
        return new BigDecimal(total).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ").append(getId())
                .append("\nstatus: ")
                .append(getStatus())
                .append("\nzone: ")
                .append(getZone())
                .append("\namount: ")
                .append(getAmount());
        return sb.toString();
    }

    public String getId()
    {
        return id;
    }

    public boolean getStatus()
    {
        return status;
    }

    public Zone getZone()
    {
        return zone;
    }

    public double getAmount()
    {
        return amount;
    }
}
