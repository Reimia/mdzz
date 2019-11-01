package com.reimia;

import java.nio.charset.Charset;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println(Charset.defaultCharset());
        System.out.println(System.getProperty("user.dir"));
        System.out.println("Hello World");
    }
}
