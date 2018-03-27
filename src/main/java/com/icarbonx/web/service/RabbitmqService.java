package com.icarbonx.web.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RabbitmqService  {

    /*@RabbitListener(queues = "ccs.queue.topic1")
    public void getMessage(Map<String, Object>  message) {
        System.out.println("consumer：" + message.get("data"));
    }*/


}
