package com.example.demo.test.serializable;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

import java.io.Serializable;

/**
 * @program: testall
 * @Date: 2019/5/13 22:30
 * @Author: mistyle
 * @Description:
 */
public class Person implements Serializable {
	private static final long serialVersionUID=1L;

	@Protobuf(fieldType = FieldType.STRING,order = 1)
	private String name;

	@Protobuf(fieldType = FieldType.INT32,order = 2)
	private int age;
	public static int getHeight() {
		return height;
	}

	public static void setHeight(int height) {
		Person.height = height;
	}

	private String aa;

	public  static int height=2;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}

	public void setAge(int age) {
		this.age = age;
	}


}
