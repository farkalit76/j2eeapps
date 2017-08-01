/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.util;

/**
 *
 * @author 72010995
 */
public class ImmutableTest
{
    public static void main(String[] args)
    {
        String str = new String("abc");
        System.out.println(str+",str.hashCode:"+str.hashCode());
        str +="xyz";
        System.out.println(str+",str.hashCode:"+str.hashCode());
        str ="Null";
        System.out.println(str+",str.hashCode:"+str.hashCode());
        
        StringBuffer buff = new StringBuffer("abc");
        System.out.println(buff+",buff.hashCode:"+buff.hashCode());
        buff.append("xyz");
        System.out.println(buff+",buff.hashCode:"+buff.hashCode());
        buff.append("Null");
        System.out.println(buff+",buff.hashCode:"+buff.hashCode());
        
    }
}
