/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.farkalit.generic;

/**
 *
 * @author 72010995
 * @param <T>
 */
public class Box<T>
{
    // T stands for "Type"
    private T t;

    public Box(){
    
    }
    
    public Box(T type){
        this.t=type;
    }
    
    public T getT()
    {
        return t;
    }

    public void setT(T t)
    {
        this.t = t;
    }

}
