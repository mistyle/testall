package com.example.demo.test.pattern.proxy.dynamicDemo2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @program: testall
 * @Date: 2019/5/23 23:38
 * @Author: mistyle
 * @Description:
 */
public class StuInvocationHandler  <T> implements InvocationHandler {
	//invocationHandler持有的被代理对象
	T target;

	public StuInvocationHandler(T target) {
		this.target = target;
	}

	/**
	 * proxy:代表动态代理对象
	 * method：代表正在执行的方法
	 * args：代表调用目标方法时传入的实参
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("代理执行" + method.getName() + "方法");
      if(method.getName().equals("giveMoney")) {
		  System.out.println("参数 " + args[0]);
		  System.out.println("proxy " + proxy);
		  System.out.println("target " + target); //被代理对象
	  }
		  //代理过程中插入监测方法,计算该方法耗时
		  System.out.println("start ");

		  Object result = method.invoke(target, args);
		  System.out.println("end ");

		  return result;

	}
}