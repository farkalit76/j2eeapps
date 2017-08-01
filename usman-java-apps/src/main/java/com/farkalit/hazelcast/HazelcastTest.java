/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.hazelcast;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IdGenerator;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author 72010995
 */
public class HazelcastTest {

    public static void main(String[] args) {
        HazelcastInstance instance = Hazelcast.newHazelcastInstance();
        HazelcastInstance instance2 = Hazelcast.newHazelcastInstance();

        Map map = instance.getMap("a");
        IdGenerator gen = instance.getIdGenerator("gen");
        for (int i = 0; i < 10; i++) {
            long number = gen.newId();
            System.out.println(" gen number:"+number);
            map.put(number, "stuff " + i);
        }

        Map<Long, String> map2;
        map2 = instance2.getMap("a");

        for(Map.Entry<Long, String>  entry : map2.entrySet()) {
            System.out.printf("entry: %d; %s\n", entry.getKey(), entry.getValue());
        }

        Iterator it = map2.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            System.out.println("Map2 (key- values) :: ("+ pair.getKey() + " = " + pair.getValue()+")");
        }
        System.exit(0);
    }
}
