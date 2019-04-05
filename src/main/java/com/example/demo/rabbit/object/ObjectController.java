package com.example.demo.rabbit.object;

import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @program: testall
 * @Date: 2019/4/4 15:02
 * @Author: mistyle
 * @Description:
 */
public class ObjectController {
    @Autowired
    private ObjectSender sender;

    //http://localhost:8081/object

    @GetMapping(value = "/object")
    public void sendOject() throws Exception {
        User user=new User();
        //user.setName("neo");
       // user.setPass("123456");
        sender.send(user);
    }
}
