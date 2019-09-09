package com.example.demo.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author gmg
 * @title: KafkaReceiver
 * @projectName MqLearning
 * @description: TODO
 * @date 2019/9/9 16:21
 */
@Component
@Slf4j
public class KafkaReceiver {

    @KafkaListener(topics = {"test"})
    public void listen(ConsumerRecord<?, ?> record) {

        Optional<?> kafkaMessage = Optional.ofNullable(record.value());

        if (kafkaMessage.isPresent()) {

            Object message = kafkaMessage.get();
            log.info("message is\t"+ message);
            log.info("record is\t"+record);
        }

    }
}
