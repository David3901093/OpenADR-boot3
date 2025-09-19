package com.avob.openadr.server.common.vtn.service.push;

import  jakarta.annotation.Resource;
import jakarta.jms.JMSException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.stereotype.Service;

import com.avob.openadr.server.common.vtn.VtnConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class OadrAppNotificationPublisher {

	private static final Logger LOGGER = LoggerFactory.getLogger(OadrAppNotificationPublisher.class);

	public static final String OADR_APP_NOTIFICATION_TOPIC = "topic.app.notification";

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Resource
	private VtnConfig vtnConfig;

	private ObjectMapper mapper = new ObjectMapper();

	public void notify(Object payload, String subTopic, String venId) {
		try {
			String writeValueAsString = mapper.writeValueAsString(payload);

			if (vtnConfig.hasExternalRabbitMQBroker()) {
				// RabbitMQ ブローカーのシナリオ：トピック名を動的に構築
				String destinationName = OADR_APP_NOTIFICATION_TOPIC + "." + subTopic + ".*";

				// メッセージを作成して送信
				rabbitTemplate.convertAndSend(destinationName, writeValueAsString, message -> {
					MessageProperties props = message.getMessageProperties();
					props.setHeader("VEN_ID", venId);
					return message;
				});

			} else {
				// 組み込みブローカーのシナリオ：venId まで特定したサブトピック
				String destinationName = OADR_APP_NOTIFICATION_TOPIC + "." + subTopic + "." + venId;

				rabbitTemplate.convertAndSend(destinationName, writeValueAsString, message -> {
					MessageProperties props = message.getMessageProperties();
					props.setHeader("VEN_ID", venId);
					return message;
				});
			}

		} catch (JsonProcessingException e) {
			LOGGER.error("Can't marshall message for notification", e);
		}
	}
}
