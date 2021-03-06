package com.nettytest;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by zhengchao on 2017/1/25.
 */
public class AlexLocalClientHandler extends SimpleChannelInboundHandler<String> {
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println("client connected");
        ctx.writeAndFlush("Netty rocks").addListener(future -> {
            System.out.println("write has been finished");
        });
    }

    @Override protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println("client received : " + msg);
    }
}
