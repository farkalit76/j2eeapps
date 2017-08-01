/*
 * Copyright (c) Vertex Business Services.
 * All rights reserved.
 * 
 * No parts of this source code can be reproduced without written consent from
 * Vertex Business Services.
 */
package com.farkalit.hazelcast;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.Member;

/**
 *
 * @author 72010995
 */
public class HazelcastInstanceTest
{

    private final HazelcastInstance hazelcast;

    private HazelcastInstanceTest(HazelcastInstance value)
    {
        this.hazelcast = value;
    }

    public void getStatus()
    {

        System.out.println("Application Cluster");

        for (Member clusterMember : hazelcast.getCluster().getMembers())
        {
            StringBuilder nameBuilder = new StringBuilder(clusterMember.getSocketAddress().getHostString());
            if (clusterMember.localMember())
            {
                nameBuilder.append(" - Local");
            }
            System.out.println(nameBuilder.toString());

        }

    }

    public static void main(String[] args)
    {
        final HazelcastInstance instance = Hazelcast.newHazelcastInstance();
         System.out.println("instance:"+instance);
        HazelcastInstanceTest test = new HazelcastInstanceTest(instance);
        test.getStatus();
        
    }
}
