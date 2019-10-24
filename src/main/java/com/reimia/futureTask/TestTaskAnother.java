package com.reimia.futureTask;

public class TestTaskAnother implements Runnable {

    private String arg1;
    private String arg2;

    public TestTaskAnother(String arg1, String arg2) {
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    @Override
    public void run() {
        System.out.println(arg1+arg2);
    }
}
