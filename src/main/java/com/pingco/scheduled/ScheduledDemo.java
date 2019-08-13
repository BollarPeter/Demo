package com.pingco.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author : pingco
 * create at:  2019/8/8  11:25 AM
 * @description:
 */

@Component
public class ScheduledDemo {

    /**
     * 定时任务方法
     *
     */
    @Scheduled(cron = "0/2 * * * * ?")
    public void scheduledMethod(){

        System.out.println("定时器被触发" + new Date());
    }

}
