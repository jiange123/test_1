package com.icarbonx.web.service;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class AccurateSportMQService {

    //@RabbitListener(queues = {"test_mq_testQueue"})
    public void onSurveyFinished(Map map){

        System.out.println(map.get("id"));
    }


}
