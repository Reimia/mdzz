package com.reimia.convert2;

import com.alibaba.fastjson.JSONObject;

public class Test {

    public static void main(String[] args) {

        String s = "{\n" +
                "    \"code\": \"0\",\n" +
                "    \"msg\": \"Success.\",\n" +
                "    \"data\": {\n" +
                "        \"total\": 500,\n" +
                "        \"pageNo\": 1,\n" +
                "        \"pageSize\": 10,\n" +
                "        \"list\": [\n" +
                "            {\n" +
                "                \"similarity\": 80\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}";


        HikvisionDataResponse<Data> hikvisionPageResponse = (HikvisionDataResponse<Data>)JSONObject.parseObject(s, HikvisionDataResponse.class);

        System.out.println(1);

    }

}
