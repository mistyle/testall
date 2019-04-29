package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.entity.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

	@Test
	public void test() throws Exception {

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);

		userRepository.save(new User("aa8", "aa3@126.com", "aa3", "aa1234567890", formattedDate));
	  // User user=userRepository.findByUserName("aa3");
//		userRepository.save(new User("bb2", "bb@126.com", "bb", "bb123456", formattedDate));
//		userRepository.save(new User("cc3", "cc@126.com", "cc", "cc123456", formattedDate));
//
		//Assert.assertEquals(9, userRepository.findAll().size());
		//Assert.assertEquals("bb", userRepository.findByUserNameOrEmail("bb", "cc@126.com").getNickName());
	//	userRepository.delete(userRepository.findByUserName("aa1"));
		//System.out.println("xxxxxxxxxxxxxxxxxxxxxs"+user.getNickName());
		User  user=userRepository.findByUserName("aa1");
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa "+user);
	}

}
