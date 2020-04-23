package com.reimia.socketTest.server;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class ArmServer {
    public static void main(String[] args) throws IOException {
        HttpServer server2 = HttpServer.create(new InetSocketAddress(23413), 0);
        server2.createContext("/", new HttpServerTest.TestHandler());
        server2.start();
    }
}
