/*
 * Copyright (c) Vertex Business Services.
 * All rights reserved.
 * 
 * No parts of this source code can be reproduced without written consent from
 * Vertex Business Services.
 */
package com.farkalit.hazelcast.jdbc;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MapStoreConfig;
import com.hazelcast.config.XmlConfigBuilder;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.core.MapStore;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 *
 * @author 72010995
 */
public class PersonLoadAll
{

    public static void main(String[] args)
    {
        final int numberOfEntriesToAdd = 3;
        final String mapName = PersonLoadAll.class.getCanonicalName();
        System.out.println("mapName:"+mapName);
        final Config config = createNewConfig(mapName);
        final HazelcastInstance node = Hazelcast.newHazelcastInstance(config);

        final IMap<Integer, Integer> map = node.getMap(mapName);

        populateMap(map, numberOfEntriesToAdd);

        System.out.printf("# Map store has %d elements\n", numberOfEntriesToAdd);

        map.evictAll();

        System.out.printf("# After evictAll map size\t: %d\n", map.size());

        map.loadAll(true);

        System.out.printf("# After loadAll map size\t: %d\n", map.size());
    }

    private static void populateMap(IMap<Integer, Integer> map, int itemCount)
    {
        for (int i = 0; i < itemCount; i++)
        {
            map.put(i, i);
        }
    }

    private static Config createNewConfig(String mapName)
    {
        final SimpleStore simpleStore = new SimpleStore();
        XmlConfigBuilder configBuilder = new XmlConfigBuilder();
        Config config = configBuilder.build();
        MapConfig mapConfig = config.getMapConfig(mapName);
        MapStoreConfig mapStoreConfig = new MapStoreConfig();
        mapStoreConfig.setImplementation(simpleStore);
        mapStoreConfig.setWriteDelaySeconds(0);
        mapConfig.setMapStoreConfig(mapStoreConfig);
        return config;
    }

    private static class SimpleStore implements MapStore
    {

        private ConcurrentMap store = new ConcurrentHashMap();

        @Override
        public void store(Object key, Object value)
        {
            store.put(key, value);
        }

        @Override
        public void storeAll(Map map)
        {
            final Set<Map.Entry> entrySet = map.entrySet();
            for (Map.Entry entry : entrySet)
            {
                final Object key = entry.getKey();
                final Object value = entry.getValue();
                store(key, value);
            }

        }

        @Override
        public void delete(Object key)
        {

        }

        @Override
        public void deleteAll(Collection keys)
        {

        }

        @Override
        public Object load(Object key)
        {
            return store.get(key);
        }

        @Override
        public Map loadAll(Collection keys)
        {
            final Map map = new HashMap();
            for (Object key : keys)
            {
                final Object value = load(key);
                map.put(key, value);
            }
            return map;
        }

        @Override
        public Set loadAllKeys()
        {
            return store.keySet();
        }
    }
}
