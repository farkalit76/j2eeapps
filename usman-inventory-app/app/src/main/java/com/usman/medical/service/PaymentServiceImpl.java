/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.service;

import com.usman.medical.api.PaymentDao;
import com.usman.medical.data.AdminResponse;
import com.usman.medical.data.Payment;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 72010995
 */
@Service
public class PaymentServiceImpl implements PaymentService
{
    @Autowired(required = true)
    private PaymentDao paymentDao; 

    @Override
    @Transactional
    public List<Payment> listPayment()
    {
        return paymentDao.listPayment();
    }

    @Override
    @Transactional
    public List<Payment> findPayment(Payment payment)
    {
        return paymentDao.findPayment(payment);
    }

    @Override
    @Transactional
    public Payment findPaymentById(long paymentId)
    {
        return paymentDao.findPaymentById(paymentId);
    }

    @Override
    @Transactional
    public AdminResponse createPayment(Payment payment)
    {
        return paymentDao.createPayment(payment);
    }

    @Override
    @Transactional
    public AdminResponse updatePayment(Payment payment)
    {
        return paymentDao.updatePayment(payment);
    }

    @Override
    @Transactional
    public AdminResponse deletePayment(Payment payment)
    {
        return paymentDao.deletePayment(payment);
    }
    
}
