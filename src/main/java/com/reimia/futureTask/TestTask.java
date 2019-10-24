package com.reimia.futureTask;

import java.util.concurrent.Callable;

public class TestTask implements Callable<Object> {
    private int arg1;
    private int arg2;

    public TestTask(int arg1, int arg2) {
        this.arg1 = arg1;
        this.arg2 = arg2;
    }


    @Override
    public Object call() throws Exception {
        int result = arg2-arg1;
        System.out.println("\n"+"my arg1 is:["+arg1+"],my arg2 is:["+arg2+"],currentTimeMillis is:["+System.currentTimeMillis()+"]");
        while (arg1<arg2){
            System.out.print(arg1+" ");
            arg1++;
        }
        return result;
    }
}
