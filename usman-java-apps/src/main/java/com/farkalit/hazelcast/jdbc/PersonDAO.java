/*
 * Copyright (c) Vertex Business Services.
 * All rights reserved.
 * 
 * No parts of this source code can be reproduced without written consent from
 * Vertex Business Services.
 */
package com.farkalit.hazelcast.jdbc;

import java.util.List;

/**
 *
 * @author 72010995
 */
public interface PersonDAO
{
    public void insert(Person person);

    public Person findByPersonId(long personId);
    
    public List<Person> findAll();
}
