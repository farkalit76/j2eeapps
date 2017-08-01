/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.util.collection;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 *
 * @author fusman
 */
public class StackDemo {

    static void showpush(Stack<Integer> st, int a)
    {
        st.push(a);
        System.out.println("push(" + a + ")");
        System.out.println("stack: " + st);
    }

    static void showpop(Stack<Integer> st)
    {
        System.out.print("pop -> ");
        Integer a = st.pop();
        System.out.println(a);
        System.out.println("stack: " + st);
    }

    public static void main(String args[])
    {
        Stack<Integer> st = new Stack();
        System.out.println("stack: " + st);
        showpush(st, 42);
        showpush(st, 66);
        showpush(st, 99);
        showpop(st);//Last in First out
        showpop(st);
        showpop(st);
        try
        {
            showpop(st);
        } catch (EmptyStackException e)
        {
            System.out.println("empty stack");
        }
    }
}
