package com.vtapadia.experiments.mqSenderSpring;

import com.vtapadia.experiments.mqCommon.DummyObject;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jms.annotation.EnableJms;

@Configuration
@EnableJms
@ComponentScan(basePackageClasses = SpringSenderApp.class)
public class SpringSenderApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringSenderApp.class);

        SpringSenderService service = context.getBean(SpringSenderService.class);
//        service.sendMessage("hello mq world");
//        service.sendObject(new DummyObject("Dummy Object", 14));
        context.close();
    }

    //Used to enable @Value ${} translation
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfig() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
