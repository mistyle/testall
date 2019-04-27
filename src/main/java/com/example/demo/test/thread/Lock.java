package com.example.demo.test.thread;

/**
 * @program: testall
 * @Date: 2019/4/27 19:08
 * @Author: mistyle
 * @Description:
 */
public class Lock {
	private boolean isLocked = false;
	public synchronized void lock() throws InterruptedException{
		while(isLocked){
			wait();
		}
		isLocked = true;
	}
	public synchronized void unlock(){
		isLocked = false;
		notify();
	}


}
