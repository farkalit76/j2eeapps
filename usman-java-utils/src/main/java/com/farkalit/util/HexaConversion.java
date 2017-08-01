/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.util;

import java.io.UnsupportedEncodingException;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author fusman
 */
public class HexaConversion {

    public static void main(String[] args) throws UnsupportedEncodingException {

        String number = "vtsdevmpp1-2017089064337-19";//2017089055524"; //"12345678";

        System.out.println("Hexadecimal value of (" + number + ") is :"+ HexaConversion.toHexadecimal(number));
    }

    public static String toHexadecimal(String text) throws UnsupportedEncodingException {
        byte[] myBytes = text.getBytes("UTF-8");

        return DatatypeConverter.printHexBinary(myBytes);
    }

    private static String hexaNumber(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(String.format("%02X ", bytes[i]));
        }
        return sb.toString();
    }

}
