package com.example.demo.test.gc;

import java.lang.ref.WeakReference;

/**
 * @program: testall
 * @Date: 2019/5/21 17:21
 * @Author: mistyle
 * @Description:
 */
public class GCTest {
	public static void main(String[] args)  {
		WeakReference weakReference = new WeakReference(new User("zhangsan",24));
		System.gc();
		System.out.println("手动触发GC:" + weakReference.get());
	}

}
