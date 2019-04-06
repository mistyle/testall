package com.example.demo.test.thread;

/**
 * @program: testall
 * @Date: 2019/4/5 22:47
 * @Author: mistyle
 * @Description:
 */
public  class InterrupTest implements Runnable{

    public void run(){
        try {
            while (true) {
                Boolean a = Thread.currentThread().isInterrupted();//isInterrupted()是实例方法，
                // 是调用该方法的对象所表示的那个线程的isInterrupted()，不会重置当前线程的中断状态
                System.out.println("in run() - about to sleep for 20 seconds-------" + a);
                Thread.sleep(20000);  //                                                               (1) .t 线程处于阻塞状态
                System.out.println("in run() - woke up"+Thread.currentThread().isInterrupted());
           }
        } catch (InterruptedException e) {  //                                                              （3）.中断的捕获在while(true)之外，这样就退出了while(true)循环
            System.out.println("aaaa-------" +  Thread.currentThread().isInterrupted());  //                 (4). 中断标记为false

            //Thread.currentThread().interrupt();//如果不加上这一句，那么cd将会都是false，                          (5). 因为不在阻塞状态，中断标记为true

            System.out.println("bbb-------" +  Thread.currentThread().isInterrupted()); //打印true
            // 因为在捕捉到InterruptedException异常的时候就会自动的中断标志置为了false
            Boolean c=Thread.interrupted();//interrupted()是静态方法：内部实现是调用的当前线程的isInterrupted()，  (6) .返回中断标记
            System.out.println("cccc-------" +  Thread.currentThread().isInterrupted()); //上一步做了清除，所以返回false
            // 并且会重置当前线程的中断状态
            Boolean d=Thread.interrupted();   //                                                               (7)  .状态为false,所以这里返回false
            System.out.println("ddddd-------" +  Thread.currentThread().isInterrupted());
            System.out.println("c="+c);
            System.out.println("d="+d);
        }
    }
    public static void main(String[] args) {
        InterrupTest si = new InterrupTest();
        Thread t = new Thread(si);
        t.start();
        //主线程休眠2秒，从而确保刚才启动的线程有机会执行一段时间
        try {
            Thread.sleep(2000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("in main() - interrupting other thread");

        t.interrupt();//(2) .中断线程t，终端状态清除，并跑出异常
        System.out.println("in main() - leaving"+ t.isInterrupted());
    }
}
/**
 *  1.Thread.currentThread().isInterrupted()  ; //返回中断标记
 *  2.Thread.currentThread().interrupt() ;//调用interrupt()会立即将线程的中断标记设为“true”，但是由于线程处于阻塞状态，所以该“中断标记”会立即被清除为“false”
 *  注意：interrupt()并不会终止处于“运行状态”的线程！它会将线程的中断标记设为true。
 *
 *  3. Thread.interrupted()或者t.interrupted ;//返回中断标记之外，它还会清除中断标记(即将中断标记设为false)
 *
 * 4.每个线程都有一个与之相关联的 Boolean 属性，用于表示线程的中断状态（interrupted status）。中断状态初始时为 false
 * 5.中断是一种协作机制。当一个线程中断另一个线程时，被中断的线程不一定要立即停止正在做的事情。相反，中断是礼貌地请求另一个线程在它愿意并且方便的时候停止它正在做的事情。
 * 6.本线程中断自己是被允许的；其它线程调用本线程的interrupt()方法时，会通过checkAccess()检查权限。这有可能抛出SecurityException异常。
 * 7.中断一个“已终止的线程”不会产生任何操作。
 * 8.如果捕捉到 InterruptedException 但是不能重新抛出它，那么应该保留中断发生的证据，以便调用栈中更高层的代码能知道中断，并对中断作出响应
 * 9.其中，interrupt方法是唯一能将中断状态设置为true的方法
 */