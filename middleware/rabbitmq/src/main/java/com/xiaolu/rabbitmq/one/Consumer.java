package com.xiaolu.rabbitmq.one;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static com.xiaolu.rabbitmq.one.Producer.getChannel;

/**
 * 消费者 接受消息
 *
 * @author xiaolu
 * @since 2022/9/22
 */
public class Consumer {
    public static final String QUEUE_NAME ="hello_xiaolu";

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = getChannel();
        DeliverCallback deliverCallback =(consumerTag, message)->{
            System.out.println(new String(message.getBody()));
        };
        CancelCallback cancelCallback= consumerTag->{
            System.out.println("消费消息中断");
        };
        System.out.println("C2等待中......");
        channel.basicConsume(QUEUE_NAME,true,deliverCallback,cancelCallback);
    }
}
