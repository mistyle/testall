package com.example.demo.test.pattern.prototype;

/**
 * @program: testall
 * @Date: 2019/5/22 11:09
 * @Author: mistyle
 * @Description:
 */
public class TestPrototype {
	public static void main(String[] args) {
		Student student=new  Student();
		Prototype  por=new Prototype(student);
		System.out.println(por.getStudent());
		try {
			Prototype  por1=(Prototype)por.clone();
			System.out.println(por1.getStudent()); //证明是浅复制
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

	}
}
