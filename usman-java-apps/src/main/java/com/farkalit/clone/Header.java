/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.farkalit.clone;

/**
 *
 * @author 72010995
 */
public class Header
{
    private String workItemId;
    
    public Header(){}
    
    public Header(Header clone){
        this.workItemId = clone.workItemId;
    }

    public String getWorkItemId()
    {
        return workItemId;
    }

    public void setWorkItemId(String workItemId)
    {
        this.workItemId = workItemId;
    }
    
    
}
