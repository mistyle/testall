package com.example.demo.test.pattern.proxy.dynamicDemo2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @program: testall
 * @Date: 2019/5/23 23:38
 * @Author: mistyle
 * @Description:
 */
public class ProxyTest {
	public static void main(String[] args) {

		Class<?> stuProxyClass = Proxy.getProxyClass(Person.class.getClassLoader(), new Class<?>[] {Person.class});
		System.out.println(stuProxyClass); //class com.sun.proxy.$Proxy0

		//创建一个实例对象，这个对象是被代理的对象
		Person zhangsan = new Student("张三");
		System.out.println(zhangsan);

		//创建一个与代理对象相关联的InvocationHandler
		InvocationHandler stuHandler = new StuInvocationHandler<Person>(zhangsan);

		//创建一个代理对象stuProxy来代理zhangsan，代理对象的每个执行方法都会替换执行Invocation中的invoke方法
		Person stuProxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class<?>[]{Person.class}, stuHandler);

		System.out.println(stuProxy); //与zhangsan指向同一内存地址
		//代理执行上交班费的方法
		stuProxy.giveMoney("老师");
	}
}
