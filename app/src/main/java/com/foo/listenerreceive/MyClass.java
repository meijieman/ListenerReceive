package com.foo.listenerreceive;

public class MyClass {

    public static void main(String[] args) {
        MessageListener<String> manager = MessageListenerImpl.getInstance();

        Message<String> listener1 = new Message<String>() {
            @Override
            public void onMessage(String msg) {
                System.out.println("--------- listener1 收到 msg " + msg);
            }
        };
        manager.register(listener1);

        manager.sendMessage("我发送了广播了");

        Message<String> listener2 = new Message<String>() {
            @Override
            public void onMessage(String msg) {
                System.out.println("--------- listener2 收到 msg " + msg);
            }
        };
        manager.register(listener2);
    }
}
