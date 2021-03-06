package com.example.demo.timer;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerTask {

    private int count=0;

    @Scheduled(cron="*/6 * * * * ?")   //每隔6秒执行一次
    private void process(){
        System.out.println("this is scheduler task runing  "+(count++));
    }

}