/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.service;

import com.usman.medical.api.IOrder;
import com.usman.medical.data.AdminResponse;
import com.usman.medical.data.Orders;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fusman
 */
@Service
public class OrderService implements IOrderService{
    
    @Autowired(required = true)
    private IOrder orderDao;

    @Override
    @Transactional
    public List<Orders> listOrder()
    {
        return orderDao.listOrder();
    }

    @Override
    @Transactional
    public List<Orders> findOrders(Orders order)
    {
        return orderDao.findOrders(order);
    }

    @Override
    @Transactional
    public Orders findOrderById(long orderId)
    {
        return orderDao.findOrderById(orderId);
    }

    @Override
    @Transactional
    public AdminResponse createOrder(Orders order)
    {
        return orderDao.createOrder(order);
    }

    @Override
    @Transactional
    public AdminResponse updateOrder(Orders order)
    {
        return orderDao.updateOrder(order);
    }

    @Override
    @Transactional
    public AdminResponse deleteOrder(Orders order)
    {
        return orderDao.deleteOrder(order);
    }
    
}
