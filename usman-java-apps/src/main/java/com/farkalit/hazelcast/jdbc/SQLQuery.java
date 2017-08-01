/*
 * Copyright (c) Vertex Business Services.
 * All rights reserved.
 * 
 * No parts of this source code can be reproduced without written consent from
 * Vertex Business Services.
 */
package com.farkalit.hazelcast.jdbc;

/**
 *
 * @author 72010995
 */
public interface SQLQuery
{

    String INSERT_QUERY = "INSERT INTO hazel_db(map_key,map_value) values(?,?)";
    String UPDATE_QUERY = "UPDATE hazel_db SET map_value=? WHERE map_key=?";
    String SELECT_QUERY = "SELECT map_value FROM hazel_db WHERE map_key=?";
    String ALL_KEYS = "SELECT map_key FROM  hazel_db";
    String DELETE_KEY = "DELETE FROM hazel_db WHERE map_key=?";
}
