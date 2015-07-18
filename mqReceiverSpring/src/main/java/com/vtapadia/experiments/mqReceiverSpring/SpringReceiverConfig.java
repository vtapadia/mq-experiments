package com.vtapadia.experiments.mqReceiverSpring;

import com.vtapadia.experiments.mqCommon.Destinations;
import com.vtapadia.experiments.mqCommon.DummyObject;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;

@Configuration
@PropertySource("classpath:application.properties")
public class SpringReceiverConfig {

    @Value("${spring.activemq.broker-url}")
    private String brokerURL;

    @Bean
    public ActiveMQConnectionFactory factory() {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
        factory.setBrokerURL(brokerURL);
        return factory;
    }

    @Bean
    public SimpleJmsListenerContainerFactory jsmListnerFactory1() {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(factory());
        factory.setClientId("receiverSpringClientId1");
        return factory;
    }

    @Bean
    public SimpleJmsListenerContainerFactory jsmListnerFactory2() {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(factory());
        factory.setClientId("receiverSpringClientId2");
        return factory;
    }

    @Bean
    public SimpleJmsListenerContainerFactory jsmListnerDurableFactory1() {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(factory());
        factory.setClientId("receiverDurableSpringClientId1");
        factory.setSubscriptionDurable(true);
        return factory;
    }

    @Bean
    public SimpleJmsListenerContainerFactory jsmListnerDurableFactory2() {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(factory());
        factory.setClientId("receiverDurableSpringClientId2");
        factory.setSubscriptionDurable(true);
        return factory;
    }

    @JmsListener(destination = Destinations.DUMMY_QUEUE_STR, containerFactory = "jsmListnerFactory1")
    public void receiveQueueMessage(String message) {
        System.out.println("Receivied queue message : " + message);
    }

    @JmsListener(destination = Destinations.DUMMY_TOPIC_STR, containerFactory = "jsmListnerDurableFactory1")
    public void receiveTopicMessage(String message) {
        System.out.println("Received Topic message : " + message);
    }

    @JmsListener(destination = Destinations.DUMMY_QUEUE_OBJ, containerFactory = "jsmListnerFactory2")
    public void receiveQueueObject(DummyObject dummy) {
        System.out.println("Received Queue object : " + dummy);
    }

    @JmsListener(destination = Destinations.DUMMY_TOPIC_OBJ, containerFactory = "jsmListnerDurableFactory2")
    public void receiveTopicObject(DummyObject dummy) {
        System.out.println("Received Topic object : " + dummy);
    }
}
