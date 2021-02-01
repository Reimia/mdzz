package com.reimia.socketTest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.UUID;

public class RmsHttpSend {
    private RmsHttpSend() {
    }


    public static void main(String[] args) throws Exception {
        RmsHttpSend rms = new RmsHttpSend();
        rms.removeBox();
        rms.addBox("A0000001", "K0000632");
        rms.addBox("A0000002", "K0000625");
        rms.addBox("A0000003", "K0000618");
        rms.addBox("A0000004", "K0000611");
        rms.addBox("A0000005", "K0000633");
        rms.addBox("A0000006", "K0000626");
        rms.addBox("A0000007", "K0000619");
        rms.addBox("A0000008", "K0000612");
//        rms.addBox("A0000009", "K0000634");
//        rms.addBox("A0000010", "K0000627");
//        rms.addBox("A0000011", "K0000620");
//        rms.addBox("A0000012", "K0000613");
//        rms.addBox("A0000013", "K0000635");
//        rms.addBox("A0000014", "K0000628");
//        rms.addBox("A0000015", "K0000621");
//        rms.addBox("A0000016", "K0000614");
    }

    private void removeBox() throws Exception {
        StringBuffer str = new StringBuffer();
        HttpURLConnection conn;
        URL url = new URL("http://192.168.10.3:8895");
        conn = (HttpURLConnection) url.openConnection();
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setUseCaches(false);
        conn.setConnectTimeout(10000);
        conn.setReadTimeout(120000);
        conn.connect();

        OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), StandardCharsets.UTF_8);
        out.write("{\n" +
                "    \"id\": \"geekCode_geekWarehouseCode_001\",\n" +
                "    \"msgType\": \"QueryInstructionRequestMsg\",\n" +
                "    \"request\": {\n" +
                "        \"header\": {\n" +
                "            \"requestId\": \"" + UUID.randomUUID().toString() + "\",\n" +
                "            \"clientCode\": \"geekCode\",\n" +
                "            \"warehouseCode\": \"geekWarehouseCode\",\n" +
                "            \"userId\": \"admin\",\n" +
                "            \"userKey\": \"123456\",\n" +
                "            \"language\": \"en_us\",\n" +
                "            \"version\": \"3.3.0\"\n" +
                "        },\n" +
                "        \"body\": {\n" +
                "            \"instruction\": \"BOX\"\n" +
                "        }\n" +
                "    }\n" +
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

        JSONObject jsonObject = JSONObject.parseObject(String.valueOf(str));
        JSONArray boxes = jsonObject.getJSONObject("response").getJSONObject("body").getJSONArray("boxes");
        for (Object box : boxes) {
            String boxCode = ((JSONObject) box).getString("boxCode");
            removeBox(boxCode);
        }

    }

    private void removeBox(String boxNo) throws Exception {
        StringBuffer str = new StringBuffer();
        HttpURLConnection conn;
        URL url = new URL("http://192.168.10.3:8895");
        conn = (HttpURLConnection) url.openConnection();
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setUseCaches(false);
        conn.setConnectTimeout(10000);
        conn.setReadTimeout(120000);
        conn.connect();

        OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), StandardCharsets.UTF_8);
        out.write("{\n" +
                "    \"id\": \"geekCode_geekWarehouseCode_001\",\n" +
                "    \"msgType\": \"WarehouseInstructionRequestMsg\",\n" +
                "    \"request\": {\n" +
                "        \"header\": {\n" +
                "            \"requestId\": \"" + UUID.randomUUID().toString() + "\",\n" +
                "            \"clientCode\": \"geekCode\",\n" +
                "            \"warehouseCode\": \"geekWarehouseCode\",\n" +
                "            \"userId\": \"admin\",\n" +
                "            \"userKey\": \"123456\",\n" +
                "            \"language\": \"en_us\",\n" +
                "            \"version\": \"3.3.0\"\n" +
                "        },\n" +
                "        \"body\": {\n" +
                "            \"instruction\": \"REMOVE_BOX\",\n" +
                "            \"boxCode\": \"" + boxNo + "\"\n" +
                "        }\n" +
                "    }\n" +
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

    private void addBox(String boxNo, String locationNo) throws Exception {
        StringBuffer str = new StringBuffer();
        HttpURLConnection conn;
        URL url = new URL("http://192.168.10.3:8895");
        conn = (HttpURLConnection) url.openConnection();
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setUseCaches(false);
        conn.setConnectTimeout(10000);
        conn.setReadTimeout(120000);
        conn.connect();

        OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), StandardCharsets.UTF_8);
        out.write("{\n" +
                "    \"id\": \"geekCode_geekWarehouseCode_001\",\n" +
                "    \"msgType\": \"WarehouseInstructionRequestMsg\",\n" +
                "    \"request\": {\n" +
                "        \"header\": {\n" +
                "            \"requestId\": \"" + UUID.randomUUID().toString() + "\",\n" +
                "            \"clientCode\": \"geekCode\",\n" +
                "            \"warehouseCode\": \"geekWarehouseCode\",\n" +
                "            \"userId\": \"admin\",\n" +
                "            \"userKey\": \"123456\",\n" +
                "            \"language\": \"en_us\",\n" +
                "            \"version\": \"3.3.0\"\n" +
                "        },\n" +
                "        \"body\": {\n" +
                "            \"instruction\": \"ADD_BOX\",\n" +
                "            \"boxCode\": \"" + boxNo + "\",\n" +
                "            \"latticeCode\": \"" + locationNo + "\",\n" +
                "            \"placeLatticeCode\": \"" + locationNo + "\"\n" +
                "        }\n" +
                "    }\n" +
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
