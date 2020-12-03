package com.reimia.queue;

public class QueueTestTest {
    public static void main(String[] args) {
        QueueTest.addLeftBox("12345");
        QueueTest.addLeftBox("56789");
        String leftBox = QueueTest.getLeftBox();
        String removeLeftBox = QueueTest.removeLeftBox();
        System.out.println(111);
    }
}
