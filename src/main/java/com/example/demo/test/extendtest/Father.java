package com.example.demo.test.extendtest;

/**
 * @program: testall
 * @Date: 2019/5/22 15:22
 * @Author: mistyle
 * @Description:
 */
public class Father {


	private  int  age;
	private  String name;

	public  String  address="122";

	public void tell(){
		System.out.println(name+age);
	}

	private void speak(){
		System.out.println(name+"is speaking!");
	}
	public Father(int age, String name) {
		super();
		this.age = age;
		this.name = name;

	}

}
/**
 * 子类不能继承父类的私有属性，但是如果子类中公有的方法影响到了父类私有属性，那么私有属性是能够被子类使用的。
 **/