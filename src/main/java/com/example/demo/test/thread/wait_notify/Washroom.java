package com.example.demo.test.thread.wait_notify;

/**
 * @program: testall
 * @Date: 2019/5/23 16:31
 * @Author: mistyle
 * @Description:
 */
public class Washroom {
	private volatile boolean isAvailable = false;    //表示厕所是否是可用的状态

	private Object lock = new Object(); //厕所门的锁

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean available) {
		this.isAvailable = available;
	}

	public Object getLock() {
		return lock;
	}
}

