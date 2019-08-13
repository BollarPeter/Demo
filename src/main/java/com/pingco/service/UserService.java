package com.pingco.service;

import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author : pingco
 * create at:  2019/8/8  3:22 PM
 * @description:
 */

@Service
public class UserService {

    public void addUser(){
        System.out.println("add user...." + new Date());
    }

}
