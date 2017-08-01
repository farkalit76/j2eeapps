/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.util.parse;

/**
 *
 * @author 72010995
 */
public class ParseHouseNumber {

    public static void main(String[] args) {

        String serviceAddress [] = {"4263 135th Pl SE", "1722 Poplar Ln NW","217 T St NE","2709 SOUTH DAKOTA AVE NE",
            "143 T St NW","307 ROCK CRK CHURCH RD NW", "53 Todd Pl NE","4611 SOUTH DAKOTA AVE NE"};

        for (String addres : serviceAddress) {
            String hsNumber = prase(addres);
            System.out.println("hsNumber:"+hsNumber);
        }
        
    }

    private static String prase(String serviceAddress) {

        String hsNumber = "";
        
        if (serviceAddress != null && !serviceAddress.equals("")) {
            String trimmedAddress = serviceAddress.trim();

            String array[] = trimmedAddress.split(" ", 0);
            
//            for (String array1 : array) {
//                System.out.println("array1:"+array1);
//            }
            if (array[0].length() > 0 & array[0].length() <= 6) {
                hsNumber = array[0].trim();
            }else{
                hsNumber ="9999"; //Dummy house numebr
            }
        }else{
            hsNumber= serviceAddress;
        }
        return hsNumber;
    }

}
