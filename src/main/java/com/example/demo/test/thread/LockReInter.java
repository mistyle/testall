package com.example.demo.test.thread;

/**
 * @program: testall
 * @Date: 2019/4/27 19:14
 * @Author: mistyle
 * @Description:
 */
public class LockReInter {
	boolean isLocked = false;
	Thread  lockedBy = null;
	int lockedCount = 0;
	public synchronized void lock()
			throws InterruptedException{
		Thread thread = Thread.currentThread();
		while(isLocked && lockedBy != thread){
			wait();
		}
		isLocked = true;
		lockedCount++;
		lockedBy = thread;
	}
	public synchronized void unlock(){
		if(Thread.currentThread() == this.lockedBy){
			lockedCount--;
			if(lockedCount == 0){
				isLocked = false;
				notify();
			}
		}
	}


}
