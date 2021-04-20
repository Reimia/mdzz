package com.reimia.apiTest;

import com.alibaba.fastjson.JSON;
import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class CheveretoSender {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("D:\\1.png");
        CloseableHttpClient httpclient = HttpClients.createDefault();
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(10000)
                .setConnectTimeout(5000)
                .build();
        HttpPost httpPost = new HttpPost(CheveretoUtil.CHEVERETO_URL + "?key=" + CheveretoUtil.CHEVERETO_API_KEY + "&format=json");
        MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create();
        // 解决中文文件名乱码问题
        entityBuilder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        entityBuilder.setCharset(Consts.UTF_8);
        entityBuilder.addBinaryBody("source", fileInputStream, ContentType.DEFAULT_BINARY,"1.png");
        httpPost.setEntity(entityBuilder.build());
        httpPost.setConfig(requestConfig);
        HttpResponse execute = httpclient.execute(httpPost);
        String flag = EntityUtils.toString(execute.getEntity());
        System.out.println(JSON.parseObject(flag));
    }
}
