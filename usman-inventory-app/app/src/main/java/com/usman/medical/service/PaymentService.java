/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.service;

import com.usman.medical.data.AdminResponse;
import com.usman.medical.data.Payment;
import java.util.List;

/**
 *
 * @author 72010995
 */
public interface PaymentService
{
     List<Payment> listPayment();

    List<Payment> findPayment(Payment payment);

    Payment findPaymentById(long paymentId);

    AdminResponse createPayment(Payment payment);

    AdminResponse updatePayment(Payment payment);

    AdminResponse deletePayment(Payment payment);
}
