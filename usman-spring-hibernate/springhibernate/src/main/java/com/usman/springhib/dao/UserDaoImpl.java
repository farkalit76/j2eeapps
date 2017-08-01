/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.springhib.dao;

import com.usman.springhib.model.User;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author 72010995
 */
public class UserDaoImpl implements UserDao
{
    
    private SessionFactory sessionFactory;

    public UserDaoImpl(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<User> list()
    {
        @SuppressWarnings("unchecked")
        final Session currentSession = sessionFactory.getCurrentSession();
        List<User> listUser = (List<User>) currentSession.createCriteria(User.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return listUser;
    }

}
