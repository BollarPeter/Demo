package com.pingco.config;

import com.pingco.quartz.QuartzDemo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

/**
 * @author : pingco
 * create at:  2019/8/8  2:37 PM
 * @description:
 */

@Configuration
public class QuartzConfig {

    /**
     * 创建job对象
     * @return
     */
    @Bean
    public JobDetailFactoryBean jobDetailFactoryBean(){
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();

        //关联我们自己的Job类
        factoryBean.setJobClass(QuartzDemo.class);

        return factoryBean;
    }

    /**
     * 创建Trigger对象
     * @param jobDetailFactoryBean
     * @return
     */
    @Bean
    public SimpleTriggerFactoryBean simpleTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean){

        SimpleTriggerFactoryBean factoryBean = new SimpleTriggerFactoryBean();

        //关联JobDetail对象
        factoryBean.setJobDetail(jobDetailFactoryBean.getObject());

        //该参数表示一个执行的毫秒数
        factoryBean.setRepeatInterval(2000);

        //重复次数
        factoryBean.setRepeatCount(5);

        return factoryBean;
    }

    /**
     * 创建Scheduler对象
     * @return
     */
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(SimpleTriggerFactoryBean simpleTriggerFactoryBean,MyAdaptableJobFactory myAdaptableJobFactory){

        SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();

        //关联Trigger
        factoryBean.setTriggers(simpleTriggerFactoryBean.getObject());

        factoryBean.setJobFactory(myAdaptableJobFactory);

        return factoryBean;
    }

}
