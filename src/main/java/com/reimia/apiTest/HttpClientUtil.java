package com.reimia.apiTest;

import lombok.SneakyThrows;
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


public class HttpClientUtil {

    @SneakyThrows
    public static String gettesthttpclient(MultipartFile file, String url) {
        System.out.println(url);
        CloseableHttpClient httpclient = HttpClients.createDefault();
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(10000)
                .setConnectTimeout(5000)
                .build();
        HttpPost httpPost = new HttpPost(url);
        MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create();
        // 解决中文文件名乱码问题
        entityBuilder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        entityBuilder.setCharset(Consts.UTF_8);
        ContentType contentType = ContentType.create(ContentType.TEXT_PLAIN.getMimeType(), Consts.UTF_8);
        entityBuilder.addBinaryBody("source", file.getInputStream(), ContentType.DEFAULT_BINARY, file.getOriginalFilename());
        httpPost.setEntity(entityBuilder.build());
        httpPost.setConfig(requestConfig);
        HttpResponse execute = httpclient.execute(httpPost);
        String flag = EntityUtils.toString(execute.getEntity());
        return flag;
    }

}
