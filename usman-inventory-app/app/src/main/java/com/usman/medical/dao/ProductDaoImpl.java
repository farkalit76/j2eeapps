/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.dao;

import com.usman.medical.api.ProductDao;
import com.usman.medical.data.AdminResponse;
import com.usman.medical.data.Product;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fusman
 */
@Repository
public class ProductDaoImpl implements ProductDao{

     //Create a single session factory
    @Autowired
    private SessionFactory sessionFactory;   
    
    @Override
    public List<Product> listProduct()
    {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(Product.class, "product");
        crit.addOrder(Order.desc("createdDate"));
        List<Product> products = (List<Product>) crit.list();
        return products;
    }

    @Override
    public List<Product> findProduct(Product product)
    {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(Product.class, "product");
        if (product != null)
        {
            if (product.getModuleId() != 0)
            {
                crit.add(Restrictions.idEq(product.getModuleId()));
            }
            if (product.getName() != null && !product.getName().equals(""))
            {
                crit.add(Restrictions.like("name", product.getName()));
            }
            if (product.getDescription()!= null && !product.getDescription().equals(""))
            {
                crit.add(Restrictions.like("description", "%" + product.getDescription()+ "%"));
            }

            if (product.getUnitPrice() > 0.0 && (product.getUnitPrice() != 0.0 ))
            {
                crit.add(Restrictions.like("unitPrice", product.getUnitPrice()));
            }
        }

        List<Product> products = (List<Product>) crit.list();
        return products;
    }

    @Override
    public Product findProductById(long productId)
    {
        Session session = sessionFactory.getCurrentSession();

        Product product = (Product) session.get(Product.class, productId);
        System.out.println(product.toString());
        return product;
    }

    @Override
    public AdminResponse createProduct(Product product)
    {
        Session session = sessionFactory.getCurrentSession();
        session.persist(product);
        System.out.println("product created...");
        AdminResponse response = new AdminResponse(true, 101, "product created.");

        return response;
    }

    @Override
    public AdminResponse updateProduct(Product product)
    {
        Session session = sessionFactory.getCurrentSession();
        session.update(product);
        System.out.println("product updated...");
        AdminResponse response = new AdminResponse(true, 102, "product updated.");

        return response;
    }

    @Override
    public AdminResponse deleteProduct(Product product)
    {
        Session session = sessionFactory.getCurrentSession();
        session.delete(product);
        System.out.println("product deleted...");
        AdminResponse response = new AdminResponse(true, 103, "product deleted.");

        return response;
    }
    
}
