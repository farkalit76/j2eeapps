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
public class Orders extends Admin{
    
    private String orderId;
    private long prodId;
    private String prodName;
    private long quantity;
    private double amount;
    private long custId;
    private String custName;
    private String description;
    private String dispatched;
    private double unitPrice;

    public Orders()
    {
        this.custId=0l;
        this.description="";
    }

    public String getOrderId()
    {
        return orderId;
    }

    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
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

    public double getUnitPrice()
    {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice)
    {
        this.unitPrice = unitPrice;
    }

    
    public long getCustId()
    {
        return custId;
    }

    public void setCustId(long custId)
    {
        this.custId = custId;
    }

    public String getCustName()
    {
        return custName;
    }

    public void setCustName(String custName)
    {
        this.custName = custName;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDispatched()
    {
        return dispatched;
    }

    public void setDispatched(String dispatched)
    {
        this.dispatched = dispatched;
    }

    @Override
    public String toString()
    {
        return super.toString()+"Order{" + "orderId=" + orderId + ", prodId=" + prodId + ", prodName=" + prodName + ", quantity=" + quantity + ", amount=" + amount + ", custId=" + custId + ", custName=" + custName + ", description=" + description + ", dispatched=" + dispatched + '}';
    }

}
