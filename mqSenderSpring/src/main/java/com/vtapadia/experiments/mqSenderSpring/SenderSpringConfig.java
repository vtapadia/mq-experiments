package com.vtapadia.experiments.mqSenderSpring;

import org.apache.activemq.jms.pool.PooledConnectionFactory;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@PropertySource(value="classpath:application.properties", ignoreResourceNotFound = true)
public class SenderSpringConfig {

    @Value("${spring.activemq.broker-url:}")
    private String brokerURL;

    @Value("${spring.activemq.poolSize:10}")
    private int poolSize;

    @Bean
    public PooledConnectionFactory connectionFactory() {
        PooledConnectionFactory pooledConnectionFactory = new PooledConnectionFactory();
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
        factory.setBrokerURL(brokerURL);
        factory.setClientID("senderSpringClientId");
        pooledConnectionFactory.setConnectionFactory(factory);
        pooledConnectionFactory.setMaxConnections(poolSize);
        return pooledConnectionFactory;
    }

    @Bean
    public JmsTemplate jmsTemplate() {
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory());
        return template;
    }
}
