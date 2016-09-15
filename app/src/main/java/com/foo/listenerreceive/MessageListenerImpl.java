package com.foo.listenerreceive;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc: TODO
 * @Author: Major
 * @Since: 2016/9/15 8:58
 */
public class MessageListenerImpl implements MessageListener<String> {

    private List<Message<String>> mListeners = new ArrayList<>();

    private static MessageListener<String> sInstance;

    private String latestMsg; // 记录最近一次消息

    public static MessageListener<String> getInstance(){
        if (sInstance == null) {
            synchronized (MessageListenerImpl.class) {
                if (sInstance == null) {
                    sInstance = new MessageListenerImpl();
                }
            }
        }
        return sInstance;
    }

    @Override
    public void sendMessage(String msg) {
        if (msg == null) {
            throw new IllegalArgumentException("msg cannot be null");
        }

        latestMsg = msg;
        for (Message<String> listener : mListeners) {
            listener.onMessage(msg);
        }
    }

    @Override
    public void register(Message<String> listener) {
        if (listener != null) {
            mListeners.add(listener);
            if (latestMsg != null) {
                listener.onMessage(latestMsg); // 发送最近的一次消息
            }
        }
    }

    @Override
    public void unRegister(Message<String> listener) {
        if (listener != null) {
            mListeners.remove(listener);
        }
    }
}
