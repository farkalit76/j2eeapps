/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.pattern.structural.adapter;

/**
 * While implementing Adapter pattern, there are two approaches – class adapter
 * (INHERITENCE) and object adapter (COMPOSITION) – however both these
 * approaches produce same result.
 *
 * @author fusman
 */
public class SocketAdapterImpl extends Socket implements SocketAdapter {

    @Override
    public Volt getSixtyVolt()
    {
        return convertVolt(getVolt(), 2);
    }

    @Override
    public Volt getTwelveVolt()
    {
        return convertVolt(getVolt(), 10);
    }

    @Override
    public Volt getThreeVolt()
    {
       return convertVolt(getVolt(), 40); 
    }

    private Volt convertVolt(Volt v, int i)
    {
        return new Volt(v.getVolts() / i);
    }
}
