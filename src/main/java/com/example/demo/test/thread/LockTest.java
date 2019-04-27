package com.example.demo.test.thread;

/**
 * @program: testall
 * @Date: 2019/4/27 19:08
 * @Author: mistyle
 * @Description:
 */
public class LockTest {
	//Lock lock = new Lock();  //不可重入锁
	LockReInter lock = new LockReInter(); //可重入锁
	public void print() throws Exception{
		lock.lock();
		doAdd();  //这里就会发生死锁
		lock.unlock();
	}
	public void doAdd() throws Exception{
		lock.lock();
		//do something
		lock.unlock();
	}

	public static void main(String[] args)throws Exception {
		LockTest test=new LockTest();
		test.print();
		//test.doAdd();
	}

	/**
	 * 所谓不可重入锁，即若当前线程执行某个方法已经获取了该锁，那么在方法中尝试再次获取锁时，就会获取不到被阻塞。我们尝试设计一个不可重入锁：
	 * 总结：synchronized 和Lock 都是可重入锁，单并不是说用synchronized写的代码一定就是可重入的，
	 */
}
