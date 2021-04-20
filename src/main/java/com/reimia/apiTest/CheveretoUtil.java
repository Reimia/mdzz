package com.reimia.apiTest;

import org.springframework.web.multipart.MultipartFile;

public class CheveretoUtil {
    //文件上传URL
    public static final String CHEVERETO_URL = "http://reimia.top:5555/api/1/upload/";
    //Chevereto API Key
    public static final String CHEVERETO_API_KEY = "b81ef8996e03c12a55d39e216a082cd0";


    public static String upload(MultipartFile file) throws Exception {
        String jsonObject = null;
        try {
            jsonObject = HttpClientUtil.gettesthttpclient(file, CheveretoUtil.CHEVERETO_URL + "?key=" + CHEVERETO_API_KEY + "&format=json");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(jsonObject);
        return jsonObject;
    }

}
