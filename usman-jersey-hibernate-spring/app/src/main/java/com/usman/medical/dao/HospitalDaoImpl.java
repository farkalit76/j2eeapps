/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.dao;

import com.usman.medical.api.HospitalDao;
import com.usman.medical.data.Hospital;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 72010995
 */
@Repository
public class HospitalDaoImpl implements HospitalDao
{

    @Autowired(required = true)
    private SessionFactory sessionFactory;

    @Override
    public List<Hospital> listHospital()
    {
        Query query = sessionFactory.getCurrentSession().createQuery("from Hospital");
        List<Hospital> hospitals = query.list();
        return hospitals;
    }

}
