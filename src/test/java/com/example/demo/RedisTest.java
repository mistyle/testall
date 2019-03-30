package com.example.demo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.cache.RedisUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {


	@Autowired
	private  RedisUtil redisUtil;

	
	@Before
	public void before() throws Exception {
		System.out.println("test  start----------------");
	}

	@Test
	public void test() throws Exception {
		
		redisUtil.put("name", "huang");

	}
	
	@After
	public void end() throws Exception {
		System.out.println("test end");
	}

}
