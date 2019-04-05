package com.example.demo.rabbit.object;

/**
 * @program: testall
 * @Date: 2019/4/4 14:56
 * @Author: mistyle
 * @Description:
 */

import com.example.demo.entity.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ObjectSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(User user) {
        System.out.println("Sender object: " + user.toString());
        this.rabbitTemplate.convertAndSend("object", user);
    }

}
