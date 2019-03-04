package com.duqio.boot.test.webscoket;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.stereotype.Component;
import org.yeauty.annotation.OnBinary;
import org.yeauty.annotation.OnClose;
import org.yeauty.annotation.OnError;
import org.yeauty.annotation.OnEvent;
import org.yeauty.annotation.OnMessage;
import org.yeauty.annotation.OnOpen;
import org.yeauty.annotation.ServerEndpoint;
import org.yeauty.pojo.ParameterMap;
import org.yeauty.pojo.Session;


import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * 
 *************************************************
 * 功能描述:  webScoket的测试类                  
 * @author  Mr.Chen                   
 * @version 1.0                
 * @date    2019年2月27日 创建文件                                             
 * @see                        
 *************************************************
 */
@ServerEndpoint(port = 9092)
@Component
public class WebScoketController {
	
	private static ConcurrentMap<String, Object> webScoketMap = new ConcurrentHashMap<>();
	
	/** 用户的编号 **/
	private String userId;
	
	@OnOpen
    public void onOpen(Session session, HttpHeaders headers, ParameterMap parameterMap) throws IOException {
        System.out.println("new connection");
        System.out.println("connection user id is: " + parameterMap.getParameter("userId"));
        userId = parameterMap.getParameter("userId");
        webScoketMap.putIfAbsent(userId, session);
        System.out.println("key size :" + webScoketMap.keySet().size());
    }

    @OnClose
    public void onClose(Session session) throws IOException {
       System.out.println("one connection closed"); 
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        throwable.printStackTrace();
    }

    @OnMessage
    public void onMessage(Session session, String message) {
    	System.out.println("userId is : " + userId);
        System.out.println(message);
        session.sendText("Hello Netty!");
    }

    @OnBinary
    public void onBinary(Session session, byte[] bytes) {
        for (byte b : bytes) {
            System.out.println(b);
        }
        session.sendBinary(bytes); 
    }

    @OnEvent
    public void onEvent(Session session, Object evt) {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
            switch (idleStateEvent.state()) {
                case READER_IDLE:
                    System.out.println("read idle");
                    break;
                case WRITER_IDLE:
                    System.out.println("write idle");
                    break;
                case ALL_IDLE:
                    System.out.println("all idle");
                    break;
                default:
                    break;
            }
        }
    }
	
}
