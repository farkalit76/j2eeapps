/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.farkalit.util.enums;

/**
 *
 * @author 72010995
 */
public class EnumVO
{
    private MyEnum enums;

    public MyEnum getEnums()
    {
        return enums;
    }

    public void setEnums(MyEnum enums)
    {
        this.enums = enums;
    }

    @Override
    public String toString()
    {
        StringBuilder build = new StringBuilder("EnumVO:");
        build.append(enums).append(":");
        return build.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
