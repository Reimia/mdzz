package com.reimia.apiTest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class HttpPost {
    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param httpUrl
     *            发送请求的 URL
     * @param param
     *            请求参数是json
     * @return 所代表远程资源的响应结果
     */
    private static String doPost(String httpUrl, String param) {

        HttpURLConnection connection = null;
        InputStream is = null;
        OutputStream os = null;
        BufferedReader br = null;
        String result = null;
        try {
            URL url = new URL(httpUrl);
            // 通过远程url连接对象打开连接
            connection = (HttpURLConnection) url.openConnection();
            // 设置连接请求方式
            connection.setRequestMethod("POST");
            // 设置连接主机服务器超时时间：15000毫秒
            connection.setConnectTimeout(15000);
            // 设置读取主机服务器返回数据超时时间：60000毫秒
            connection.setReadTimeout(60000);

            // 默认值为：false，当向远程服务器传送数据/写数据时，需要设置为true
            connection.setDoOutput(true);
            // 默认值为：true，当前向远程服务读取数据时，设置为true，该参数可有可无
            connection.setDoInput(true);
            // 设置传入参数的格式:请求参数应该是 name1=value1&name2=value2 的形式。
            connection.setRequestProperty("Content-Type", "application/json");
            // 设置鉴权信息：Authorization: Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0
            // connection.setRequestProperty("Authorization", "Bearer
            // da3efcbf-0845-4fe3-8aba-ee040be542c0");
            // 通过连接对象获取一个输出流
            os = connection.getOutputStream();
            // 通过输出流对象将参数写出去/传输出去,它是通过字节数组写出的
            os.write(param.getBytes());
            // 通过连接对象获取一个输入流，向远程读取
            if (connection.getResponseCode() == 200) {

                is = connection.getInputStream();
                // 对输入流对象进行包装:charset根据工作项目组的要求来设置
                br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));

                StringBuilder sbf = new StringBuilder();
                String temp;
                // 循环遍历一行一行读取数据
                while ((temp = br.readLine()) != null) {
                    sbf.append(temp);
                    sbf.append("\r\n");
                }
                result = sbf.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != os) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // 断开与远程地址url的连接
            connection.disconnect();
        }
        return result;
    }

    public static class RobotApi {
        private static final String ROBOT_API_HOST = "http://openapi.tuling123.com/openapi/api/v2";
        private String key;
        private String userid;

        RobotApi(String key, String userid) {
            super();
            this.key = key;
            this.userid = userid;
        }

        private String buildParams(String Word) {
            String a = "{\"reqType\":0,\"perception\": {\"inputText\": {\"text\": \"";
            String b = "\"}},\"userInfo\": {\"apiKey\": \"";
            String c = "\",\"userId\": \"";
            String d = "\"}\r\n" + "}";
            return a + Word + b + key + c + userid + d;

        }

        String getRobotResult(String Word) {

            return HttpPost.doPost(ROBOT_API_HOST, buildParams(Word));
        }
    }

    public static class Main {
        private static final String apiKey = "自己的key";
        private static final String userId = "自己的id";

        public static void main(String[] args) {
            RobotApi api = new RobotApi(apiKey, userId);
            while (true) {

                Scanner input = new Scanner(System.in);

                String word = input.next();
                String backString = api.getRobotResult(word);

                JSONObject jsonobj = JSON.parseObject(backString);
                JSONArray result = jsonobj.getJSONArray("results");
                for (int i = 0; i < result.size(); i++) {
                    System.out.println(result.getJSONObject(0).getJSONObject("values").getString("text"));
                }
            }
        }

    }

}
