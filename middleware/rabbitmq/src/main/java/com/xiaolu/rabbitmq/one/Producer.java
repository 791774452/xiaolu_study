package com.xiaolu.rabbitmq.one;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * 生产者：发送消息
 *
 * @author xiaolu
 * @since 2022/9/21
 */
public class Producer {
    /**
     * 队列名称
     */
    public static final String QUEUE_NAME = "hello_xiaolu";

    /**
     * 发消息
     *
     * @param args args
     * @throws IOException 异常
     */
    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = getChannel();
        /*
         * 生成一个队列
         * 1、队列名称
         * 2、队列里面是否持久化 默认情况消息存储在内存
         * 3、该队列是否只提供一个消费者消费 是否进行消息共享，false可以多个消费者消费
         * 4、是否自动删除
         * 5、其他参数
         */
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);


        /*
         * 发送一个消费
         * 1、发送到那个交换机
         * 2、路由到key是那个 本次队列到名称
         * 3、其他参数消息
         * 4、消息体
         */
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // 发消息
            String message = scanner.next();
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println("发送完毕");
        }

    }

    public static Channel getChannel() throws IOException, TimeoutException {
        // 创建一个连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        // 工厂IP
        factory.setHost("127.0.0.1");
        factory.setPort(5673);
        // 用户名
        factory.setUsername("admin");
        // 密码
        factory.setPassword("123");
        // 创建链接
        Connection connection = factory.newConnection();
        // 获取信道
        return connection.createChannel();


    }
}
