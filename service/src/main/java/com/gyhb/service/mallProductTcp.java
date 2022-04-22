package com.gyhb.service;

import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
@ServerEndpoint("/productTcp")
public class mallProductTcp {
    private Session session;

    private static CopyOnWriteArraySet<mallProductTcp> webSocketSet = new CopyOnWriteArraySet<>();

    @OnOpen
    public void opOpen(Session session){
        this.session = session;
        webSocketSet.add(this);
    }

    @OnClose
    public void onClose(){
        webSocketSet.remove(this);
    }

    @OnMessage
    public void onMessage(String message){}

    public void sendMessage(String message){
        for(mallProductTcp webSocket: webSocketSet){
            try {
                webSocket.session.getBasicRemote().sendText(message);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}































