package com.reimia.socketTest.server;

import com.alibaba.fastjson.JSONObject;
import com.reimia.socketTest.response.BuildResponse;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.apache.commons.io.IOUtils;
import org.intellij.lang.annotations.Language;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class RmsServer {
    public static void main(String[] args) throws IOException {
        HttpServer server2 = HttpServer.create(new InetSocketAddress(8895), 0);
        server2.createContext("/", new TestHandler());
        server2.start();
    }

    static class TestHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            System.out.println("receive message from: " + exchange.getRequestURI());
            Random random = new Random();
            int i = random.nextInt(100);

            @Language("JSON") String s = "{\n" +
                    "  \"id\": \"geekCode_geekWarehouseCode_001\",\n" +
                    "  \"msgType\": \"RobotTaskResponseMsg\",\n" +
                    "  \"response\": {\n" +
                    "    \"header\": {\n" +
                    "      \"responseId\": \"a5a3eb48-1e10-4829-80cb-3b181d5339ad\",\n" +
                    "      \"code\": 0,\n" +
                    "      \"msg\": \"Success\"\n" +
                    "    },\n" +
                    "    \"body\": {\n" +
                    "      \"taskId\": " + i + "\n" +
                    "    }\n" +
                    "  }\n" +
                    "}";
            JSONObject jsonObject = JSONObject.parseObject(s);
            String response = JSONObject.toJSONString(jsonObject);
            String requestBody = IOUtils.toString(exchange.getRequestBody(), Charset.defaultCharset());
            SimpleDateFormat sdf = new SimpleDateFormat();
            System.out.println(sdf.format(new Date()));
            System.out.println("requestBody is: " + requestBody);
            System.out.println("responseBody is: " + response);
            exchange.sendResponseHeaders(200, 0);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
