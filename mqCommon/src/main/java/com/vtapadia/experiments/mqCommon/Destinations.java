package com.vtapadia.experiments.mqCommon;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;

import javax.jms.Queue;
import javax.jms.Topic;

public class Destinations {

    public static final Queue DUMMY_QUEUE_STR = new ActiveMQQueue("dummy.queue.str");
    public static final Queue DUMMY_QUEUE_OBJ = new ActiveMQQueue("dummy.queue.obj");

    public static final Topic DUMMY_TOPIC_STR = new ActiveMQTopic("dummy.topic.str");
    public static final Topic DUMMY_TOPIC_OBJ = new ActiveMQTopic("dummy.topic.obj");
}
