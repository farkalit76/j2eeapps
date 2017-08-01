/*
 * Copyright (c) Vertex Business Services.
 * All rights reserved.
 * 
 * No parts of this source code can be reproduced without written consent from
 * Vertex Business Services.
 */
package com.farkalit.hazelcast.jdbc.util;

import java.util.Iterator;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.engine.HibernateIterator;


/**
 *
 * @author 72010995
 */
public class QueryIterable<T> implements Iterable<T>
{
    private Query query;

    public QueryIterable(Query query) {
        this.query = query;
    }

    @Override
    public Iterator<T> iterator() {
        return new CloseableIterator<T>( (HibernateIterator) query.iterate() );
    }
    
  
}
