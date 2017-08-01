/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.generics;

/**
 *
 * @author 72010995
 */
public class AxisPair<X extends Number, Y extends Number> {
    
    public X xAxis;
    public Y yAxis;
    
    public AxisPair(X x, Y y)
    {
        this.xAxis=x;
        this.yAxis=y;
    }

    public X getxAxis() {
        return xAxis;
    }

    public void setxAxis(X xAxis) {
        this.xAxis = xAxis;
    }

    public Y getyAxis() {
        return yAxis;
    }

    public void setyAxis(Y yAxis) {
        this.yAxis = yAxis;
    }
    
}
