package com.gyhb.config;

import javax.websocket.Session;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SessionPool {

    public static Map<String, Session> sessions = new ConcurrentHashMap<>();

//    public static void close(String sessionId) throws IOException {
//        Session session = sessions.get(sessionId);
//        if(session != null){
//            sessions.get(sessionId).close();
//        }
//    }

    public static void close(String sessionId) throws IOException {
        for (String userId : SessionPool.sessions.keySet()){
            Session session = SessionPool.sessions.get(userId);
            if (session.getId().equals(sessionId)){
                sessions.remove(userId);
                break;
            }
        }
    }

    public static void sendMessage(String sessionId,String message){
        sessions.get(sessionId).getAsyncRemote().sendText(message);
    }

    public static void sendMessage(String message){
        for (String sessionId : SessionPool.sessions.keySet()){
            SessionPool.sessions.get(sessionId).getAsyncRemote().sendText(message);
        }
    }







































}
