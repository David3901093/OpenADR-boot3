package com.avob.openadr.server.common.vtn;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.ShutdownSignalException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionListener;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import static com.avob.openadr.server.common.vtn.service.push.DemandResponseEventPublisher.OADR20A_QUEUE;
import static com.avob.openadr.server.common.vtn.service.push.DemandResponseEventPublisher.OADR20B_QUEUE;

@Profile("external")
@Configuration
public class VtnConfigRabbitmqBroker {

	private static final Logger log = LogManager.getLogger(VtnConfigRabbitmqBroker.class);
	private final VtnConfig vtnConfig;

	public VtnConfigRabbitmqBroker(VtnConfig vtnConfig) {
		this.vtnConfig = vtnConfig;
	}

	@Bean
	public com.rabbitmq.client.ConnectionFactory connectionFact() throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(vtnConfig.getBrokerHost() != null ? vtnConfig.getBrokerHost() : "openadr-boot3-rabbitmq-1");
		factory.setPort(vtnConfig.getBrokerPort() > 0 ? vtnConfig.getBrokerPort() : 5672);
		factory.setUsername(vtnConfig.getBrokerUser() != null ? vtnConfig.getBrokerUser() : "admin");
		factory.setPassword(vtnConfig.getBrokerPass() != null ? vtnConfig.getBrokerPass() : "admin");
		factory.setVirtualHost("/");
		log.info("RabbitMQ broker connection: " + factory.getHost() + ":" + factory.getPort());
		try (Connection connection = factory.newConnection();
			 Channel channel = connection.createChannel()) {
			channel.exchangeDeclare("oadr20b.exchange", "topic", true);
		}
		return factory;
	}

	@Bean
	public RabbitAdmin rabbitAdmin(org.springframework.amqp.rabbit.connection.ConnectionFactory connectionFactory) {
		RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
		rabbitAdmin.setAutoStartup(true);
		return rabbitAdmin;
	}


	@Bean
	public Queue OADR20AQueue() {

		return QueueBuilder.durable(OADR20A_QUEUE)
				.withArgument("x-queue-mode", "default")
				.build();
	}

	 @Bean
	 public Queue OADR20BQueue() {
	     return QueueBuilder.durable(OADR20B_QUEUE).build();
	 }
	@Bean
	public Queue CommandQueue() {
		return QueueBuilder.durable("queue.command.oadr20b").build();
	}




	@Bean
	public MessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	public RabbitTemplate rabbitTemplate(org.springframework.amqp.rabbit.connection.ConnectionFactory connectionFactory) {
		RabbitTemplate template = new RabbitTemplate(connectionFactory);
		template.setMessageConverter(jsonMessageConverter());
		template.setExchange("oadr20b.exchange");
		template.setRoutingKey("oadr20b.routingKey");
		return template;
	}


}