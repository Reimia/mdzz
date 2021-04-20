package com.reimia.apiTest;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class seTuCeShi {
    public static void main(String[] args) {
        //接口地址
        RestTemplate restTemplate = new RestTemplate();
        String requestUrl = "http://reimia.top:5555/api/1/upload?key=b81ef8996e03c12a55d39e216a082cd0";
        //params用于存储要请求的参数
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("key", "b81ef8996e03c12a55d39e216a082cd0");
        params.put("format", "json");
        params.put("source","https://i.loli.net/2021/04/16/Rz9FgctwadAKXHV.jpg");

        HttpComponentsClientHttpRequestFactory factory =
                new HttpComponentsClientHttpRequestFactory();
        HttpClient httpClient =
                HttpClientBuilder.create()
                        .setRedirectStrategy(new LaxRedirectStrategy())
                        .build();
        factory.setHttpClient(httpClient);
        restTemplate.setRequestFactory(factory);

        ResponseEntity<String> forEntity = restTemplate.postForEntity(requestUrl, params, String.class);
        System.out.println(forEntity.getBody());
    }
}
