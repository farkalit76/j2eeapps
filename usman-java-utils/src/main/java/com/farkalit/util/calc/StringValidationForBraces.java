/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.util.calc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author fusman
 */
public class StringValidationForBraces {

    private static final String message = "This[is{what(you[were(asking)with]me)to}solve]it.";

    private static final Character[] openChars =
    {
        '[', '{', '('
    };
    private static final Character[] closeChars =
    {
        ']', '}', ')'
    };

    private static final Character[] allChars =
    {
        '[', '{', '(', ')', '}', ']'
    };

    public static void main(String[] args)
    {
        validate(message);
    }

    public static void validate(String message)
    {
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        char[] tokens = message.toCharArray();
        for (int i = 0; i < tokens.length; i++)
        {
            for (int c = 0; c < allChars.length; c++)
            {
                if (tokens[i] == allChars[c])
                {
                    //System.out.println("i :" + i + "=" + tokens[i]);
                    queue.add(tokens[i]);
                    stack.push(tokens[i]);
                }
            }
        }
        System.out.println("queue:" + queue);
        System.out.println("stack:" + stack);
        System.out.println("queue:" + queue.size());

        int count = 0;
        int stackCountHalf = queue.size() / 2;
        if (!queue.isEmpty() || !stack.isEmpty())
        {
            for (int i = 0; i < stackCountHalf; i++)
            {
                boolean flag = false;
                final Character poll = queue.poll();//first in first out
                final Character pop = stack.pop();//last in first out
                System.out.println("poll:" + poll + ", pop:" + pop);
                for (int k = 0; k < 3; k++)
                {
                    if (poll.equals(openChars[k]) && pop.equals(closeChars[k]))
                    {
                        flag = true;
                        count++;
                    }
                }
                if (!flag)
                {
                    System.out.println("Message braces are NOT correct");
                    break;
                }
            }
            if (count == stackCountHalf)
            {
                System.out.println("Message braces are CORRECT.....");
            }
        }

    }
}
