/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.data;

/**
 *
 * @author fusman
 */
public class Sale extends Admin{
    
    private long saleId;
    private long prodId;
    private String prodName;
    private long quantity;
    private double amount;
    private long custId;
    private String description;

    public Sale()
    {
        this.custId=0l;
        this.description="";
    }

    public long getSaleId()
    {
        return saleId;
    }

    public void setSaleId(long saleId)
    {
        this.saleId = saleId;
    }

    public long getProdId()
    {
        return prodId;
    }

    public void setProdId(long prodId)
    {
        this.prodId = prodId;
    }

    public String getProdName()
    {
        return prodName;
    }

    public void setProdName(String prodName)
    {
        this.prodName = prodName;
    }

    
    
    public long getQuantity()
    {
        return quantity;
    }

    public void setQuantity(long quantity)
    {
        this.quantity = quantity;
    }

    public double getAmount()
    {
        return amount;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }

    public long getCustId()
    {
        return custId;
    }

    public void setCustId(long custId)
    {
        this.custId = custId;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    @Override
    public String toString()
    {
        return super.toString()+"Sales{" + "saleId=" + saleId + ", prodId=" + prodId + ", quantity=" + quantity + ", amount=" + amount + ", custId=" + custId + ", description=" + description + '}';
    }
   

    
   
}
