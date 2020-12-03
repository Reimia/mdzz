package com.reimia.socketTest.server;

import com.reimia.socketTest.response.BuildResponse;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HttpServerTest {
    public static void main(String[] arg) throws Exception {
        HttpServer server3 = HttpServer.create(new InetSocketAddress(9998), 0);
        server3.createContext("/", new TestHandler());
        server3.start();
    }

    static  class TestHandler implements HttpHandler{
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            System.out.println("receive message from: "+ exchange.getRequestURI());
            String response = BuildResponse.generate();
            String requestBody = IOUtils.toString(exchange.getRequestBody(), StandardCharsets.UTF_8);
            SimpleDateFormat sdf = new SimpleDateFormat();
            System.out.println(sdf.format(new Date()));
            System.out.println("requestBody is: "+requestBody);
            System.out.println("responseBody is: "+response);
            exchange.sendResponseHeaders(200, 0);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
