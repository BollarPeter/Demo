package com.pingco.quartz;

import com.pingco.service.UserService;
import org.apache.catalina.User;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author : pingco
 * create at:  2019/8/8  1:59 PM
 * @description:
 */
public class QuartzDemo implements Job {

    @Autowired
    private UserService userService;

    /**
     * 任务触发时执行的方法
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("execute..." + new Date());

        userService.addUser();

    }
}
