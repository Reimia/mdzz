package com.reimia.socketTest.server;

import com.reimia.socketTest.server.HttpServerTest;
import com.sun.net.httpserver.HttpServer;

import java.net.InetSocketAddress;


public class TbrainServer {
    public static void main(String[] arg) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(9999), 0);
        server.createContext("/", new HttpServerTest.TestHandler());
        server.start();
    }
}
