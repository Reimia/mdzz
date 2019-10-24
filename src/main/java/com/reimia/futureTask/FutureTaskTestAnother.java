package com.reimia.futureTask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTaskTestAnother {

    public static void main(String[] args) {
        List<FutureTask<Object>> futureTasks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TestTask testTask = new TestTask(i, 20);
            futureTasks.add(new FutureTask<Object>(testTask));
        }

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (FutureTask<Object> futureTask :
                futureTasks) {
            executorService.submit(futureTask);
        }
        executorService.shutdown();

        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(futureTasks.get(i).get());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
