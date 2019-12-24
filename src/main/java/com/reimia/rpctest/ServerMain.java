package com.reimia.rpctest;

import com.reimia.rpctest.server.NettyServer;

public class ServerMain {
    public static void main(String[] args) throws Exception{
        //启动server服务
        new NettyServer().bind(9090);
    }
}
