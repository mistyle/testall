package com.example.demo.rabbit.hello;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: testall
 * @Date: 2019/4/4 9:25
 * @Author: mistyle
 * @Description:
 */
@Component
@RabbitListener(queues = "hello")
public class HelloReceiver {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("单对单接收参数  : " + hello);
    }

}
