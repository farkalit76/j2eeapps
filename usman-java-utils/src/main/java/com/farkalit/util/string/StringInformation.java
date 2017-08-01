/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.util.string;

/**
 *
 * @author fusman
 */
public class StringInformation {
    
    public static void main(String[] args) {
        String name = "Usman";
        StringBuffer buff = new StringBuffer("Usman");
        StringBuilder build = new StringBuilder("Usman");
        System.out.println("name:"+name+ ", buff:"+buff+", build:"+build);
        System.out.println("name:"+name.hashCode()+ ", buff:"+buff.hashCode()+",build:"+build.hashCode());
        name += "Usmani";
        buff.append("Usmani");
        build.append("Usmani");
        System.out.println("name:"+name+ ", buff:"+buff+",build:"+build);
        System.out.println("name:"+name.hashCode()+ ", buff:"+buff.hashCode()+",build:"+build.hashCode());
        System.gc();
    }
}
