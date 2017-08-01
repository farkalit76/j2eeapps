/*
 * Copyright (c) Vertex Business Services.
 * All rights reserved.
 * 
 * No parts of this source code can be reproduced without written consent from
 * Vertex Business Services.
 */
package com.farkalit.hazelcast.jdbc.util;

import java.io.Closeable;
import java.io.IOException;
import java.util.Iterator;
import org.hibernate.engine.HibernateIterator;

/**
 *
 * @author 72010995
 */
public class CloseableIterator<T> implements Iterator<T>, Closeable
{
     private HibernateIterator iterator;

    public CloseableIterator(HibernateIterator iterator) {
        this.iterator = iterator;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @SuppressWarnings("unchecked")
    @Override
    public T next() {
        return (T) iterator.next();
    }

    @Override
    public void close() throws IOException {
        iterator.close();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
    
}
