package com.reimia.socketTest;

import com.alibaba.fastjson.JSONObject;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestTempleteTest {
    public static void main(String[] args) {
//        JSONObject request = new JSONObject();
//        request.put("deviceType", "Scara机械手");
//        request.put("deviceId", "test");
//        request.put("deviceMsg", "test");
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity("http://127.0.0.1:8080/open-api/ucp/sorting/deviceBroken", request, String.class);
//        System.out.println(1);
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(new LettuceConnectionFactory());
        StringRedisSerializer serializer = new StringRedisSerializer();
        redisTemplate.setDefaultSerializer(serializer);
        redisTemplate.setKeySerializer(serializer);
        redisTemplate.setValueSerializer(serializer);
        redisTemplate.afterPropertiesSet();
        Object o = redisTemplate.opsForValue().get("sorting:pack:start:flag");
        System.out.println(1);
    }

}
