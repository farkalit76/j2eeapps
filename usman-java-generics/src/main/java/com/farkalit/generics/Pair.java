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
public class Pair<K, V> {
    
    public K key;
    public V value;

    public Pair(K k, V v){
        this.key=k;
        this.value=v;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
   
}
