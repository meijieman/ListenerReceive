package com.foo.listenerreceive;

/**
 * @Desc: TODO
 * @Author: Major
 * @Since: 2016/9/15 8:12
 */
public interface Message<T> {

    void onMessage(T msg);
}
