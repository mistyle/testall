package com.example.demo.test.thread;


public class ThreadLocalTest { 
	ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
    ThreadLocal<String> stringLocal = new ThreadLocal<String>();
 
     
    public void set() {
    	// System.out.println("初始化threadLocal"+longLocal);
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }
     
    public long getLong() {
        return longLocal.get();
    }
     
    public String getString() {
        return stringLocal.get();
    }
     
    public static void main(String[] args) throws InterruptedException {
        final ThreadLocalTest test = new ThreadLocalTest();
         
         
        test.set();
      
        System.out.println("start线程id"+test.getLong());  //打印1
        System.out.println("start线程名称"+test.getString()); //打印main
     
       
        Thread thread1 = new Thread(){
            public void run() {
               test.set();
              
                System.out.println("线程1   "+test.getLong()); //打印10
                System.out.println("线程1   "+test.getString());//打印main
                
               
            };
        };
        thread1.start();
        thread1.join(); //比如在B线程中调用A线程的join()方法,直到A线程执行完毕,B线程才会继续执行.
        //主线程执行，就是thread1执行后，才执行主线程
        
        Thread thread2= new Thread(){
            public void run() {
               test.set();
              
                System.out.println("线程2   "+test.getLong()); //打印10
                System.out.println("线程2   "+test.getString());//打印main
                
               
            };
        };
        thread2.start();
        thread2.join();
      
        System.out.println("end线程id   "+test.getLong()); //打印1
        System.out.println("end线程名称   "+test.getString());//打印main
    }
}