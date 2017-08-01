/*
 * Copyright (c) Vertex Business Services.
 * All rights reserved.
 * 
 * No parts of this source code can be reproduced without written consent from
 * Vertex Business Services.
 */
package com.farkalit.hazelcast.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author 72010995
 */
public class PersonDAOJdbc implements PersonDAO
{

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(Person person)
    {
        String insertSql = "INSERT INTO PERSON "
                + "(ID, NAME) VALUES (?, ?)";
        Connection conn = null;

        try
        {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(insertSql);
            ps.setLong(1, person.getId());
            ps.setString(2, person.getName());
            ps.executeUpdate();
            ps.close();

        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);

        }
        finally
        {
            if (conn != null)
            {
                try
                {
                    conn.close();
                }
                catch (SQLException e)
                {
                }
            }
        }
    }

    @Override
    public Person findByPersonId(long personId)
    {
        String selectSql = "SELECT * FROM PERSON WHERE ID = ?";

        Connection conn = null;

        try
        {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(selectSql);
            ps.setLong(1, personId);
            Person person = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                person = new Person(
                        rs.getLong("ID"),
                        rs.getString("NAME")
                );
                System.out.println("customer:" + person.toString());
            }
            rs.close();
            ps.close();
            return person;
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        finally
        {
            if (conn != null)
            {
                try
                {
                    conn.close();
                }
                catch (SQLException e)
                {
                }
            }
        }
    }

    @Override
    public List<Person> findAll()
    {
        String selectAllSql = "SELECT * FROM PERSON";
        Connection conn = null;
        try
        {
            Person person = null;
            List<Person> personList = new ArrayList<>();
            conn = dataSource.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(selectAllSql);

            if (rs.next())
            {
                person = new Person(
                        rs.getLong("ID"),
                        rs.getString("NAME")
                );
                System.out.println("customer:" + person.toString());
                personList.add(person);
            }
            rs.close();
            st.close();
            return personList;
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        finally
        {
            if (conn != null)
            {
                try
                {
                    conn.close();
                }
                catch (SQLException e)
                {
                }
            }
        }

    }

}
