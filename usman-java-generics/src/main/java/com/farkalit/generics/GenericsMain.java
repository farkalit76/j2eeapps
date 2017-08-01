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
public class GenericsMain {
    
    private static Pair<String,Integer> pair1 = new Pair("pair#1", 12);
    private static Pair<String,Integer> pair2 = new Pair("pair#1", 12);
    private static Pair<String,Long> pair3 = new Pair("pair#3", 13);
    private static Pair<String,Float> wildPair = new Pair("pair#3", 22);
    
    private static AxisPair<Integer,Float> axisPair = new AxisPair(1, 12.4f);
    
    public static void main(String[] args) {
        
        System.out.println("Pair Boolean value:"+testPair(pair1, pair2));
        System.out.println("AxisPair value:"+axisPair.yAxis);
        System.out.println("WildTest:"+wildString(wildPair));
    }
    
    public static <K,V> boolean testPair(Pair<K,V> p1, Pair<K,V> p2)
    {
        if( p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue()))
        {
            return true;
        }
        return false;
    }
    
    public static String wildString(Pair<String,? super Float> p1)
    {
        return p1.getKey();
    }
}
