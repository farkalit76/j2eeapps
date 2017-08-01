/*
 * Copyright (c) Vertex Business Services.
 * All rights reserved.
 * 
 * No parts of this source code can be reproduced without written consent from
 * Vertex Business Services.
 */
package com.farkalit.hazelcast.jdbc;

import com.hazelcast.core.MapStore;
import static java.lang.String.format;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.sql.DataSource;

/**
 *
 * @author 72010995
 */
public class PersonMapStore implements MapStore<Long, Person>
{

    private final Connection con;
    //private PreparedStatement allKeysStatement;

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    public PersonMapStore()
    {
        try
        {
            con = dataSource.getConnection();
//            con = DriverManager.getConnection("jdbc:hsqldb:mydatabase", "SA", "");
//            con.createStatement().executeUpdate(
//                    "create table if not exists person (id bigint, name varchar(45))");
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public synchronized void delete(Long key)
    {
        System.out.println("Delete:" + key);
        try
        {
            con.createStatement().executeUpdate(
                    format("delete from person where id = %s", key));
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void deleteAll(Collection<Long> keys)
    {
        for (Long key : keys)
        {
            delete(key);
        }
    }
    
    public void store(Long key, Person value)
    {
        try
        {
            con.createStatement().executeUpdate(
                    format("insert into person values(%s,'%s')", key, value.getName()));
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void storeAll(Map<Long, Person> map)
    {
        for (Map.Entry<Long, Person> entry : map.entrySet())
        {
            store(entry.getKey(), entry.getValue());
        }
    }

    
    public synchronized Person load(Long key)
    {
        try
        {
            ResultSet resultSet = con.createStatement().executeQuery(
                    format("select name from person where id =%s", key));
            try
            {
                if (!resultSet.next())
                {
                    return null;
                }
                String name = resultSet.getString(1);
                return new Person(key, name);
            }
            finally
            {
                resultSet.close();
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public synchronized Map<Long, Person> loadAll(Collection<Long> keys)
    {
        Map<Long, Person> result = new HashMap<Long, Person>();
        for (Long key : keys)
        {
            result.put(key, load(key));
        }
        return result;
    }

    public synchronized Set<Long> loadAllKeys()
    {
        return null;
    }

}
