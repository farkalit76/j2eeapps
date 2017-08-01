/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.util.calc;

import java.text.DecimalFormat;
import java.util.Stack;

/**
 * This algebraic calculator will accept the following expression to evaluate
 * it. Expression Example: "3 * 2" or "6 / 2 +9 * 100", "6 /2 - 5 * 3 + 1 + 9 *
 * 100"
 *
 * @author fusman
 */
public class AlgebraicCalculator {

    /**
     * This method will evaluate the algebraic expression (with operators
     * divide, multiply, subtract and add) and then returns the result.
     *
     * @param numbersArray
     * @return double value of result
     */
    public double evaluate(String numbersArray)
    {
        /*
         * Check that the given expression is valid or not.
         */
        if (!validate(numbersArray))
        {
            return Double.NaN;
        }

        char[] tokens = numbersArray.trim().toCharArray();
        DecimalFormat format = new DecimalFormat("##.##");
        // Stack for numbers
        Stack<Double> numbers = new Stack<>();

        // Stack for Operators
        Stack<Character> oprt = new Stack<>();

        for (int i = 0; i < tokens.length; i++)
        {

            /*
             * If current token is a number, push it into numbers stack.
             */
            if (tokens[i] >= '0' && tokens[i] <= '9')
            {
                StringBuffer buff = new StringBuffer();
                // There may be more than one digits in number
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
                {
                    buff.append(tokens[i++]);
                }
                numbers.push(Double.parseDouble(buff.toString()));
            } /*
             * if current token is an operator, push it into operand stack.
             */ else if (tokens[i] == '/' || tokens[i] == '*' || tokens[i] == '-' || tokens[i] == '+')
            {
                /*
                 * Check the operand order based on precedency, that is divide and multiply 
                 * is greater order than the subtract and add. Calculate if it is greater order.
                 */
                while (!oprt.empty() && operandOrder(tokens[i], oprt.peek()))
                {
                    numbers.push(calculate(numbers.pop(), numbers.pop(), oprt.pop()));
                }
                // Push current token to operator stack.
                oprt.push(tokens[i]);
            }
        }

        /*
         * Calculate all the values till the operators exists in the stack. 
         */
        while (!oprt.empty())
        {
            numbers.push(calculate(numbers.pop(), numbers.pop(), oprt.pop()));
        }

        // Return the result
        return Double.parseDouble(format.format(numbers.pop()));
    }

    /**
     * If operator2 is higher or same precedence than the operator1 then return
     * true else false.
     *
     * @param op1
     * @param op2
     * @return boolean value
     */
    private boolean operandOrder(char op1, char op2)
    {
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
        {
            return false;
        }
        return true;
    }

    /**
     * Validate the algebraic expression.
     *
     * @param numArray
     * @return boolean value
     */
    private boolean validate(String numArray)
    {
        if (numArray == null || numArray.trim().length() < 3)
        {
            System.out.println("\n ***Please enter the valid expression***");
            return false;
        }
        return true;
    }

    /**
     * Do the basic operation of the numeric values.
     *
     * @param y
     * @param x
     * @param opr
     * @return double value of operation result
     */
    private double calculate(double y, double x, char opr)
    {
        if (opr == '/')
        {
            if (y == 0)
            {
                throw new UnsupportedOperationException("Number cannot be divided by 0");
            }
            return x / y;
        } else if (opr == '*')
        {
            return x * y;
        } else if (opr == '-')
        {
            return x - y;
        } else
        {
            return x + y;
        }
    }

}
