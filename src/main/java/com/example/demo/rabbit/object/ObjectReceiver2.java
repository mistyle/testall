package com.example.demo.rabbit.object;

import com.example.demo.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: testall
 * @Date: 2019/4/4 14:58
 * @Author: mistyle
 * @Description:
 */
@Component
@RabbitListener(queues = "object")
public class ObjectReceiver2 {

    @RabbitHandler
    public void process(User user) {
        System.out.println("Receiver object : " + user);
    }

}