/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.util.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author 72010995
 */
public class CreditCardTest {

    private static final List<CreditCardPaymentType> CREDIT_CARD_ISSUER_LIST = Arrays.asList(CreditCardPaymentType.VISA, CreditCardPaymentType.MASTERCARD, CreditCardPaymentType.DISCOVER, CreditCardPaymentType.AMERICAN_EXPRESS);

    public static void main(String[] args) {

        String number[] = {"5555555555554444", "2223000048400011", "2223000148400010", "2457026326581179", "", "12312", "289000","2857026326581179"};
        for (int i = 0; i < number.length; i++) {
            CreditCardPaymentType type = CreditCardPaymentType.getCreditCardPaymentType(number[i]);
            System.out.println("creditCardPaymentType:" + type);
        }
    }
}
