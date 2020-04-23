package com.reimia.socketTest.response;

import com.alibaba.fastjson.JSONObject;

public class BuildResponse {

    public static String generate() {
        AllotmentLineResponse allotmentLineResponse = new AllotmentLineResponse();
        AllotmentLineResponse.Response response = allotmentLineResponse.new Response();
        AllotmentLineResponse.Response.Header header =response.new Header();
        response.setHeader(header);
        allotmentLineResponse.setResponse(response);
        String s = JSONObject.toJSONString(allotmentLineResponse);
        return s;
    }

}
