package com.example.demo.controller;

import com.example.bean.User;
import com.example.demo.service.UserService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gmg on 2017/12/9.
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @RequestMapping(value = "updateUser")
    public int updateUser(@RequestBody  User user) throws Exception{
     return userService.updateUser(user);
    }

    @RequestMapping(value = "sendMess")
    public int sendMess() throws Exception{
        rabbitTemplate.convertAndSend("gmg","hhhhh");
        return 1;
    }

    @RequestMapping(value = "sendTopic1")
    public int sendTopic1() throws Exception{
        // topic.message 绑定两个队列
        rabbitTemplate.convertAndSend("exchange","topic.message","sendTopic1");
        return 1;
    }

    @RequestMapping(value = "sendTopic2")
    public int sendTopic2() throws Exception{
        // topic.messages 绑定一个队列
        rabbitTemplate.convertAndSend("exchange","topic.messages","sendTopic2");
        return 1;
    }
}
