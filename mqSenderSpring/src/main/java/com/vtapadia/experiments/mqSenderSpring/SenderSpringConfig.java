package com.vtapadia.experiments.mqSenderSpring;

import org.apache.activemq.jms.pool.PooledConnectionFactory;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@PropertySource(value="classpath:application.properties", ignoreResourceNotFound = false)
public class SenderSpringConfig {

    @Value("${spring.activemq.broker-url}")
    private String brokerURL;

    @Value("${spring.activemq.poolSize}")
    private int poolSize;

    //TODO Need to analyze how to make this work.
    @Bean
    public PooledConnectionFactory connectionFactory() {
        PooledConnectionFactory pooledConnectionFactory = new PooledConnectionFactory();
        pooledConnectionFactory.setConnectionFactory(factory());
        pooledConnectionFactory.setMaxConnections(poolSize);
        return pooledConnectionFactory;
    }

    @Bean
    public ActiveMQConnectionFactory factory() {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
        factory.setBrokerURL(brokerURL);
        factory.setClientID("senderSpringClientId");
        return factory;
    }

    @Bean
    public JmsTemplate jmsTemplate() {
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(factory());
        return template;
    }
}
