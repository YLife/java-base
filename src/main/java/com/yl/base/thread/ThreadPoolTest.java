package com.yl.base.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

    private static ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
    private static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
    private static ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
    private static ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);

    public static void testCachedThreadPool() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            final int index = i;
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("第" + index + "个线程：" + Thread.currentThread().getName());
                }
            });
        }
    }

    public static void testNewFiexedThreadPool() {
        for (int i = 0; i < 10; i++) {
            final int index = i;
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("第" + index + "线程：" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public static void testSingleThreadPool() {
        for (int i = 0; i < 10; i++) {
            final int index = i;
            singleThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("第" + index + "个线程：" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public static void testScheduledThreadPool(boolean isDelay) {
        if (isDelay) {
            scheduledThreadPool.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            }, 3, TimeUnit.SECONDS);
        } else {
            scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            }, 1, 3, TimeUnit.SECONDS);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Test cachedThread...");
        ThreadPoolTest.testCachedThreadPool();
        System.out.println("Test fixedThreadPool...");
        //ThreadPoolTest.testNewFiexedThreadPool();
        System.out.println("Test singleThreadPool...");
        //ThreadPoolTest.testSingleThreadPool();
        System.out.println("Test scheduledThreadPool...");
        //ThreadPoolTest.testScheduledThreadPool(false);
    }
}
