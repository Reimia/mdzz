package com.reimia.java8test;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import java.util.Objects;
import java.util.TreeMap;

public class Java8Test {
    public static void main(String[] args) {
        String json = "{\n" +
                "    \"sku\": [\n" +
                "        {\n" +
                "            \"propertyKey\": \"000002\",\n" +
                "            \"propertyName\": \"类型\",\n" +
                "            \"propertyValue\": \"完整券\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"propertyKey\": \"000005\",\n" +
                "            \"propertyName\": \"券别\",\n" +
                "            \"propertyValue\": [\n" +
                "                \"100元\",\n" +
                "                \"50元\",\n" +
                "                \"20元\",\n" +
                "                \"10元\",\n" +
                "                \"5元\"\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"propertyKey\": \"000002\",\n" +
                "            \"propertyName\": \"类型\",\n" +
                "            \"propertyValue\": \"残损券\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"propertyKey\": \"000005\",\n" +
                "            \"propertyName\": \"券别\",\n" +
                "            \"propertyValue\": [\n" +
                "                \"100元\",\n" +
                "                \"50元\",\n" +
                "                \"20元\"\n" +
                "            ]\n" +
                "        }\n" +
                "    ]\n" +
                "}";


        Gson gson = new Gson();
        Object treeMap = gson.fromJson(json, Object.class);
        System.out.println(treeMap);


        String json1 = "{\n" +
                "    \"sku\": [\n" +
                "        {\n" +
                "            \"propertyKey\": \"000002\",\n" +
                "            \"propertyName\": \"类型\",\n" +
                "            \"propertyValue\": \"完整券\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"propertyKey\": \"000005\",\n" +
                "            \"propertyName\": \"券别\",\n" +
                "            \"propertyValue\": \"100元\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        String json2 = "{\n" +
                "    \"sku\": [\n" +
                "        {\n" +
                "            \"propertyKey\": \"000005\",\n" +
                "            \"propertyName\": \"券别\",\n" +
                "            \"propertyValue\": \"100元\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"propertyKey\": \"000002\",\n" +
                "            \"propertyName\": \"类型\",\n" +
                "            \"propertyValue\": \"完整券\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";


        LinkedTreeMap o1 = gson.fromJson(json1, LinkedTreeMap.class);

        String s1 = gson.toJson(o1);
        Object o2 = gson.fromJson(json2, Object.class);
        String s2 = gson.toJson(o2);
        System.out.println(Objects.equals(s1, s2));
    }
}
