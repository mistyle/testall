package com.example.demo.test.proxy.Dynamic1;

/**
 * @program: testall
 * @Date: 2019/5/6 14:05
 * @Author: mistyle
 * @Description:
 */
public class RealSubject  implements  Subject{
	public void request(){
		System.out.println("From real subject");
	}

}
