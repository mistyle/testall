package com.example.demo.rabbit.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: testall
 * @Date: 2019/4/4 14:54
 * @Author: mistyle
 * @Description:
 */

@RestController
public class TopicController {




    @Autowired
    private TopicSender sender;

    //http://localhost:8081/topic
    @GetMapping(value = "/topic")
    public void topic() throws Exception {
        sender.send();
    }

    //http://localhost:8081/topic1
    @GetMapping(value = "/topic1")
    public void topic1() throws Exception {
        sender.send1();
    }

    //http://localhost:8081/topic1
    @GetMapping(value = "/topic2")
    public void topic2() throws Exception {
        sender.send2();
    }
}