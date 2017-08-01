/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.controller;

import com.usman.medical.data.AdminResponse;
import com.usman.medical.data.Product;
import com.usman.medical.service.ProductService;
import com.usman.medical.util.IDGenerator;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author fusman
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @RequestMapping("/show")
    public ModelAndView showPatient(@ModelAttribute("productSearch") Product product, BindingResult result, Model models)
    {
        LOG.info("Product display ");
        product.setUnitPrice(Double.valueOf("0"));
        ModelAndView model = new ModelAndView("product_list");
        List<Product> products = productService.listProduct();
        LOG.info("Product display size:" + products.size());
        model.addObject("products", products);
        return model;

    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchPatient(@ModelAttribute("productSearch") Product product, BindingResult result, Model models)
    {
        LOG.info("productSearch search ");
        models.addAttribute("productSearch", product);
        List<Product> products = productService.findProduct(product);
        models.addAttribute("products", products);

        return "product_list";
    }

    @RequestMapping("/new")
    public ModelAndView newProduct()
    {
        LOG.info("Product display ");
        ModelAndView model = new ModelAndView("product", "product", new Product());
        return model;

    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createPatient(@ModelAttribute("product") Product product, BindingResult result, Model model)
    {
        LOG.info("start product creation.....");
        try
        {
            LOG.info("Product:" + product.toString());
            product.setModuleId(IDGenerator.getRandomNum());
            AdminResponse admResponse = productService.createProduct(product);
            LOG.info("Product created. ");
            List<Product> products = productService.listProduct();
            model.addAttribute("products", products);
            model.addAttribute("productSearch", new Product());//added for search form
        } catch (Exception ex)
        {
            LOG.error("Product error:"+ex.getMessage());
            ex.printStackTrace();
        }
        return "product_list";
    }

    @RequestMapping("/edit")
    public String updatePatient(HttpServletRequest request, Model model)
    {
        LOG.info("Product edit ");
        int prodId = Integer.parseInt(request.getParameter("prodId"));

        Product product = productService.findProductById(prodId);
        model.addAttribute("product", product);
        model.addAttribute("action", "EDITS");
        LOG.info("Product edit completed.");
        return "product";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String editPatient(@ModelAttribute("patient") Product product, BindingResult result, Model model)
    {
        LOG.info("Product update ");
        //PatientDao dao = new PatientDao();
        AdminResponse admResponse = productService.updateProduct(product);
        LOG.info("Product update completged. ");
        List<Product> products = productService.listProduct();
        model.addAttribute("products", products);
        model.addAttribute("productSearch", new Product());//added for search form
        return "product_list";
    }

    @RequestMapping("/delete")
    public String deletePatient(HttpServletRequest request, Model model)
    {
        LOG.info("Product delete..... ");
        int prodId = Integer.parseInt(request.getParameter("prodId"));
        Product product = new Product();
        product.setModuleId(prodId);
        //PatientDao dao = new PatientDao();
        productService.deleteProduct(product);
        List<Product> products = productService.listProduct();
        model.addAttribute("products", products);
        model.addAttribute("productSearch", new Product());//added for search form
        LOG.info("Product deleted. ");
        return "product_list";
    }

    private List<Product> getProducts()
    {
        List<Product> prods = new ArrayList<Product>();
        Product prd = new Product();
        prd.setName("XYZ");
        prd.setDescription("sdfsdfsdfsd");
        prd.setQuantity(22);
        prd.setUnitPrice(122.30);
        prd.setPicture("asdfasdfasd");
        prods.add(prd);

        return prods;
    }
}
