/*
 * Copyright (c) Vertex Business Services.
 * All rights reserved.
 * 
 * No parts of this source code can be reproduced without written consent from
 * Vertex Business Services.
 */
package com.farkalit.hazelcast.jdbc;

import com.farkalit.hazelcast.jdbc.util.HibernateUtil;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.MapLoader;
import com.hazelcast.core.MapLoaderLifecycleSupport;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author 72010995
 */
public class PersonMapLoader implements MapLoader<Long, Person>, MapLoaderLifecycleSupport
{

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session = sessionFactory.openSession();
    Query allKeysQuery = session.createQuery("select id from Person").setFetchSize(1000);

    public PersonMapLoader()
    {
    }

    @Override
    public void init(HazelcastInstance hz, Properties props, String arg2)
    {
    }

    @Override
    public Person load(Long key)
    {
        return (Person) session.get(Person.class, key);
    }

    @Override
    public Map<Long, Person> loadAll(Collection<Long> keys)
    {
        Criteria criteria = session.createCriteria(Person.class).add(Restrictions.in("id", keys));
        List<Person> persons = criteria.list();

        Map<Long, Person> map = new HashMap<Long, Person>();
        for (Person person : persons)
        {
            map.put(person.id, person);
        }
        return map;
    }

//    @Override
//    public Iterable<Long> loadAllKeys()
//    {
//        // For smaller result set sizes use: allKeysQuery.list()
//        return new QueryIterable<Long>(allKeysQuery);
//    }

    @Override
    public void destroy()
    {
        session.close();
    }

    @Override
    public Set<Long> loadAllKeys()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
