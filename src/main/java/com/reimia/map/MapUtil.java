package com.reimia.map;

import java.util.HashMap;
import java.util.Map;

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
            if (!keyExist){
                System.out.println("map1 不包含 map2");
            }
        }
    }
}
