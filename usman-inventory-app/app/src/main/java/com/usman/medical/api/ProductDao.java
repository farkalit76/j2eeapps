/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.api;

import com.usman.medical.data.AdminResponse;
import com.usman.medical.data.Product;
import java.util.List;

/**
 *
 * @author fusman
 */
public interface ProductDao {
    
    List<Product> listProduct();

    List<Product> findProduct(Product product);
    
    Product findProductById(long productId);

    AdminResponse createProduct(Product product);

    AdminResponse updateProduct(Product product);

    AdminResponse deleteProduct(Product product);
}
