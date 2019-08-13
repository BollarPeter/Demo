package com.pingco.config;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

/**
 * @author : pingco
 * create at:  2019/8/8  3:44 PM
 * @description:
 */

@Component("myAdaptableJobFactory")
public class MyAdaptableJobFactory extends AdaptableJobFactory {

    //AutowireCapableBeanFactory 可以将一个对象添加到SpringIOC容器中，并且完成该对象注入
    @Autowired
    private AutowireCapableBeanFactory factory;

    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {

        Object obj = super.createJobInstance(bundle);

        factory.autowireBean(obj);

        return obj;
    }
}
