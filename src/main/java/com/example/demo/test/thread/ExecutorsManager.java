package com.example.demo.test.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ExecutorsManager {
	
	private static int threadNum = 5;
	
	private volatile static ScheduledExecutorService scheduledExcutor;
	private volatile static ExecutorService excutor;
	private volatile static ExecutorService strategySingleExcutor;
	private volatile static ExecutorService strategyMultipleExcutor;
	
	public static ScheduledExecutorService getScheduledExcutorInstance(){
		//先检查实例是否存在，如果不存在才进入下面的同步块
		if(scheduledExcutor == null){
			//同步块，线程安全的创建实例
			synchronized (ExecutorsManager.class) {
				//再次检查实例是否存在，如果不存在才真正的创建实例
				if(scheduledExcutor == null){
					scheduledExcutor = Executors.newScheduledThreadPool(threadNum);
				}
			}
		}
		return scheduledExcutor;
	}
	
	public static ExecutorService getExcutorInstance(){
		//先检查实例是否存在，如果不存在才进入下面的同步块
		if(excutor == null){
			//同步块，线程安全的创建实例
			synchronized (ExecutorsManager.class) {
				//再次检查实例是否存在，如果不存在才真正的创建实例
				if(excutor == null){
					excutor = Executors.newFixedThreadPool(threadNum);
				}
			}
		}
		return excutor;
	}
	
	public static ExecutorService getStrategySingleExcutorInstance(){
		//先检查实例是否存在，如果不存在才进入下面的同步块
		if(strategySingleExcutor == null){
			//同步块，线程安全的创建实例
			synchronized (ExecutorsManager.class) {
				//再次检查实例是否存在，如果不存在才真正的创建实例
				if(strategySingleExcutor == null){
					strategySingleExcutor = Executors.newFixedThreadPool(threadNum);
				}
			}
		}
		return strategySingleExcutor;
	}
	
	public static ExecutorService getStrategyMultipleExcutorInstance(){
		//先检查实例是否存在，如果不存在才进入下面的同步块
		if(strategyMultipleExcutor == null){
			//同步块，线程安全的创建实例
			synchronized (ExecutorsManager.class) {
				//再次检查实例是否存在，如果不存在才真正的创建实例
				if(strategyMultipleExcutor == null){
					strategyMultipleExcutor = Executors.newFixedThreadPool(1);
				}
			}
		}
		return strategyMultipleExcutor;
	}
	
//	public static void main(String[] args){
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss::SSS"); 
//		int count =0;
//		
//		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2, 1, TimeUnit.MILLISECONDS, new PriorityBlockingQueue<Runnable>());  
//        //模拟加入消息  
//        for (int i = 0; i < 5; i++) {  
//            System.out.println(sdf.format(System.currentTimeMillis()) + "加入消息～～～加入队列第" + (++count) + "条消息！");  
//            executor.execute(new RunnablePriority(1));                
//        }  
//        
//        
//        try {  
//            Thread.sleep(1000);  
//        } catch (InterruptedException e) {  
//            e.printStackTrace();  
//        }  
//        //模拟插入消息  
//        for (int i = 0; i < 5; i++) {  
//                 
//            System.out.println(sdf.format(System.currentTimeMillis()) + "插入消息～～～～插入队列第" + (++count) + "条消息！");  
//            executor.execute(new RunnablePriority(5));  
//        }  
//        try {  
//            Thread.sleep(1000);  
//        } catch (InterruptedException e) {  
//            e.printStackTrace();  
//        }  
//        //结束  
//        executor.shutdown();  
//        try {                 
//            executor.awaitTermination(1, TimeUnit.DAYS);  
//              
//            } catch (InterruptedException e) {                
//            e.printStackTrace();                  
//        }  
//        System.out.println("over");  
		
//		String ex = "136.125.56.899";
//		String[] exs = ex.split(":");
//		System.out.println("exs.length:" + exs.length);
//    }
	
	static class RunnablePriority  implements Runnable, Comparable<RunnablePriority> {  
		   
	    private int priority;     
	      
	    public int getPriority() {  
	        return priority;  
	    }  
	  
	  
	    public RunnablePriority(int priority) {  
	        this.priority = priority;  
	    }  
	      
	   
	    @Override  
	    public int compareTo(RunnablePriority o) {  
	        // 复写此方法进行任务执行优先级排序  
	        // return priority < o.priority ? -1 : (priority > o.priority ? 1 : 0);  
	        // System.out.println(priority +"::"+ o.priority);  
	        if (this.getPriority() < o.priority) {  
	            return 1;  
	        }   
	        if(this.getPriority()>o.priority){  
	            return -1;  
	        }  
	        return 0;  
	    }  
	   
	    @Override  
	    public void run() {  
	        System.out.printf("RunnablePriority: %s Priority :%d\n",Thread.currentThread().getName(),priority);  
	        try {  
	            Thread.sleep(1000);  
	        } catch (InterruptedException e) {  
	            e.printStackTrace();  
	        }  
	        // 执行任务代码..  
	    }  
	   
	}  
	
}
