package com.reimia.java8test;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class StreamTest {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("123");
        Optional<String> any = list.stream().findAny();
    }
}
