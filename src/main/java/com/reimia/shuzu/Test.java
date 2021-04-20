package com.reimia.shuzu;

import com.alibaba.fastjson.JSONArray;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
//        JSONArray passBoxInfoArray = new JSONArray();
//        passBoxInfoArray.add("111");
//        passBoxInfoArray.add("222");
//        System.out.println(passBoxInfoArray.size());
//        passBoxInfoArray.remove(0);
//        System.out.println(passBoxInfoArray.size());
//        String s = "A00001111 箱子";
//        System.out.println(s.substring(0,9));
//
//        MdzzDTO mdzzDTO = new MdzzDTO();
//        mdzzDTO.setMdzzChildDTOstring("111");

        List<Map<String,String>> maps = new ArrayList<>();
        maps.add(new HashMap<String, String>(1){{put("a","a");}});
        maps.add(new HashMap<String, String>(1){{put("b","a");}});
        maps.add(new HashMap<String, String>(1){{put("a","a");}});

        System.out.println(1);

    }

    private static boolean test(String a,String b){
        return true;
    }
}
