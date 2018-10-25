package com.rookiewzw.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by RookieWangZhiWei on 2018/10/25.
 */
@Component
@ServerEndpoint("/webSocket")
@Slf4j
public class WebSocket {

    public Session session;

    private static CopyOnWriteArrayList<WebSocket> webSocketSet = new CopyOnWriteArrayList<>();

    @OnOpen
    public void opOpen(Session session) {
        this.session = session;
        webSocketSet.add(this);
        log.info("【websocket消息】有新的连接, 总数:{}", webSocketSet.size());


    }

    @OnClose
    public void OnClose() {
        webSocketSet.remove(this);
        log.info("【websocket消息】连接断开, 总数:{}", webSocketSet.size());

    }

    @OnMessage
    public void OnMessage(String message) {
        log.info("【websocket消息】收到客户端发来的消息:{}", message);

    }


    public void sendMessage(String message) {
        for (WebSocket webSocket : webSocketSet) {
            log.info("【websocket消息】广播消息, message={}", message);
            try {
                webSocket.session.getBasicRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
