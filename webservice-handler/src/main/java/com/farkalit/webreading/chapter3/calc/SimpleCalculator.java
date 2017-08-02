/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.webreading.chapter3.calc;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author fusman
 */
@WebService(name = "SimpleCalculator", targetNamespace = "http://chapter3.webreading.farkalit.com/calc")
@HandlerChain(file="/com/farkalit/ws/login-handler-chain.xml")
public class SimpleCalculator {

    private final Character[] coperators = new Character[]
    {
        '-', '+', '/', '*', 'x', 'X'
    };

    /**
     * Web service operation
     *
     * @param input
     * @return
     */
    @WebMethod(operationName = "operation")
    public String operation(@WebParam(name = "input") String input) throws CalcException
    {
        System.out.println("input:" + input);
        //return calculate(input);
        String operator = findSymbol(input);
        System.out.println("operator:" + operator);
        if (operator == null)
        {
            throw new CalcException("Please input a valid operator", operator);
        } else if (operator.equalsIgnoreCase("invalid"))
        {
            throw new CalcException("Invalid Operator", operator);
        } else
        {
            if (operator.equals("+"))
            {
                operator = "\\+";
            }

            if (operator.equals("*"))
            {
                operator = "\\*";
            }
            System.out.println("operator changed:" + operator);
        }
        return calculate(input, operator);
    }

    private String calculate(String input, String operator)
    {
        String[] split = input.split(operator);
        System.out.println("split.length:" + split.length);
        int left = Integer.parseInt(split[0]);
        System.out.println("left:" + left);
        int right = Integer.parseInt((split[1]));
        System.out.println("right:" + right);
        String result = "";

        switch (operator)
        {
            case "\\+":
                result = Double.toString(left + right);
                break;
            case "-":
                result = Double.toString(left - right);
                break;
            case "\\*":
            case "x":
            case "X":
                result = Double.toString(left * right);
                break;
            case "/":
                result = Double.toString(left / right);
                break;
            default:
                System.out.println("Invalid Operator");
        }
        System.out.println("result:" + result);
        return result;

    }

    public String findSymbol(String input)
    {

        for (Character operator : coperators)
        {
            if (input.contains(String.valueOf(operator)))
            {
                return String.valueOf(operator);
            }
        }
        return "invalid";
    }

}
