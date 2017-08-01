/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.test;

import com.usman.medical.dao.PaymentDaoImpl;
import com.usman.medical.data.Payment;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author 72010995
 */
public class PaymentTest
{
    public static void main(String[] args)
    {
        //PaymentDao dao = new PaymentDao();
        //runPayment(dao);
        //close session factory
        //PaymentDao.closeSession();
        
    }
    
     public static void runPayment( PaymentDaoImpl dao){
       
        Payment payment = getPayment();
        dao.createPayment(payment);
        System.out.println("payment is created for ID:"+ payment.getModuleId());
        
        List<Payment> payments= dao.listPayment();
        //dao.findPaymentById(payments.get(0).getModuleId());
         //dao.deleteDoctor(doctors.get(0));
        Iterator<Payment> iterator = payments.iterator();
        while(iterator.hasNext()){
           System.out.println("Payment:"+ iterator.next().toString());
        }
    }
    
    
      private static Payment getPayment(){
       
        Payment payment = new Payment();
        payment.setModuleId(1013);
        payment.setPatientId(117l);
        payment.setFeeType("CON");
        payment.setAmount(80.00);
        payment.setDepartment("GEN");
        payment.setDoctorId(1123l);
        payment.setDescription("First time registration fee.");

        return payment;
    }
    
}
