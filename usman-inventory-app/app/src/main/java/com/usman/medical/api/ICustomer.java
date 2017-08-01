/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.api;

import com.usman.medical.data.AdminResponse;
import com.usman.medical.data.Customer;
import java.util.List;

/**
 *
 * @author fusman
 */
public interface ICustomer {

    List<Customer> listCustomer();

    List<Customer> findCustomers(Customer customer);

    Customer findCustomerById(long customerId);

    AdminResponse createCustomer(Customer customer);

    AdminResponse updateCustomer(Customer customer);

    AdminResponse deleteCustomer(Customer customer);

}
