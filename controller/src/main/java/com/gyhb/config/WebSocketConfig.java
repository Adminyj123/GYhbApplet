package com.gyhb.config;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Component
public class WebSocketConfig {

    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }
}
