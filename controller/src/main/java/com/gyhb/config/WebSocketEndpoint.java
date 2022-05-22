package com.gyhb.config;

import org.springframework.stereotype.Component;

import javax.websocket.server.ServerEndpoint;

//ws://localhost:8089/websocket/A
@ServerEndpoint(value = "/websocket1111/{userId}")
@Component
public class WebSocketEndpoint {
//
//    private Session session;
//
//
//    @OnOpen
//    public void onOpen(Session session, @PathParam("userId") String userId){
//
//        SessionPool.sessions.put(userId,session);
//
//    }
//
//    @OnClose
//    public void onClose(Session session) throws IOException {
//        SessionPool.close(session.getId());
//        session.close();
//
//    }
//
//    @OnMessage
//    public void onMessage(String message,Session session) {
//        if(JSON.parse(message).toString().equalsIgnoreCase("ping")){
//            try{
//                Map<String,Object> params = new HashMap<String,Object>();
//                params.put("type","pong");
//                session.getBasicRemote().sendText(JSON.toJSONString(params));
//                System.out.println("应答客户端的消息:" + JSON.toJSONString(params));
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }else{
//            SessionPool.sendMessage(message);
//        }


//    }































































































}
