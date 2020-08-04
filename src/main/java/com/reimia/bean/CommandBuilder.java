package com.reimia.bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import junit.framework.TestCase;
import org.junit.Test;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class CommandBuilder {

    public Request buildRequest() {
        Request request = new Request();

        //header
        Request.RequestHeader requestHeader = request.new RequestHeader();
        requestHeader.setAppKey("0123456789abcdef");
        requestHeader.setAppSecret("0123456789abcdef");
        requestHeader.setRequestId(UUID.randomUUID().toString());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        requestHeader.setTimestamp(df.format(new Date()));
        requestHeader.setVersion("2.0");

        Request.RequestBody requestBody = request.new RequestBody();
        //body.config
        JSONObject requestConfig = new JSONObject();
        requestConfig.put("config1", "123456");
        requestConfig.put("config2", "abcdef");

        //body.data
        JSONObject requestData = new JSONObject();
        String data = "{ \n" +
                "    \"bucketCode\": \"B001\",\n" +
                " \n" +
                "    \"checkCode\": 0,\n" +
                " \n" +
                "    \"endPoint\": \"P234\",\n" +
                " \n" +
                "    \"jobPriority\": 1,\n" +
                " \n" +
                "    \"jobPriorityType\": 0,\n" +
                " \n" +
                "    \"letDownFlag\": \"online\",\n" +
                " \n" +
                "    \"robotJobId\": \"jobId001\", \n" +
                "    \"transportEntityType\": \"BUCKET\", \n" +
                "\"warehouseId\": 9001, \n" +
                "    \"workFace\": 1,\n" +
                " \n" +
                "    \"zoneCode\": \"Z01\"\n" +
                " \n" +
                "} ";
        JSONObject jsonObject = JSONObject.parseObject(data);

        requestData.putAll(jsonObject);

        requestBody.setConfig(requestConfig);
        requestBody.setData(requestData);
        request.setBody(requestBody);
        request.setHeader(requestHeader);
        return request;
    }

    public Response parseResponse(String response) {
        return JSONObject.parseObject(response, Response.class);
    }

    @Test
    public void testOut() {
        Request request = buildRequest();
        TestCase.assertNotNull(request);
        System.out.println(JSON.toJSONString(request));
    }

    @Test
    public void testParse() {
        String response = "{\n" +
                "    \"body\": {\n" +
                "        \"robotJobId\": \"jobId001\",\n" +
                "        \"success\": true,\n" +
                "        \"errorCode\": \"SUCCESS\",\n" +
                "        \"message\": \"业务请求处理成功\"\n" +
                "    },\n" +
                "    \"header\": {\n" +
                "        \"requestId\": \"0873ee5f-35ab-4c49-9baa-36c36b1353d8\",\n" +
                "        \"timestamp\": \"2020-05-15 14:54:28\",\n" +
                "        \"version\": \"2.0\"\n" +
                "    }\n" +
                "}";
        Response responseObj = parseResponse(response);
        TestCase.assertNotNull(responseObj);
        System.out.println(JSON.toJSONString(responseObj));
    }
}
