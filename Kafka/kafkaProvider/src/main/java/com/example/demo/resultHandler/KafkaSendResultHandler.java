package com.example.demo.resultHandler;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Component;

/**
 * @author gmg
 * @title: KafkaSendResultHandler
 * @projectName MqLearning
 * @description: TODO
 * @date 2019/9/9 19:46
 */
@Component
public class KafkaSendResultHandler implements ProducerListener {

    private static final Logger log = LoggerFactory.getLogger(KafkaSendResultHandler.class);

    @Override
    public void onSuccess(String s, Integer integer, Object o, Object o2, RecordMetadata recordMetadata) {
        log.info("Message send success : " + recordMetadata.toString());
    }

    @Override
    public void onError(String s, Integer integer, Object o, Object o2, Exception e) {
        log.info("Message send success : " + o.toString());
    }

    @Override
    public boolean isInterestedInSuccess() {
        return false;
    }
}