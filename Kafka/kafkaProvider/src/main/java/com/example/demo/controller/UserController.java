package com.example.demo.controller;

import com.example.bean.User;
import com.example.demo.resultHandler.KafkaSendResultHandler;
import com.example.demo.service.UserService;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.SimpleTimeZone;

/**
 * Created by gmg on 2017/12/9.
 */
@RestController
public class UserController {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaSendResultHandler producerListener;


    @Autowired
    UserService userService;
    @RequestMapping(value = "updateUser")
    public int updateUser(@RequestBody  User user) throws Exception{
        return userService.updateUser(user);
    }

    @RequestMapping(value = "send")
    public int send(String key, String data) throws Exception{
        kafkaTemplate.setProducerListener(producerListener);

        kafkaTemplate.send("test", key, data);
        kafkaTemplate.send("topic.quick.demo", 0, System.currentTimeMillis(), "0", "send message with timestamp");
        //使用Message发送消息
        Map map = new HashMap();
        map.put(KafkaHeaders.TOPIC, "topic.quick.demo");
        map.put(KafkaHeaders.PARTITION_ID, 0);
        map.put(KafkaHeaders.MESSAGE_KEY, 0);
        GenericMessage message = new GenericMessage("use Message to send message",new MessageHeaders(map));
        kafkaTemplate.send(message);


        return 1;
    }

    @RequestMapping(value = "sendTransaction")
    public int sendTransaction(String key, String data){
        kafkaTemplate.executeInTransaction((KafkaOperations.OperationsCallback) kafkaOperations -> {
            kafkaTemplate.send("test", key, data);
            throw new RuntimeException("fail");
            //return true;
        });
        return 1;
    }



}
