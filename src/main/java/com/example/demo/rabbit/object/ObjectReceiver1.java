package com.example.demo.rabbit.object;

import com.example.demo.entity.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: testall
 * @Date: 2019/4/4 14:57
 * @Author: mistyle
 * @Description:
 */
@Component
public class ObjectReceiver1 {



    @RabbitHandler
    public void process(User user) {
        System.out.println("Receiver object : " + user);
    }

}