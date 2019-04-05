package com.example.demo.rabbit.many;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: testall
 * @Date: 2019/4/4 9:27
 * @Author: mistyle
 * @Description: 一对多 oneToMany关系
 */
@RestController
public class OneToManyController {

    @Autowired
    private NeoSender neoSender;


    // http://localhost:8081/oneToMany
    @GetMapping(value = "/oneToMany")
    public void oneToMany() throws Exception {
        for (int i=0;i<100;i++){
            neoSender.send(i);
        }
    }
}