package com.example.demo.test.reflection;

import java.lang.reflect.Method;

/**
 * @program: testall
 * @Date: 2019/4/29 9:49
 * @Author: mistyle
 * @Description:
 */
public class ReflectionTest {

	public static void main(String[] args)throws Exception{
		//1.获取Class对象
		String className="com.example.demo.test.reflection.Person";
		Class clazz = Class.forName(className);

		//利用Class对象的newInstance方法创建一个类的实例
		Object obj =  clazz.newInstance();
		System.out.println(obj);


		//方式一(通过建立对象)
		Person stu = new Person();
		Class classobj1 = stu.getClass();
		System.out.println(classobj1.getName());

		//方式二（所在通过路径-相对路径）
		Class classobj2 = Class.forName("fanshe.Student");
		System.out.println(classobj2.getName());

		//方式三（通过类名）
		Class classobj3 = Person.class;
		System.out.println(classobj3.getName());



	}
	private static void ceratePerson(String className,  String methodname) throws Exception{
		Class clazz = Class.forName(className);
		Object o = clazz.newInstance();



		Method method = clazz.getDeclaredMethod(methodname);
		method.setAccessible(true);
		String result =  (String)method.invoke(o);
		System.out.println(result);
	}


}
