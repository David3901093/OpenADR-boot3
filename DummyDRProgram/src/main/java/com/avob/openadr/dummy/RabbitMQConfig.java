package com.avob.openadr.dummy;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public TopicExchange notificationExchange() {
        return new TopicExchange("oadr.notification.exchange");
    }

    @Bean
    public Queue registerReportQueue() {
        return new Queue(DummyVTN20bControllerConfig.OADR_APP_NOTIFICATION_REGISTER_REPORT_TOPIC, true);
    }

    @Bean
    public Queue updateReportFloatQueue() {
        return new Queue(DummyVTN20bControllerConfig.OADR_APP_NOTIFICATION_UPDATE_REPORT_TOPIC_FLOAT, true);
    }

    @Bean
    public Binding bindingRegisterReport(Queue registerReportQueue, TopicExchange notificationExchange) {
        return BindingBuilder.bind(registerReportQueue)
                .to(notificationExchange)
                .with(DummyVTN20bControllerConfig.OADR_APP_NOTIFICATION_REGISTER_REPORT_TOPIC);
    }

    @Bean
    public Binding bindingUpdateReportFloat(Queue updateReportFloatQueue, TopicExchange notificationExchange) {
        return BindingBuilder.bind(updateReportFloatQueue)
                .to(notificationExchange)
                .with(DummyVTN20bControllerConfig.OADR_APP_NOTIFICATION_UPDATE_REPORT_TOPIC_FLOAT);
    }
}