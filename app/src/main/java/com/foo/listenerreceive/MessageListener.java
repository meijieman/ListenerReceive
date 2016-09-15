package com.foo.listenerreceive;

/**
 * @Author: Major
 * @Since: 2016/9/15 8:15
 */
public interface MessageListener<T> {

    void sendMessage(T t);

    void register(Message<T> listener);

    void unRegister(Message<T> listener);
}
