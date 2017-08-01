/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.api;

import com.usman.medical.data.AdminResponse;
import com.usman.medical.data.Orders;
import java.util.List;

/**
 *
 * @author fusman
 */
public interface IOrder {
    
    List<Orders> listOrder();

    List<Orders> findOrders(Orders order);

    Orders findOrderById(long orderId);

    AdminResponse createOrder(Orders order);

    AdminResponse updateOrder(Orders order);

    AdminResponse deleteOrder(Orders order);
}
