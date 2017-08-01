/*
 * Copyright (c) Vertex Business Services.
 * All rights reserved.
 * 
 * No parts of this source code can be reproduced without written consent from
 * Vertex Business Services.
 */
package com.farkalit.hazelcast.jdbc.util;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;

/**
 *
 * @author 72010995
 */
public class StatementIterable<T> implements Iterable<T>
{
    private PreparedStatement statement;

    public StatementIterable(PreparedStatement statement) {
        this.statement = statement;
    }

    @Override
    public Iterator<T> iterator() {
        try {
            return new ResultSetIterator<T>( statement.executeQuery() );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
