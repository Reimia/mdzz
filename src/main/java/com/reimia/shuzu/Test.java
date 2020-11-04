package com.reimia.shuzu;

import com.alibaba.fastjson.JSONArray;

public class Test {
    public static void main(String[] args) {
        JSONArray passBoxInfoArray = new JSONArray();
        passBoxInfoArray.add("111");
        passBoxInfoArray.add("222");
        System.out.println(passBoxInfoArray.size());
        passBoxInfoArray.remove(0);
        System.out.println(passBoxInfoArray.size());
        String s = "A00001111 箱子";
        System.out.println(s.substring(0,9));
    }
}
