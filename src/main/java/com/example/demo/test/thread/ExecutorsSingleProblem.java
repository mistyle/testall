package com.example.demo.test.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorsSingleProblem {
	
	public static void main(String[] args) throws Exception {

		test();
		test();
		/**调第2次就会报Exception in thread "main" java.util.concurrent.RejectedExecutionException: 
		Task java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask@5c647e05 
		rejected from java.util.concurrent.ScheduledThreadPoolExecutor@33909752[Shutting down, pool size = 1,
		active threads = 0, queued tasks = 0, completed tasks = 0]
		//at java.util.concurrent.ThreadPoolExecutor$AbortPolicy.rejectedExecution(ThreadPoolExecutor.java:2063) **/


	}

	public static void test() {

		ScheduledExecutorService scheduledExcutor = Executors.newScheduledThreadPool(5);
		
		//ScheduledExecutorService scheduledExcutor = ExecutorsManager.getScheduledExcutorInstance();//如果test() 第2次调用，会报异常

		Future future = scheduledExcutor.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				
			}

		}, 1, 1, TimeUnit.SECONDS);

		
		scheduledExcutor.shutdown(); //如果是单例的，这里就不能shutdown了

	}


}
