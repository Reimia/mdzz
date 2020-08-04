package com.reimia.map;

import org.junit.Test;

import java.util.*;

public class MapUtil {

    public static void main(String[] args) {
        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        Map<String, String> mapA = new HashMap<>();
        map1.put("a", "b");
        map1.put("b", "d");
        map1.put("e", "r");

        map2.put("a", "c");

        for (Map.Entry<String, String> entry : map1.entrySet()) {
            String map1Key = entry.getKey();
            String map1Value = entry.getValue();
            String map1KeyVal = map1Key + ":" + map1Value;
            String map1ValKey = map1Value + ":" + map1Key;
            mapA.put(map1KeyVal, map1ValKey);
        }

        // 判断map1是否包含map2
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            String map2Key = entry.getKey();
            String map2Value = entry.getValue();
            String map2KeyVal = map2Key + ":" + map2Value;
            boolean keyExist = mapA.containsKey(map2KeyVal);
            boolean valExist = mapA.containsValue(map2KeyVal);
            if (!keyExist) {
                System.out.println("map1 不包含 map2");
            }
        }
    }

    @Test
    public void test() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if ("1".equals(item)) {
                iterator.remove();
            }
        }

        for (String item : list) {
            if ("2".equals(item)) {
                list.remove(item);
            }
        }

        System.out.println(list);
    }

    @Test
    public void test2() {
        Map<String, String> map1 = new HashMap<>();
        map1.put("111", "111");

        Map<String, String> map2 = new HashMap<>();
        map1.put("111", "112");
        map1.put("112", "113");

        Map<String, String> map3 = new HashMap<>();
        map3.putAll(map1);
        map3.putAll(map2);

        System.out.println(1);
    }

    /**
     * 翻转一个long类型数字。例如输入123456L，输出654321L
     */
    @Test
    public void test3() {
        Long l = 1234567891111111119L;
        String s = String.valueOf(l);
        StringBuffer s1 =new StringBuffer();
        for (int i = s.length(); i >0; i--) {
           s1.append(s.charAt(i-1));
        }
        Long l1 = Long.parseLong(String.valueOf(s1));
        System.out.println(l1);
    }
}
