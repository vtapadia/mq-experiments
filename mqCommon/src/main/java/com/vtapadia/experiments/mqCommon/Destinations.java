package com.vtapadia.experiments.mqCommon;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;

import javax.jms.Queue;
import javax.jms.Topic;

public class Destinations {

    public static final String DUMMY_QUEUE_STR = "dummy.queue.str";
    public static final String DUMMY_QUEUE_OBJ = "dummy.queue.obj";

    public static final String DUMMY_TOPIC_STR = "dummy.topic.str";
    public static final String DUMMY_TOPIC_OBJ = "dummy.topic.obj";

    public static final Queue ACTIVE_QUEUE_STR = new ActiveMQQueue(DUMMY_QUEUE_STR);
    public static final Queue ACTIVE_QUEUE_OBJ = new ActiveMQQueue(DUMMY_QUEUE_OBJ);

    public static final Topic ACTIVE_TOPIC_STR = new ActiveMQTopic(DUMMY_TOPIC_STR);
    public static final Topic ACTIVE_TOPIC_OBJ = new ActiveMQTopic(DUMMY_TOPIC_OBJ);
}
