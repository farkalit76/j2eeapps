/*
 * Copyright (c) Vertex Business Services.
 * All rights reserved.
 * 
 * No parts of this source code can be reproduced without written consent from
 * Vertex Business Services.
 */
package com.farkalit.util;

import java.nio.ByteBuffer;
import java.rmi.server.UID;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @author 72010995
 */
public class AtomicIdCounter
{

    private static AtomicLong counter = new AtomicLong(999990);

    public static long nextId()
    {
        return counter.incrementAndGet();
    }

    public static String nextUID()
    {
        return new UID().toString();
    }

    public static String randomID()
    {

        char[] chars = "abcdefghijklmnopqrstuvwxyzABSDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
        Random r = new Random(System.currentTimeMillis());
        char[] id = new char[8];
        for (int i = 0; i < 8; i++)
        {
            id[i] = chars[r.nextInt(chars.length)];
        }
        return new String(id);

    }

    public static long current = System.currentTimeMillis();

    static public synchronized long getTimeId()
    {
        return current++;
    }

    public static String shortUUID()
    {
        int rand = (int) (Math.random() * 99) + 10;
        System.out.println("rand:" + rand);
        UUID uuid = UUID.randomUUID();
        int l = ByteBuffer.wrap(uuid.toString().getBytes()).getInt();
        return Integer.toString(l, Character.MAX_RADIX) + rand;
        //return temp + rand;
    }

    public static void main(String[] args)
    {
        System.out.println("nextId:" + nextId());
        System.out.println("nextUID:" + nextUID());
        System.out.println("randomID:" + randomID());
        System.out.println("getTimeId:" + getTimeId());
        System.out.println("shortUUID:" + shortUUID());
    }
}
