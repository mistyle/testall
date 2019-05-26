package com.example.demo.test.extendtest;

/**
 * @program: testall
 * @Date: 2019/5/22 15:24
 * @Author: mistyle
 * @Description:
 */
public class Client {
	public static void main(String[] args) {
		///Child child=new Child();
	     // child.tell();
		//child.name//访问不了
		//child.speak();//私有方法继承不了
		//System.out.println(child.address);//共有属性可以继承

		Father father =new Father(3, "father");

	}
}
