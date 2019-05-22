package com.example.demo.test.serializable;

import java.io.*;

/**
 * @program: testall
 * @Date: 2019/5/13 22:38
 * @Author: mistyle
 * @Description:
 */
public class SerializeDemo {
	public static void main(String[] args) {
		// 序列化操作
		SerializePerson();
       //Person.height=5;
		//反序列化操作
		Person person=DeSerializePerson();

		System.out.println(person);
	}
	public static void  SerializePerson(){
		try {
			ObjectOutputStream oo=new ObjectOutputStream(new FileOutputStream(new File("person")));
			Person person=new Person();
			person.setAge(18);
			person.setName("mic");
			oo.writeObject(person);
			oo.flush();
			oo.writeObject(person);
			oo.flush();
			System.out.println("序列化成功: "+new File("person").length());//target文件夹下面生成文件
            oo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	private static Person DeSerializePerson(){
		ObjectInputStream ois= null;
		try {
			ois = new ObjectInputStream(new FileInputStream(new File("person")));
			Person person=(Person)ois.readObject();
			return person;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 注意点：
	 *  （1）打印对象，要覆盖toString （）
	 *   （2）Person要实现序列化接口
	 *   (3)执行序列化后，注释掉后serialVersionUID，再反序列，会报异常
	 *   com.example.demo.test.serializable.Person; local class incompatible: stream classdesc serialVersionUID = 1, local class serialVersionUID =
	    (4)如果不加序列化之前也注释掉serialVersionUID，反序列化之前修改Person,也会报版本不一致的问题，如果写了serialVersionUID，就不会出现此问题
	 */
}
