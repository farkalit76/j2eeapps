/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.dao;

import com.usman.medical.api.ICustomer;
import com.usman.medical.data.AdminResponse;
import com.usman.medical.data.Customer;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fusman
 */
@Repository
public class CustomerDao implements ICustomer{
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> listCustomer()
    {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(Customer.class, "customer");
        crit.addOrder(Order.desc("createdDate"));
        List<Customer> customers = (List<Customer>) crit.list();
        return customers;
    }

    @Override
    public List<Customer> findCustomers(Customer customer)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer findCustomerById(long customerId)
    {
        Customer customer = (Customer) sessionFactory.getCurrentSession().get(Customer.class, customerId);
        System.out.println(customer.toString());
        return customer;
    }

    @Override
    public AdminResponse createCustomer(Customer customer)
    {
        Session session = sessionFactory.getCurrentSession();
        session.persist(customer);
        System.out.println("customer created...");
        AdminResponse response = new AdminResponse(true, 101, "customer created.");
        return response;
    }

    @Override
    public AdminResponse updateCustomer(Customer customer)
    {
        Session session = sessionFactory.getCurrentSession();
        session.update(customer);
        System.out.println("customer updated...");
        AdminResponse response = new AdminResponse(true, 102, "customer updated.");
        return response;
    }

    @Override
    public AdminResponse deleteCustomer(Customer customer)
    {
        Session session = sessionFactory.getCurrentSession();
        session.delete(customer);
        System.out.println("customer deleted...");
        AdminResponse response = new AdminResponse(true, 103, "customer deleted.");
        return response;
    }
    
}
