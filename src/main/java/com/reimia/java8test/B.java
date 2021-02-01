package com.reimia.java8test;

public class B extends A {
    public static void main(String[] args) {
        B.abc = 1;
        C.abc = 2;
        System.out.println(B.abc);
        System.out.println(A.abc);
    }
}
