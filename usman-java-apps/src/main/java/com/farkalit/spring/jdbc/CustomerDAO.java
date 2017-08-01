/*
 * Copyright (c) Vertex Business Services.
 * All rights reserved.
 * 
 * No parts of this source code can be reproduced without written consent from
 * Vertex Business Services.
 */
package com.farkalit.spring.jdbc;

/**
 *
 * @author 72010995
 */
public interface CustomerDAO
{

    public void insert(Customer customer);

    public Customer findByCustomerId(int custId);

}
