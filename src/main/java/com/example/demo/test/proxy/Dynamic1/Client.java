package com.example.demo.test.proxy.Dynamic1;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: testall
 * @Date: 2019/5/6 14:13
 * @Author: mistyle
 * @Description:
 */
public class Client {

public static void main(String[] args) throws Throwable{
		// TODO Auto-generated method stub 

		Subject rs=new RealSubject();//这里指定被代理类 
		InvocationHandler ds=new DynamicSubject(rs);
		Class<?> cls=rs.getClass();

		//以下是一次性生成代理 

		Subject subject=(Subject) Proxy.newProxyInstance(   //$Proxy0转成Proxy
		cls.getClassLoader(),cls.getInterfaces(), ds);

		//这里可以通过运行结果证明subject是Proxy的一个实例，这个实例实现了Subject接口 
		System.out.println(subject instanceof Proxy);

		//这里可以看出subject的Class类是$Proxy0,这个$Proxy0类继承了Proxy，实现了Subject接口 
		System.out.println("subject的Class类是："+subject.getClass().toString());

		System.out.print("subject中的属性有：");

		Field[] field=subject.getClass().getDeclaredFields();
		for(Field f:field){
		System.out.print(f.getName()+", ");
		}

		System.out.print("\n"+"subject中的方法有：");

		Method[] method=subject.getClass().getDeclaredMethods();

		for(Method m:method){
		System.out.print(m.getName()+", ");
		}

		System.out.println("\n"+"subject的父类是："+subject.getClass().getSuperclass());

		System.out.print("\n"+"subject实现的接口是：");

		Class<?>[] interfaces=subject.getClass().getInterfaces();

		for(Class<?> i:interfaces){
		System.out.print(i.getName()+", ");
		}

		System.out.println("\n\n"+"运行结果为：");
		subject.request(); //当执行subject.request()方法时，就调用了$Proxy0类中的request()方法
	    //进而调用父类Proxy中的h的invoke()方法.即InvocationHandler.invoke()。
		}
		}
/**
 * 打印结果如下：
 * true
 * subject的Class类是：class com.sun.proxy.$Proxy0
 * subject中的属性有：m1, m2, m3, m0,
 * subject中的方法有：equals, toString, hashCode, request,
 * subject的父类是：class java.lang.reflect.Proxy
 *
 * subject实现的接口是：com.example.demo.test.proxy.Dynamic1.Subject,
 *
 * 运行结果为：
 * before calling public abstract void com.example.demo.test.proxy.Dynamic1.Subject.request()
 * From real subject
 * after calling public abstract void com.example.demo.test.proxy.Dynamic1.Subject.request()
 *
 * Process finished with exit code 0
 */
/**
		 * invoke被调用的关键3步:
		 * 1.Subject subject=(Subject) Proxy.newProxyInstance(   //$Proxy0转成Proxy
		 * 2.subject.request(); //当执行subject.request()方法时，就调用了$Proxy0类中的request()方法
		 * 3.进而调用父类Proxy中的h的invoke()方法.即InvocationHandler.invoke()。
 *
 * 反编译可以看到
 * public final class $Proxy0 extends Proxy implements Subject
 * {
		 **/