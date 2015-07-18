package com.vtapadia.experiments.mqSenderSpring;

import com.vtapadia.experiments.mqCommon.Destinations;
import com.vtapadia.experiments.mqCommon.DummyObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class SpringSenderService {

    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage(String message) {
        //One to one communication
        jmsTemplate.convertAndSend(Destinations.ACTIVE_QUEUE_STR, message);

        //Broadcasting a message
        jmsTemplate.convertAndSend(Destinations.ACTIVE_TOPIC_STR, message);
    }

    public void sendObject(DummyObject dummyObject) {

        jmsTemplate.convertAndSend(Destinations.ACTIVE_QUEUE_OBJ, dummyObject);

        jmsTemplate.convertAndSend(Destinations.ACTIVE_TOPIC_OBJ, dummyObject);
    }


}
