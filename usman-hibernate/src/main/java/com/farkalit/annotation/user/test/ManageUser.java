/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.annotation.user.test;

import com.farkalit.util.HibSessionManagerTest;
import com.farkalit.util.IdGenerator;
import java.util.Date;
import org.hibernate.SessionFactory;

/**
 *
 * @author 72010995
 */
public class ManageUser
{

    private static SessionFactory factory;

    public static void main(String[] args)
    {
        factory = HibSessionManagerTest.getSessionFactory();

        User user = new User();
        user.setUserId(IdGenerator.getRandomNum());
        user.setUsername("test");
        user.setCreatedBy("my");
        user.setCreatedDate(new Date());

        UserDao.save(factory, user);
        factory.close();
    }
}
