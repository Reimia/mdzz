package com.reimia.futureTask;

import java.util.concurrent.FutureTask;

public class FutureTaskTest {

    public static void main(String[] args) {
        int arg1 = 1;
        int arg2 = 20;
        TestTask testTask = new TestTask(arg1, arg2);
        FutureTask<Object> futureTask = new FutureTask<>(testTask);
        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            System.out.println("\n"+futureTask.get());;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
