//package com.example.demo;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import com.example.demo.controller.HelloWorldController;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest  或者@WebMvcTest(EmployeeController.class) 或者@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class HelloWorldControlerTests  {
//	
//	private MockMvc mvc;
//    @Before
//    public void setUp() throws Exception {
//        mvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
//    }
//    //@Test
//    public void getHello() throws Exception {
//    	
//    	 mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
//         .andExpect(MockMvcResultMatchers.status().isOk())
//         .andDo(MockMvcResultHandlers.print())
//         .andReturn();
//    	 
//    	 
//    mvc.perform(MockMvcRequestBuilders.get("/say").accept(MediaType.APPLICATION_JSON)
//    		.contentType(MediaType.APPLICATION_JSON_UTF8)
//            .param("word", "mistyle"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print())
//                .andReturn();
//    }
//
//}
