package com.reimia.fanshe;

import java.util.ArrayList;
import java.util.List;

public class ReflectDispatcher {

    public static void main(String[] args) {

        Class<?> clazz;
        List<String> list = new ArrayList<>();
        try {
            List<String> stringList = new ArrayList<>();
            String s1 = "com.reimia.fanshe.ReflectShiXian";
            String s2 = "com.reimia.fanshe.ReflectShiXian2";
            stringList.add(s1);
            stringList.add(s2);
            for (String l : stringList) {
                clazz = Class.forName(l);
                ReflectProcessor o = (ReflectProcessor) clazz.newInstance();
                List<String> test = o.test(l);
                list.addAll(test);
            }
            System.out.println(list);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
