package com.reimia.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Reimia
 */
public class ScheduledExecutorTest {
    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            try {
                System.out.println("这是"+i);
                i.getAndIncrement();
                if (i.get() >20){
                    throw new Exception("i>20");
                }
            } catch (Exception e) {
                scheduledExecutorService.shutdown();
            }
        }, 1, 1, TimeUnit.SECONDS);
    }

}
