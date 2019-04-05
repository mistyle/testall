package com.example.demo.rabbit.fanout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: testall
 * @Date: 2019/4/4 14:55
 * @Author: mistyle
 * @Description:
 */
@RestController
public class FanoutController {


    @Autowired
    private FanoutSender sender;


    //http://localhost:8081/fanout
    @GetMapping(value = "/fanout")
    public void fanoutSender() throws Exception {
        sender.send();
    }

}