/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.service;

import com.usman.medical.dao.ProductDaoImpl;
import com.usman.medical.data.AdminResponse;
import com.usman.medical.data.Product;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fusman
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired(required = true)
    private ProductDaoImpl productDao;

    @Override
    @Transactional
    public List<Product> listProduct()
    {
        return productDao.listProduct();
    }

    @Override
    @Transactional
    public List<Product> findProduct(Product product)
    {
        return productDao.findProduct(product);
    }

    @Override
    @Transactional
    public Product findProductById(long productId)
    {
        return productDao.findProductById(productId);
    }

    @Override
    @Transactional
    public AdminResponse createProduct(Product product)
    {
        return productDao.createProduct(product);
    }

    @Override
    @Transactional
    public AdminResponse updateProduct(Product product)
    {
        return productDao.updateProduct(product);
    }

    @Override
    @Transactional
    public AdminResponse deleteProduct(Product product)
    {
        return productDao.deleteProduct(product);
    }

}
