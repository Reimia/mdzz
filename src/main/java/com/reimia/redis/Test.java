package com.reimia.redis;

public class Test {
    public static void main(String[] args) {
        String s = "redis:123456";
        String[] split = s.split(":");
        System.out.println(split.length);
    }
}
