package com.gyhb.service;

import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
@ServerEndpoint("/webSocket")
public class WebSocket {
    private Session session;

    private static final CopyOnWriteArraySet<WebSocket> webSocketSet = new CopyOnWriteArraySet<>();

    @OnOpen
    public void opOpen(Session session){
        this.session = session;
        webSocketSet.add(this);
        System.out.println(webSocketSet.size());
    }

    @OnClose
    public void onClose(){
        webSocketSet.remove(this);
        System.out.println(webSocketSet.size());
    }

    @OnMessage
    public void onMessage(String message){
        System.out.println("收到客户端发来的消息：");
        System.out.println(message);
    }

    public void sendMessage(String message){
        for(WebSocket webSocket: webSocketSet){
            System.out.println("广播消息：");
            System.out.println(message);
            try {
                webSocket.session.getBasicRemote().sendText(message);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}































