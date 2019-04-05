package com.example.demo.rabbit.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: testall
 * @Date: 2019/4/4 9:25
 * @Author: mistyle
 * @Description: 一对一 oneToOne
 */
@RestController
public class HelloController {


    @Autowired
    private HelloSender helloSender;

    // http://localhost:8081/hello
    @GetMapping(value = "/hello")
    public void hello() throws Exception {
        helloSender.send();
    }
}