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
public class EnumSecondVO
{
    private String message;
    private MyEnum copyEnum;

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public MyEnum getCopyEnum()
    {
        return copyEnum;
    }

    public void setCopyEnum(MyEnum copyEnum)
    {
        this.copyEnum = copyEnum;
    }
    
    @Override
    public String toString()
    {
        StringBuilder build = new StringBuilder("EnumSecondVO[");
        build.append(message).append(":");
        build.append(copyEnum).append("]");
        return build.toString(); //To change body of generated methods, choose Tools | Templates.
    }
}
