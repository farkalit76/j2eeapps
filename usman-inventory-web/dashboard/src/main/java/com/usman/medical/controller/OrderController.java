/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.controller;

import com.usman.medical.data.AdminResponse;
import com.usman.medical.data.OrderSearch;
import com.usman.medical.data.Orders;
import com.usman.medical.data.Product;
import com.usman.medical.service.ICustomerService;
import com.usman.medical.service.IOrderService;
import com.usman.medical.service.ProductService;
import com.usman.medical.util.IDGenerator;
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
@RequestMapping("/order")
public class OrderController {
    
     private static final Logger LOG = LoggerFactory.getLogger(OrderController.class);
     
     @Autowired
    private IOrderService orderService;

    @Autowired
    private ProductService productService;
    
    @Autowired
    private ICustomerService customerService;
    
    @RequestMapping("/show")
    public ModelAndView showOrder(@ModelAttribute("orderSearch") OrderSearch orderSearch, BindingResult result, Model models)
    {
        LOG.info("Orders display ");

        ModelAndView model = new ModelAndView("order_list");
        List<Orders> orders = orderService.listOrder();
        LOG.info("Orders display size:" + orders.size());
        model.addObject("orders", orders);
        return model;

    }
    
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchOrders(@ModelAttribute("orderSearch") OrderSearch search, BindingResult result, Model models)
    {
        //LOG.info("order search "+search.toString());
        models.addAttribute("orderSearch", search);
        
        Orders ord = new Orders();
        ord.setModuleId(search.getModuleId());
        ord.setProdId(search.getProdId());
        ord.setProdName(search.getProdName());
        ord.setCustId(search.getCustId());
        ord.setCustName(search.getCustName());
        ord.setDescription(search.getDescription());
        ord.setDispatched(search.getDispatched());
        LOG.info("order search :"+ord.toString());
        List<Orders> orders = orderService.findOrders(ord);
        models.addAttribute("orders", orders);

        return "order_list";
    }
    
     @RequestMapping("/new")
    public ModelAndView newPayment(HttpServletRequest request, Model models)
    {
        LOG.info("Order New ");
        int prodId = Integer.parseInt(request.getParameter("prodId"));
        Product product = productService.findProductById(prodId);
        Orders order = new Orders();
        order.setProdId(prodId);
        order.setProdName(product.getName());
        order.setDescription(product.getDescription());
        order.setQuantity(product.getQuantity());
        order.setUnitPrice(product.getUnitPrice());
        //take customer data from session
        order.setCustId(6846);
        order.setCustName("usman");
        ModelAndView model = new ModelAndView("order", "order", order);
        model.addObject("prodId", "" + prodId);
        model.addObject("amount", product.getUnitPrice());
        model.addObject("availQty", product.getQuantity());

        return model;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createPayment(@ModelAttribute("order") Orders order, BindingResult result, Model model)
    {
        LOG.info("start order creation.....");
        try
        {
            LOG.info("order:" + order.toString());
            final int orderId = IDGenerator.getRandomNum();
            LOG.info("Order orderId created: "+orderId);
            order.setModuleId(orderId);
            order.setDispatched("No");
            AdminResponse ordResponse = orderService.createOrder(order);
            //Get product based on productid
            Product prod = productService.findProductById(order.getProdId());
            prod.setQuantity(prod.getQuantity() - order.getQuantity());
            //update product for quantity
            AdminResponse prodResponse =productService.updateProduct(prod);
            LOG.info("Order created. ");
            model.addAttribute("orderId", orderId);
            model.addAttribute("order", order);
        }
        catch (Exception e)
        {
            System.err.println("orders error:"+e.getMessage());
        }
        //return "order_booked";
        //It wiil Prevent duplicate form submission
        return "redirect:/app/views/order/registration-success";
    }
    
    @RequestMapping(value = "/registration-success", method = RequestMethod.GET)
    public String handleRegistrationDone(@ModelAttribute("order") Orders order,  Model model){
        LOG.info("order....: "+order+toString());
        return "order_booked";
    }
    
    @RequestMapping("/view")
    public String viewOrder(HttpServletRequest request, Model model)
    {
        LOG.info("Order edit ");
        int orderId = Integer.parseInt(request.getParameter("orderId"));

        //PaymentDao dao = new PaymentDao();
        Orders orders = orderService.findOrderById(orderId);
        LOG.info("Order view "+orders.toString());
        model.addAttribute("order", orders);
        
        LOG.info("Order edit completed.");
        return "order_dispatch";

    }
    
    @RequestMapping(value="/dispatch", method = RequestMethod.POST)
    public String dispatchOrder(@ModelAttribute("orderSearch") Orders orders,BindingResult result, Model model)
    {
        LOG.info("Orders dispatch update ");

        orders.setDispatched("Yes");
        AdminResponse admResponse = orderService.updateOrder(orders);
        LOG.info("Orders dispatch update completged. ");
        List<Orders> orderList = orderService.listOrder();
        model.addAttribute("orders", orderList);

        return "order_list";
    }
    
    @RequestMapping("/payment")
    public String viewPayment(HttpServletRequest request, Model model)
    {
        LOG.info("Order Payment edit ");
        //int orderId = Integer.parseInt(request.getParameter("orderId"));

        //PaymentDao dao = new PaymentDao();
//        Orders orders = orderService.findOrderById(orderId);
//        LOG.info("Order payment view "+orders.toString());
//        model.addAttribute("order", orders);
        
        LOG.info("Order payment edit completed.");
        return "order_payment";
    }

}
