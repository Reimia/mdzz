package com.reimia.vmsTest;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class restTest {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("aaa", "aaa");
        jsonObject.put("bbb", "bbb");
        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity("http://192.168.69.72:8080/open-api/ucp/sorting/qryBoxId", jsonObject, String.class);
        JSONObject responseBody = JSONObject.parseObject(stringResponseEntity.getBody());
        System.out.println(responseBody);
        String boxId = (String) responseBody.get("boxId");
        System.out.println(boxId != null);
    }
}
