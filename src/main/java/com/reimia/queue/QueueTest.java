package com.reimia.queue;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;

public class QueueTest implements Serializable {

    private static Queue<String> leftBoxQueue = new LinkedList<>();
    private static Queue<String> rightBoxQueue = new LinkedList<>();

    public static void addLeftBox(String boxNo){
        leftBoxQueue.offer(boxNo);
    }

    public static String removeLeftBox(){
        return leftBoxQueue.poll();
    }

    public static String getLeftBox(){
        return leftBoxQueue.peek();
    }

    public static void addRightBox(String boxNo){

    }

    public static void clearAllBox(){
        leftBoxQueue.clear();
        rightBoxQueue.clear();
    }

    public static Queue<String> getLeftBoxQueue() {
        return leftBoxQueue;
    }

    public static void setLeftBoxQueue(Queue<String> leftBoxQueue) {
        QueueTest.leftBoxQueue = leftBoxQueue;
    }

    public static Queue<String> getRightBoxQueue() {
        return rightBoxQueue;
    }

    public static void setRightBoxQueue(Queue<String> rightBoxQueue) {
        QueueTest.rightBoxQueue = rightBoxQueue;
    }
}
