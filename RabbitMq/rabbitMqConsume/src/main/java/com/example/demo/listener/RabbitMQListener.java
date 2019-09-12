package com.example.demo.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author gmg
 * @title: RabbitMQListener
 * @projectName MqLearning
 * @description: TODO
 * @date 2019/9/11 14:52
 */
@Component
public class RabbitMQListener {

  /*  @RabbitListener(queues = "gmg")
    public void receive(String message) {
        System.out.println("收到的 message 是：" + message);
    }*/

    @RabbitListener(queues = "topic.messages")
    public void receiveTopic1(String message) {
        System.out.println("topic.messages收到的 message 是：" + message);
    }

    @RabbitListener(queues = "topic.message")
    public void receiveTopic2(String message) {
        System.out.println("topic.message收到的 message 是：" + message);
    }
}
