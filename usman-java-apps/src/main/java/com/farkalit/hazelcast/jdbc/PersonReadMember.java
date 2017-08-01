/*
 * Copyright (c) Vertex Business Services.
 * All rights reserved.
 * 
 * No parts of this source code can be reproduced without written consent from
 * Vertex Business Services.
 */
package com.farkalit.hazelcast.jdbc;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

/**
 *
 * @author 72010995
 */
public class PersonReadMember
{

    public static void main(String[] args) //throws InterruptedException
    {
        try
        {

            HazelcastInstance hz = Hazelcast.newHazelcastInstance();
            IMap<Long, Person> personMap = hz.getMap("personMap");
            Person p = personMap.get(1L);
            System.out.println(p);
            hz.shutdown();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
