/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.dao;

import com.usman.medical.api.IOrder;
import com.usman.medical.data.AdminResponse;
import com.usman.medical.data.Orders;
import com.usman.medical.data.Patient;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fusman
 */
@Repository
public class OrderDao implements IOrder{

    //Create a single session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Orders> listOrder()
    {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(Orders.class, "order");
        crit.addOrder(org.hibernate.criterion.Order.desc("createdDate"));
        List<Orders> orders = (List<Orders>) crit.list();

        return orders;
    }

    @Override
    public List<Orders> findOrders(Orders orders)
    {
        System.out.println("orders:"+orders.toString());
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(Orders.class, "orders");
        if (orders != null)
        {
            if (orders.getModuleId() != 0)
            {
                crit.add(Restrictions.idEq(orders.getModuleId()));
            }
            if (orders.getProdId()!= 0)
            {
                crit.add(Restrictions.eq("prodId", orders.getProdId()));
            }
            if (orders.getProdName() != null && !orders.getProdName().equals(""))
            {
                crit.add(Restrictions.like("prodName", orders.getProdName()));
            }
            if (orders.getDescription()!= null && !orders.getDescription().equals(""))
            {
                crit.add(Restrictions.like("description", "%" + orders.getDescription() + "%"));
            }

            if (orders.getDispatched()!= null && !orders.getDispatched().equals(""))
            {
                crit.add(Restrictions.like("dispatched", orders.getDispatched()));
            }
        }

        List<Orders> listOrders = (List<Orders>) crit.list();
        return listOrders;
    }

    @Override
    public Orders findOrderById(long orderId)
    {
        Session session = sessionFactory.getCurrentSession();
        Orders order = (Orders) session.get(Orders.class, orderId);
        System.out.println(order.toString());

        return order;
    }

    @Override
    public AdminResponse createOrder(Orders order)
    {
        Session session = sessionFactory.getCurrentSession();
        session.persist(order);
        System.out.println("order created...");
        AdminResponse response = new AdminResponse(true, 101, "order created.");
        return response;
    }

    @Override
    public AdminResponse updateOrder(Orders order)
    {
        Session session = sessionFactory.getCurrentSession();
        session.update(order);
        System.out.println("order updated...");
        AdminResponse response = new AdminResponse(true, 102, "order updated.");
        return response;
    }

    @Override
    public AdminResponse deleteOrder(Orders order)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
