/*
 * Copyright (c) Vertex Business Services.
 * All rights reserved.
 * 
 * No parts of this source code can be reproduced without written consent from
 * Vertex Business Services.
 */
package com.farkalit.hazelcast.spring;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.IAtomicLong;
import com.hazelcast.core.IAtomicReference;
import com.hazelcast.core.ICountDownLatch;
import com.hazelcast.core.IExecutorService;
import com.hazelcast.core.IList;
import com.hazelcast.core.ILock;
import com.hazelcast.core.IMap;
import com.hazelcast.core.IQueue;
import com.hazelcast.core.ISemaphore;
import com.hazelcast.core.ISet;
import com.hazelcast.core.ITopic;
import com.hazelcast.core.IdGenerator;
import com.hazelcast.core.Message;
import com.hazelcast.core.MessageListener;
import com.hazelcast.core.MultiMap;
import com.hazelcast.core.ReplicatedMap;
import java.io.Serializable;
import java.util.Random;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 *
 * @author 72010995
 */
public class HazelcastDataTypes
{
    static Random rand = new Random();
    static ApplicationContext context = new GenericXmlApplicationContext("ApplicationContext.xml");
    static TestBean testBean = (TestBean) context.getBean("springTestBean");

    public static void main(String[] args)
    {
        System.out.println("Application context initilization: "+testBean.getResult());

        ExecuteMap();
        ExecuteMultiMap();
        //ExecuteReplicatedMap();
        ExecuteQueue();
        ExecuteTopic();
        ExecuteSet();
        ExecuteList();
        ExecuteExecuterService();
        ExecuteIdGenerator();
        ExecuteAtomicLong();
        ExecuteAtomicReference();
        ExecuteCountDownLatch();
        ExecuteSemaphore();
        ExecuteLock();

        Hazelcast.shutdownAll();
        HazelcastClient.shutdownAll();
    }

    public static void ExecuteMap()
    {
        System.out.println("\n### Map Execution Started... ###");
        int k = rand.nextInt(100);
        int v = rand.nextInt(100);
        IMap map = (IMap) context.getBean("map");
        map.put(k, v);
        System.out.println("A random pair is added to map.");
        System.out.println("Added value: " + map.get(k) + "\n");
    }

    public static void ExecuteMultiMap()
    {
        System.out.println("### MultiMap Execution Started... ###");
        int k = rand.nextInt(100);
        int v = rand.nextInt(100);
        MultiMap<Integer, Integer> multimap = (MultiMap) context.getBean("multiMap");
        multimap.put(k, v);
        System.out.println("A random pair is added to multiMap.");
        System.out.println("Added value: " + multimap.get(k) + "\n");
    }

    public static void ExecuteReplicatedMap()
    {
        System.out.println("### ReplicatedMap Execution Started... ###");
        int k = rand.nextInt(100);
        int v = rand.nextInt(100);
        ReplicatedMap<Integer, Integer> replicatedMap = (ReplicatedMap<Integer, Integer>) context.getBean("replicatedMap");
        replicatedMap.put(k, v);
        System.out.println("A random pair is added to replicatedMap.");
        System.out.println("Added value: " + replicatedMap.get(k) + "\n");
    }

    public static void ExecuteQueue()
    {
        System.out.println("### Queue Execution Started... ###");
        int k = rand.nextInt(100);
        IQueue queue = (IQueue) context.getBean("queue");
        queue.add(k);
        System.out.println("A random integer is added to queue.");
        System.out.println("Added element: " + queue.poll() + "\n");
    }

    public static void ExecuteTopic()
    {
        System.out.println("### Topic Execution Started... ###");
        ITopic topic = (ITopic) context.getBean("topic");
        topic.addMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                System.out.println("Topic Received Message: " + message + "\n");
            }
        });
        topic.publish("object");
    }

    public static void ExecuteSet()
    {
        System.out.println("### Set Execution Started... ###");
        int k = rand.nextInt(100);
        ISet set = (ISet) context.getBean("set");
        set.add(k);
        System.out.println("A random integer is added to set.");
        System.out.println("Added element: " + set.iterator().next() + "\n");
    }

    public static void ExecuteList()
    {
        System.out.println("### List Execution Started... ###");
        int k = rand.nextInt(100);
        IList<Integer> list = (IList<Integer>) context.getBean("list");
        list.add(k);
        System.out.println("A random integer is added to list.");
        System.out.println("Added element: " + list.iterator().next() + "\n");
    }

    public static void ExecuteExecuterService()
    {
        System.out.println("### ExecuterService Execution Started... ###");
        IExecutorService executorService = (IExecutorService) context.getBean("executorService");
        executorService.execute(new EchoTask("hello"));
        executorService.shutdown();
        System.out.println();
    }

    public static void ExecuteIdGenerator()
    {
        System.out.println("### IdGenerator Execution Started... ###");
        IdGenerator idgenerator = (IdGenerator) context.getBean("idGenerator");
        idgenerator.init(100L);
        System.out.println("IdGenerator is initialized with 100.");
        System.out.println("NewId: " + idgenerator.newId() + "\n");
    }

    public static void ExecuteAtomicLong()
    {
        System.out.println("### AtomicLong Execution Started... ###");
        IAtomicLong atomicLong = (IAtomicLong) context.getBean("atomicLong");
        atomicLong.set(100L);
        System.out.println("AtomicLong is set to 100.");
        System.out.println("AtomicLong: " + atomicLong.get() + "\n");
    }

    public static void ExecuteAtomicReference()
    {
        System.out.println("### AtomicReference Execution Started... ###");
        IAtomicReference atomicReference = (IAtomicReference) context.getBean("atomicReference");
        atomicReference.set("Executing AtomicReference");
        System.out.println(atomicReference.get() + "\n");
    }

    public static void ExecuteCountDownLatch()
    {
        System.out.println("### CountDownLatch Execution Started... ###");
        ICountDownLatch countDownLatch = (ICountDownLatch) context.getBean("countDownLatch");
        countDownLatch.trySetCount(10);
        System.out.println("Count is set to 10.");
        countDownLatch.countDown();
        System.out.println("countDown() call...");
        System.out.println("CountDownLatch Count :" + countDownLatch.getCount() + "\n");
    }

    public static void ExecuteSemaphore()
    {
        System.out.println("### Semaphore Execution Started... ###");
        ISemaphore semaphore = (ISemaphore) context.getBean("semaphore");
        semaphore.init(5);
        System.out.println("Semaphore initialized with 5.");
        try { semaphore.acquire(); }
        catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("Semaphore acquired once.");
        System.out.println("Available semaphore permits: " + semaphore.availablePermits());
        semaphore.release();
        System.out.println("Semaphore released.");
        System.out.println("Available semaphore permits: " + semaphore.availablePermits() + "\n");
    }

    public static void ExecuteLock()
    {
        System.out.println("### Lock Execution Started... ###");
        ILock lock = (ILock) context.getBean("lock");
        lock.lock();
        System.out.println("lock() call...");
        System.out.println("is locked by current thread? :" + lock.isLockedByCurrentThread());
        lock.unlock();
        System.out.println("unlock() call...");
        System.out.println("is locked? :" + lock.isLocked());
    }

    private static class EchoTask implements Runnable, Serializable {
        private final String msg;

        public EchoTask( String msg ) {
            this.msg = msg;
        }

        @Override
        public void run() {
            System.out.println( "echo:" + msg );
        }
    }
}
