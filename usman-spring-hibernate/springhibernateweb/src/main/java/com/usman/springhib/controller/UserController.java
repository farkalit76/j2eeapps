/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.springhib.controller;

import com.usman.springhib.dao.UserDao;
import com.usman.springhib.model.User;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author 72010995
 */
@Controller
@RequestMapping("/user")
public class UserController
{

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/show")
    public ModelAndView home()
    {
        LOG.info("User is started..");
        List<User> listUsers = userDao.list();
        ModelAndView model = new ModelAndView("userhome");
        model.addObject("userList", listUsers);
        return model;
    }

}
