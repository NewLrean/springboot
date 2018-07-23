package com.gsxm.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 蒋志鹏 on 2018/7/18.
 */

@RestController
public class QueueController {

    /**
     * 使用内嵌的消息中间件
     */
    @Autowired
    JmsMessagingTemplate jmsMessagingTemplate;

    @RequestMapping("/send/{text}")
    private void seng(@PathVariable String text){
        jmsMessagingTemplate.convertAndSend("itcast",text);
    }
}
