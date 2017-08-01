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
public class Company extends Admin{
   
    private String name;
    private String address;
    private String owner;
    private String branch;
    private Long branchId;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getOwner()
    {
        return owner;
    }

    public void setOwner(String owner)
    {
        this.owner = owner;
    }

    public String getBranch()
    {
        return branch;
    }

    public void setBranch(String branch)
    {
        this.branch = branch;
    }

    public Long getBranchId()
    {
        return branchId;
    }

    public void setBranchId(Long branchId)
    {
        this.branchId = branchId;
    }

    @Override
    public String toString()
    {
        return super.toString()+"Company{" + "name=" + name + ", address=" + address + ", owner=" + owner + ", branch=" + branch + ", branchId=" + branchId + '}';
    }
}
