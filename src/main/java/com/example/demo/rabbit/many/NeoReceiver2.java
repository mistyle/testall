package com.example.demo.rabbit.many;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: testall
 * @Date: 2019/4/4 9:27
 * @Author: mistyle
 * @Description:
 */
@Component
@RabbitListener(queues = "neo")
public class NeoReceiver2 {

    @RabbitHandler
    public void process(String neo) {
        System.out.println("Receiver 2: " + neo);
    }

}