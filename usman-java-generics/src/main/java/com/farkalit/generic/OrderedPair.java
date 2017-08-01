/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.farkalit.generic;

/**
 *
 * @author 72010995
 * @param <K>
 * @param <V>
 */
public class OrderedPair<K,V> implements Pair<K, V>
{

    private K key;
    private V value;
    
    public OrderedPair(K key, V value){
        this.key=key;
        this.value=value;
    }
    
    
    @Override
    public K getKey()
    {
      return key;
    }

    @Override
    public V getValue()
    {
       return value;
    }

    @Override
    public String toString()
    {
        return "K:"+getKey()+",V:"+getValue();
    }
    
    
}
