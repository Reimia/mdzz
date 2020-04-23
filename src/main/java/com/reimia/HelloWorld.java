package com.reimia;

import com.alibaba.fastjson.JSONObject;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.UUID;

public class HelloWorld {
    public static void main(String[] args) {
        JSONObject jsonObject = JSONObject.parseObject(null);
        System.out.println(jsonObject);
        System.out.println(Charset.defaultCharset());
        System.out.println(System.getProperty("user.dir"));
        System.out.println("Hello World");
        System.out.println("中文1");
        System.out.println(UUID.randomUUID().toString().toUpperCase().replace("-",""));

        String s = "aaaaavvvvbbbbb";
        String[] split = s.split("");

    }
}
