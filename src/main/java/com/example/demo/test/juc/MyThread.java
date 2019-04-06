package com.example.demo.test.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: testall
 * @Date: 2019/4/6 9:51
 * @Author: mistyle
 * @Description:
 */
public class MyThread implements Runnable {

    public MyThread() {

    }

    @Override
    public void run() {
        String jobID = "REQUEST_SUBSCRIPTION_STATUS_CHANGE";
        Map<String, Future> futures = new HashMap<>();
        final AtomicInteger count = new AtomicInteger(0);
        final CountDownLatch countDownLatch = new CountDownLatch(1); //如果countDown()执行次数<这里参数,会导致死锁，如果执行次数大于参数，以conntdown执行次数为准
        ScheduledExecutorService scheduledExcutor = Executors.newSingleThreadScheduledExecutor();
        Future future = scheduledExcutor.scheduleWithFixedDelay(new Runnable() {

            @Override
            public void run() {
                System.out.println(count.getAndIncrement());

                Future future = futures.get(jobID);// 获取结果，若无结果会阻塞至异步计算完成
                String state = "completed";
                if ("completed".equals(state) || "canceld".equals(state) || "Rejected".equals(state)) {
                    System.out.println("ddd" + future.isDone());  //任务没结束，这里返回false
                    if (future != null) {
                        future.cancel(true);

                    }
                    countDownLatch.countDown(); // 开始这里没写这一句，导致子线程挂起，主线程得不到执行

                } else if ("In progress".equals(state)) {
                    if (count.get() > 2) {

                        if (future != null) {
                            future.cancel(true);
                        }
                        //countDownLatch.countDown();
                    }

                }
                System.out.println("ddd11" + future.isDone()); //执行结束（完成/取消/异常）返回true

            }
        }, 0, 1, TimeUnit.SECONDS);

        futures.put(jobID, future);

        try {
            countDownLatch.await(); //这是个阻塞方法，如果遇到重试，那么最多要重试3次之后，才会回到主线程执行
        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();
        }

        try {
            scheduledExcutor.shutdown();
            // (所有的任务都结束的时候，返回TRUE)
            if (!scheduledExcutor.awaitTermination(5, TimeUnit.SECONDS)) {
                // 超时的时候向线程池中所有的线程发出中断(interrupted)。
                scheduledExcutor.shutdownNow();
            }
        } catch (InterruptedException e) {
            //logger.error("awaitTermination interrupted: " + e);
            scheduledExcutor.shutdownNow();
        }

    }
}
