/*
 * Copyright (c) Vertex Business Services.
 * All rights reserved.
 * 
 * No parts of this source code can be reproduced without written consent from
 * Vertex Business Services.
 */
package com.farkalit.spring.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

/**
 *
 * @author 72010995
 */
public class JdbcCustomerDAO implements CustomerDAO
{

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(Customer customer)
    {
        String sql = "INSERT INTO CUSTOMER "
                + "(CUSTID, NAME, AGE) VALUES (?, ?, ?)";
        Connection conn = null;

        try
        {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, customer.getCustId());
            ps.setString(2, customer.getName());
            ps.setInt(3, customer.getAge());
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
    public Customer findByCustomerId(int custId)
    {
        String sql = "SELECT * FROM CUSTOMER WHERE CUSTID = ?";

        Connection conn = null;

        try
        {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, custId);
            Customer customer = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                customer = new Customer(
                        rs.getInt("CUSTID"),
                        rs.getString("NAME"),
                        rs.getInt("Age")
                );
                System.out.println("customer:" + customer.toString());
            }
            rs.close();
            ps.close();
            return customer;
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
