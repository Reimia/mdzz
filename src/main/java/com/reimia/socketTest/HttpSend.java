package com.reimia.socketTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

public class HttpSend {
    private HttpSend() {
    }


    public static void main(String[] args) throws Exception {
        HttpSend httpSend = new HttpSend();
        httpSend.sendHttp();

    }

    private void sendHttp() throws Exception {
        StringBuffer str = new StringBuffer();
        HttpURLConnection conn;
        URL url = new URL("http://127.0.0.1:8080");
        conn = (HttpURLConnection) url.openConnection();
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setUseCaches(false);
        conn.setConnectTimeout(10000);
        conn.setReadTimeout(120000);
        conn.connect();

        System.out.println("mdzzzzzzzzzzzz");
        OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), StandardCharsets.UTF_8);
        out.write("{\n" +
                "    \"id\": \"mdzz\",\n" +
                "    \"msgType\": \"ceshi\",\n" +
                "    \"shelfCode\": \"00000081\",\n" +
                "    \"x\": 46,\n" +
                "    \"y\": 61\n" +
                "}");
        out.flush();
        out.close();

        if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {

            //读取返回的数据
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));

            String temp;

            while ((temp = in.readLine()) != null) {
                str.append(temp);
            }

            in.close();
        }
        System.out.println(str);

        conn.disconnect();

    }

}
