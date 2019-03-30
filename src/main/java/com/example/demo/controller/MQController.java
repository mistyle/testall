package com.example.demo.controller;//package com.example.demo.controller;
//
//import org.springframework.amqp.core.AmqpTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.gsta.dcp.api.common.MessageBus;
//import com.gsta.dcp.api.model.usersimcard.UserSimcard;
//
//@RestController
//public class MQController {
//	
//	@Autowired
//	AmqpTemplate amqpTemplate;
//	
//    @RequestMapping("/")
//    String home() {
//    	UserSimcard  user=new UserSimcard();
//    	user.setCardphone(110101088888l);
//    	//需要新建个queue
//    	MessageBus.sendMessage("TEST", user, amqpTemplate);
//        return "Hello World!";
//    }
//}