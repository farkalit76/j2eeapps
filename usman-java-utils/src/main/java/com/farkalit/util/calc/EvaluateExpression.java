/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.util.calc;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author fusman
 */
public class EvaluateExpression {

    public static void main(String[] args)
    {
        ///:47 *:42 +:43 
        //evaluate("3*5-10");//5.0
        //evaluate("5 * 3 + 1 + 6 / 2 +9 * 100");//919.0
        //evaluate("5 * 3 + 1 + 6 / 85 +9 * 100");//916.07;
        evaluate("6 / 2 -5 * 3 + 1 + 9 * 100");//889.0
    }

    private static void evaluate(String input) throws NumberFormatException
    {
        //Scanner scan = new Scanner(System.in);
        /* Create stacks for operators and operands */
        Stack<Integer> op = new Stack<>();
        Stack<Double> val = new Stack<>();
        /* Create temporary stacks for operators and operands */
        Stack<Integer> optmp = new Stack<>();
        Stack<Double> valtmp = new Stack<>();
        /* Accept expression */
        System.out.println("Evaluation Of Arithmetic Expression Using Stacks Test\n");
        //String input = scan.next();
        //input = "0" + input;
        input = input.replaceAll(" ", "");
        input = input.replaceAll("-", "+-");
        System.out.println("New Expression: " + input);
        /* Store operands and operators in respective stacks */
        String temp = "";
        for (int i = 0; i < input.length(); i++)
        {
            char ch = input.charAt(i);
            if (ch == '-')
            {
                temp = "-" + temp;
            } else if (ch != '+' && ch != '*' && ch != '/')
            {
                temp = temp + ch;
            } else
            {
                val.push(Double.parseDouble(temp));
                op.push((int) ch);
                temp = "";
            }
        }
        val.push(Double.parseDouble(temp));

        printStack(0,val);
        printStack(0,op);
        /* Create char array of operators as per precedence */
        /* -ve sign is already taken care of while storing */
        char operators[] = { '/', '*', '+' };
        /* Evaluation of expression */
        for (int i = 0; i < 3; i++)
        {
            boolean it = false;
            while (!op.isEmpty())
            {
                int optr = op.pop();
                double v1 = val.pop();
                double v2 = val.pop();
                System.out.println("Opr:"+optr+",v2:"+v2+",v1:"+v1);
                if (optr == operators[i])
                {
                    /* if operator matches evaluate and store in temporary stack */
                    if (i == 0)
                    {
                        System.out.println("Dividing....");
                        valtmp.push(v2 / v1);
                        it = true;
                        break;
                    } else if (i == 1)
                    {
                        System.out.println("Multiplying....");
                        valtmp.push(v2 * v1);
                        it = true;
                        break;
                    } else if (i == 2)
                    {
                        System.out.println("Adding....");
                        valtmp.push(v2 + v1);
                        it = true;
                        break;
                    }
                } else
                {
                    System.out.println("Pushing v1 to temp:"+v1);
                    valtmp.push(v1);
                    val.push(v2);
                    optmp.push(optr);
                }
                
            }
             
            /* Push back all elements from temporary stacks to main stacks */
            while (!valtmp.isEmpty())
            {
                val.push(valtmp.pop());
            }
            while (!optmp.isEmpty())
            {
                op.push(optmp.pop());
            }
            printStack(i, val);
            printStack(i, op);
            /* Iterate again for same operator */
            if (it)
            {
                System.out.println("Iterate again for same operator");
                i--;
            }
        }
        System.out.println("\nResult = " + val.pop());
    }

    private static void printStack(int loop, Stack stack)
    {
        if (stack.isEmpty())
        {
            System.out.println("Stack is empty");
        } else
        {
            System.out.println("loop:"+loop+"\n values:"+stack.toString()); 
        }
    }
     //http://www.sanfoundry.com/java-program-implement-evaluate-expression-using-stacks/
}
