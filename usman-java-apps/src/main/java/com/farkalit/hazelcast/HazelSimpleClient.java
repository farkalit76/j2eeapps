/*
 * Copyright (c) Vertex Business Services.
 * All rights reserved.
 * 
 * No parts of this source code can be reproduced without written consent from
 * Vertex Business Services.
 */
package com.farkalit.hazelcast;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import java.util.concurrent.ConcurrentMap;

/**
 *
 * @author 72010995
 */
public class HazelSimpleClient
{
    public static void main(String[] args)
    {
        Config config = new Config("test");
        HazelcastInstance instance = Hazelcast.newHazelcastInstance(config);
        ConcurrentMap<String, String> map = instance.getMap("my-distributed-map");
        map.put("key", "value");
        map.get("key");
         
        //Concurrent Map methods
        map.putIfAbsent("somekey", "somevalue");
        map.replace("key", "value", "newvalue");
    }
}
