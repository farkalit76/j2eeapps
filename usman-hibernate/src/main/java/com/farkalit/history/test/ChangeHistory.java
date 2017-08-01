/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.farkalit.history.test;

import java.io.Serializable;

/**
 *
 * @author 72010995
 */
public class ChangeHistory implements Serializable
{
    private int id;
    private String userName;
    private String change_reason;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getChange_reason()
    {
        return change_reason;
    }

    public void setChange_reason(String change_reason)
    {
        this.change_reason = change_reason;
    }

    @Override
    public String toString(){
    
        StringBuffer buff = new StringBuffer("History:[");
        buff.append(id).append("|");
        buff.append(userName).append("|");
        buff.append(change_reason).append("]");
        return buff.toString();
    }

   

   
    
    
}
