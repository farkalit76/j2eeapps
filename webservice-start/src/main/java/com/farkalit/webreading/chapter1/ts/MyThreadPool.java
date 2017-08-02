/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.webreading.chapter1.ts;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * In Java, concurrency is achieved through multithreading. At issue, then, is
 * how to make the Endpoint publisher multithreaded. The JWS framework supports
 * Endpoint multithreading without forcing the programmer to work with
 * difficult, error-prone constructs such as the synchronized block or the wait
 * and notify method invocations.
 *
 * An Executor object is a nice alternative to Thread instances, as the Executor
 * provides high-level constructs for submitting and managing tasks that are to
 * be executed concurrently. The first step to making the Endpoint publisher
 * multithreaded is thus to create an Executor class such as the following very
 * basic one:
 *
 * @author fusman
 */
public class MyThreadPool extends ThreadPoolExecutor {

//    public MyThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue)
//    {
//        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
//    }

    private static final int pool_size = 10;
    private boolean is_paused;
    private ReentrantLock pause_lock = new ReentrantLock();
    private Condition unpaused  = pause_lock.newCondition();

    public MyThreadPool()
    {
        super(pool_size, // core pool size
                pool_size, // maximum pool size
                0L, // keep-alive time for idle thread
                TimeUnit.SECONDS, // time unit for  keep - alive setting 
                new LinkedBlockingQueue<Runnable>(pool_size)
        ); // work queue
    }
    // some overrides

    protected void beforeExecute(Thread t, Runnable r)
    {
        super.beforeExecute(t, r);
        pause_lock.lock();
        try
        {
            while (is_paused)
            {
                unpaused.await();
            }
        } catch (InterruptedException e)
        {
            t.interrupt();
        } finally
        {
            pause_lock.unlock();
        }
    }

    public void pause()
    {
        pause_lock.lock();
        try
        {
            is_paused = true;
        } finally
        {
            pause_lock.unlock();
        }
    }

    public void resume()
    {
        pause_lock.lock();
        try
        {
            is_paused = false;
            unpaused.signalAll();
        } finally
        {
            pause_lock.unlock();
        }
    }
}
