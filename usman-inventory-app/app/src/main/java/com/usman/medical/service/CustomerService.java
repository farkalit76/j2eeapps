/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.service;

import com.usman.medical.api.ICustomer;
import com.usman.medical.data.AdminResponse;
import com.usman.medical.data.Customer;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fusman
 */
@Service
public class CustomerService implements ICustomerService{

    @Autowired(required = true)
    private ICustomer intfCustomer;
    
    @Override
    @Transactional
    public List<Customer> listCustomer()
    {
        return intfCustomer.listCustomer();
    }

    @Override
    @Transactional
    public List<Customer> findCustomers(Customer customer)
    {
        return intfCustomer.findCustomers(customer);
    }

    @Override
    @Transactional
    public Customer findCustomerById(long customerId)
    {
        return intfCustomer.findCustomerById(customerId);
    }

    @Override
    @Transactional
    public AdminResponse createCustomer(Customer customer)
    {
        return intfCustomer.createCustomer(customer);
    }

    @Override
    @Transactional
    public AdminResponse updateCustomer(Customer customer)
    {
        return intfCustomer.updateCustomer(customer);
    }

    @Override
    @Transactional
    public AdminResponse deleteCustomer(Customer customer)
    {
        return intfCustomer.deleteCustomer(customer);
    }
    
}
