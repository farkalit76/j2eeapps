/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.mapping.test;

import com.farkalit.mapping.model.CartItems;
import com.farkalit.mapping.model.Cart;
import com.farkalit.util.HibSessionManager;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author 72010995
 */
public class OneToManyMappingTest
{

    private static final SessionFactory sessionFactory = HibSessionManager.getSessionFactory();
     
    public static void main(String[] args)
    {
        Cart cart = new Cart();
        cart.setName("MyCart");

        CartItems item1 = new CartItems("I1", 10, 1, cart);
        CartItems item2 = new CartItems("I2", 20, 2, cart);
        Set<CartItems> itemsSet = new HashSet<>();
        itemsSet.add(item1);
        itemsSet.add(item2);

        cart.setItems(itemsSet);
        cart.setTotal(10 * 1 + 20 * 2);

        try
        {
            Session session = sessionFactory.openSession();
            System.out.println("Session created");
            //start transaction
            Transaction tx = session.beginTransaction();

            //Save the Model objects
            session.save(cart);
            session.save(item1);
            session.save(item2);

            //Commit transaction
            tx.commit();
            System.out.println("Cart ID=" + cart.getId());
            HibSessionManager.closeSessionFactory();

        }
        catch (Exception e)
        {
            System.out.println("Exception occured. " + e.getMessage());
            e.printStackTrace();
        }
        finally
        {
            if (!sessionFactory.isClosed())
            {
                System.out.println("Closing SessionFactory");
                sessionFactory.close();
            }
        }
    }
}
