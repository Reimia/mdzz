package com.reimia.nettyRpcTest.client;

import com.reimia.nettyRpcTest.bean.RpcRequest;
import com.reimia.nettyRpcTest.bean.RpcResponse;
import com.reimia.nettyRpcTest.protocol.RpcDecoder;
import com.reimia.nettyRpcTest.protocol.RpcEncoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyClient {
    private final String host;
    private final int port;
    private Channel channel;

    public Channel getChannel() {
        return channel;
    }

    public NettyClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() throws Exception{
        final EventLoopGroup group = new NioEventLoopGroup();

        Bootstrap b = new Bootstrap();
        b.group(group).channel(NioSocketChannel.class)// 使用NioSocketChannel来作为连接用的channel类
                .handler(new ChannelInitializer<SocketChannel>() {// 绑定连接初始化器
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        System.out.println("正在连接中...");
                        ChannelPipeline pipeline = socketChannel.pipeline();
                        pipeline.addLast(new RpcEncoder(RpcRequest.class));//编码request
                        pipeline.addLast(new RpcDecoder(RpcResponse.class));//解码response
                        pipeline.addLast(new ClientHandler());
                    }
                });

        //发起异步连接请求，绑定连接端口和host信息
        final ChannelFuture future = b.connect(host,port).sync();

        future.addListener((ChannelFutureListener) arg0 -> {
            if (future.isSuccess()){
                System.out.println("连接服务器成功");
            }else {
                System.out.println("连接服务器失败");
                future.cause().getStackTrace();
                group.shutdownGracefully();//关闭线程组
            }
        });
        this.channel = future.channel();
    }



}