package com.gsxm.pojo;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by 蒋志鹏 on 2018/7/18.
 */

@Component
public class Consumer {


    @JmsListener(destination = "itcast")
    public void readMessage(String text){
        System.out.println("接收参数："+text);
    }
}
