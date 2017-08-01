/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.mapping.model;

import java.io.Serializable;

/**
 *
 * @author 72010995
 */
public class Voters implements Serializable
{
    
    private Long votId;
    private String votName;
    private VoterAddress voterAddress;
    
    public Voters()
    {
    }

    public Voters(String votName,VoterAddress voterAddress)
    {
        this.votName = votName;
        this.voterAddress =voterAddress;
    }

    
    public Long getVotId()
    {
        return votId;
    }

    public void setVotId(Long votId)
    {
        this.votId = votId;
    }

    public String getVotName()
    {
        return votName;
    }

    public void setVotName(String votName)
    {
        this.votName = votName;
    }

    public VoterAddress getVoterAddress()
    {
        return voterAddress;
    }

    public void setVoterAddress(VoterAddress voterAddress)
    {
        this.voterAddress = voterAddress;
    }

    @Override
    public String toString()
    {
        return "Voters{" + "votId=" + votId + ", votName=" + votName + ", voterAddress=" + voterAddress + '}';
    }
}
