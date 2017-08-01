/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.data;

import java.util.Calendar;

/**
 *
 * @author fusman
 */
public class OrderSearch {
  
    private long moduleId;
    private String orderId;
    private long prodId;
    private String prodName;
    private long custId;
    private String custName;
    private String description;
    private String dispatched;
    private Calendar fromDate;
    private Calendar toDate;

    public OrderSearch()
    {
        this.custId=0l;
        this.description="";
    }

    public long getModuleId()
    {
        return moduleId;
    }

    public void setModuleId(long moduleId)
    {
        this.moduleId = moduleId;
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

    public Calendar getFromDate()
    {
        return fromDate;
    }

    public void setFromDate(Calendar fromDate)
    {
        this.fromDate = fromDate;
    }

    public Calendar getToDate()
    {
        return toDate;
    }

    public void setToDate(Calendar toDate)
    {
        this.toDate = toDate;
    }

    @Override
    public String toString()
    {
        return "OrderSearch{" + "moduleId=" + moduleId + ", orderId=" + orderId + ", prodId=" + prodId + ", prodName=" + prodName + ", custId=" + custId + ", custName=" + custName + ", description=" + description + ", dispatched=" + dispatched + ", fromDate=" + fromDate + ", toDate=" + toDate + '}';
    }
}
