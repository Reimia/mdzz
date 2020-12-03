package com.reimia.chijiuhua;

import java.io.Serializable;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Reimia
 */
public class AllotmentBoxQueue implements Serializable {

	private static Deque<String> leftBoxQueue = new LinkedList<>();
	private static Deque<String> rightBoxQueue = new LinkedList<>();

	public static boolean addLeftBox(String boxNo) {
		return leftBoxQueue.offer(boxNo);
	}

	public static String removeLeftBox() {
		return leftBoxQueue.poll();
	}

	public static String getLeftBox() {
		return leftBoxQueue.peek();
	}

	public static boolean addRightBox(String boxNo) {
		return rightBoxQueue.offer(boxNo);
	}

	public static String removeRightBox() {
		return rightBoxQueue.poll();
	}

	public static String getRightBox() {
		return rightBoxQueue.peek();
	}

	public static void clearAllBox() {
		leftBoxQueue.clear();
		rightBoxQueue.clear();
	}

	public static Deque<String> getLeftBoxQueue() {
		return leftBoxQueue;
	}

	public static void setLeftBoxQueue(Deque<String> leftBoxQueue) {
		AllotmentBoxQueue.leftBoxQueue = leftBoxQueue;
	}

	public static Deque<String> getRightBoxQueue() {
		return rightBoxQueue;
	}

	public static void setRightBoxQueue(Deque<String> rightBoxQueue) {
		AllotmentBoxQueue.rightBoxQueue = rightBoxQueue;
	}
}
