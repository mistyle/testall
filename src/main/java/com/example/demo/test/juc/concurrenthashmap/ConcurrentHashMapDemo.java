package com.example.demo.test.juc.concurrenthashmap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: testall
 * @Date: 2019/5/21 11:17
 * @Author: mistyle
 * @Description: jdk1.8中递归调用出现的bug
 */
public class ConcurrentHashMapDemo {
	private Map<Integer,Integer> cache =new ConcurrentHashMap<>(15);

	public static void main(String[]args){
		ConcurrentHashMapDemo ch =    new ConcurrentHashMapDemo();
		System.out.println(ch.fibonaacci(80));
	}

	public int fibonaacci(Integer i){
		if(i==0||i ==1) {
			return i;
		}

		return cache.computeIfAbsent(i,(key) -> {
			System.out.println("fibonaacci : "+key);
			return fibonaacci(key -1)+fibonaacci(key - 2);
		});
	}
	/**
	 * ConcurrentHashMap 在 Java 8 中存在一个 bug 会进入死循环，
	 * 原因是递归创建 ConcurrentHashMap 对象，但是在 JDK 1.9 已经修复了。场景重现如下：
	 */
}
