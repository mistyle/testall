package com.example.demo.test.thread;


public class ThreadLocalTest { 
	ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
    ThreadLocal<String> stringLocal = new ThreadLocal<String>();
 
     
    public void set() {
    	 System.out.println(longLocal);
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
      
        System.out.println(test.getLong());  //打印1
        System.out.println(test.getString()); //打印main
     
       
        Thread thread1 = new Thread(){
            public void run() {
               test.set();
              
                System.out.println(test.getLong()); //打印10
                System.out.println(test.getString());//打印main
                
               
            };
        };
        thread1.start();
        thread1.join();
        
        Thread thread2= new Thread(){
            public void run() {
               test.set();
              
                System.out.println(test.getLong()); //打印10
                System.out.println(test.getString());//打印main
                
               
            };
        };
        thread2.start();
        thread2.join();
      
        System.out.println(test.getLong()); //打印1
        System.out.println(test.getString());//打印main
    }
}