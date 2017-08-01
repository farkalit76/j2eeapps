/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.dao;

import com.usman.medical.api.PaymentDao;
import com.usman.medical.data.AdminResponse;
import com.usman.medical.data.Payment;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 72010995
 */
@Repository
public class PaymentDaoImpl implements PaymentDao
{

    //Create a single session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Payment> listPayment()
    {
        //Query query = sessionFactory.getCurrentSession().createQuery("from Payment");

        Criteria crit = sessionFactory.getCurrentSession().createCriteria(Payment.class, "payment");
        crit.addOrder(Order.desc("createdDate"));
        List<Payment> payments = (List<Payment>) crit.list();

        return payments;
    }

    @Override
    public List<Payment> findPayment(Payment payment)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Payment findPaymentById(long paymentId)
    {
        Session session = sessionFactory.getCurrentSession();
        Payment payment = (Payment) session.get(Payment.class, paymentId);
        System.out.println(payment.toString());

        return payment;
    }

    @Override
    public AdminResponse createPayment(Payment payment)
    {
        Session session = sessionFactory.getCurrentSession();
        session.persist(payment);
        System.out.println("payment created...");
        AdminResponse response = new AdminResponse(true, 101, "payment created.");

        return response;
    }

    @Override
    public AdminResponse updatePayment(Payment payment)
    {
        Session session = sessionFactory.getCurrentSession();
        session.update(payment);
        System.out.println("payment updated...");
        AdminResponse response = new AdminResponse(true, 102, "payment updated.");

        return response;
    }

    @Override
    public AdminResponse deletePayment(Payment payment)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
