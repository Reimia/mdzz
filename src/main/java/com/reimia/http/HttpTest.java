package com.reimia.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.junit.Test;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;


@Component
public class HttpTest {


    @Test
    public void connect() {
        RestTemplate restTemplate = new RestTemplate(new HttpsClientRequestFactory());

        HttpComponentsClientHttpRequestFactory factory =
                new HttpComponentsClientHttpRequestFactory();

        HttpClient httpClient =
                HttpClientBuilder.create()
                        .setRedirectStrategy(new LaxRedirectStrategy())
                        .build();

        factory.setHttpClient(httpClient);

        restTemplate.setRequestFactory(factory);

        String url = "https://api.lolicon.app/setu";
        String forObject = restTemplate.getForObject(url, String.class);
        JSONObject jsonObject = JSONObject.parseObject(forObject);
        JSONArray jsonArray = jsonObject.getJSONArray("data");
        Object o = jsonArray.get(0);
        JSONObject data = (JSONObject) JSON.toJSON(o);
        String string = data.getString("url");
        System.out.println(string);
        getNetUrlHttps(string);

    }


    public static File getNetUrlHttps(String fileUrl) {
        //对本地文件进行命名
        String file_name = UUID.randomUUID().toString();
        File file = null;

        DataInputStream in = null;
        DataOutputStream out = null;
        try {
            file = new File("D:\\[projects4me]\\mdzz\\src\\main\\resources\\img\\1.jpg");
//            file = File.createTempFile("net_url", file_name);

            System.setProperty("https.protocols", "TLSv1.2");
            SSLContext sslcontext = SSLContext.getInstance("TLSv1.2");
            sslcontext.init(null, null, null);
            SSLContext.setDefault(sslcontext);

            URL url = new URL(fileUrl);
            HostnameVerifier ignoreHostnameVerifier = new HostnameVerifier() {
                @Override
                public boolean verify(String s, SSLSession sslsession) {
                    System.out.println("WARNING: Hostname is not matched for cert.");
                    return true;
                }
            };
            HttpsURLConnection.setDefaultHostnameVerifier(ignoreHostnameVerifier);
            HttpsURLConnection.setDefaultSSLSocketFactory(sslcontext.getSocketFactory());
            HttpsURLConnection urlCon = (HttpsURLConnection) url.openConnection();
            urlCon.setConnectTimeout(6000);
            urlCon.setReadTimeout(6000);
            int code = urlCon.getResponseCode();
            if (code != HttpURLConnection.HTTP_OK) {
                throw new Exception("文件读取失败");
            }
            // 读文件流
            in = new DataInputStream(urlCon.getInputStream());
            out = new DataOutputStream(new FileOutputStream(file));
            byte[] buffer = new byte[2048];
            int count = 0;
            while ((count = in.read(buffer)) > 0) {
                out.write(buffer, 0, count);
            }
            out.close();
            in.close();
        } catch (Exception e) {
            System.out.println("远程图片获取错误："+fileUrl);
            e.printStackTrace();
        } finally {
            try {
                if (null != out) {
                    out.close();
                }
                if (null != in) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        return file;
    }

}
