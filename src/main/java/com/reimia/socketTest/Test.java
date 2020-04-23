package com.reimia.socketTest;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.client.RestTemplate;

public class Test {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("aaa","aaa");
        jsonObject.put("bbb","bbb");
        restTemplate.postForEntity("http://127.0.0.1:8083/mdzz",jsonObject,JSONObject.class);
    }
}
