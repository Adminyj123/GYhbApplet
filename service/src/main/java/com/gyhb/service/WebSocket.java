package com.gyhb.service;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author YangJie
 * @date 2022/5/30 9:38
*/
@Component
@ServerEndpoint("/websocket/{userId}")
public class WebSocket {
    private Session session;

    private static final Logger logger = LoggerFactory.getLogger(WebSocket.class);

    private static final CopyOnWriteArraySet<WebSocket> webSocketSet = new CopyOnWriteArraySet<>();

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
    public void onMessage(String message) {
        if(JSON.parse(message).toString().equalsIgnoreCase("ping")){
            try{
                Map<String,Object> params = new HashMap<String,Object>();
                params.put("type","pong");
                session.getBasicRemote().sendText(JSON.toJSONString(params));
            }catch (Exception e){
                e.printStackTrace();
                logger.error("websocket:{}",e.getMessage());
            }
        }else{
            for(WebSocket webSocket: webSocketSet){
                try {
                    webSocket.session.getBasicRemote().sendText(message);
                }catch (Exception e){
                    e.printStackTrace();
                    logger.error("websocket:{}",e.getMessage());
                }
            }
        }


    }

    public void sendMessage(String message){
        for(WebSocket webSocket: webSocketSet){
            try {
                webSocket.session.getBasicRemote().sendText(message);
                logger.info(message);
            }catch (Exception e){
                e.printStackTrace();
                logger.error("websocket : {}",e.getMessage());
            }
        }
    }
}































