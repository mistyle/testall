//package com.example.demo;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.example.demo.rabbitMQ.HelloSender;
//import com.example.demo.rabbitMQ.many.NeoSender;
//import com.example.demo.rabbitMQ.many.NeoSender2;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class RabbitMqHelloTest {
//
//	@Autowired
//	private HelloSender helloSender;
//	
//	@Autowired
//	private NeoSender neoSender;
//
//	@Autowired
//	private NeoSender2 neoSender2;
//
//	//@Test
//	public void hello() throws Exception {
//		helloSender.send();
//	}
//	
//
//	//@Test
//	public void oneToMany() throws Exception {
//		for (int i=0;i<10;i++){
//			neoSender.send(i);
//		}
//	}
//
//	//@Test
//	public void manyToMany() throws Exception {
//		for (int i=0;i<10;i++){
//			neoSender.send(i);
//			neoSender2.send(i);
//		}
//	}
//}