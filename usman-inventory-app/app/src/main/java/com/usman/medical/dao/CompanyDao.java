/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usman.medical.dao;

import com.usman.medical.api.ICompany;
import com.usman.medical.data.Company;
import com.usman.medical.data.Doctor;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fusman
 */
@Repository
public class CompanyDao implements ICompany{

    @Autowired
    private SessionFactory sessionFactory;
      
    @Override
    public List<Company> listCompany()
    {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(Company.class, "company");
        crit.addOrder(Order.desc("createdDate"));
        List<Company> companies = (List<Company>) crit.list();
        return companies;
    }
    
}
