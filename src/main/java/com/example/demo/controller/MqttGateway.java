package com.example.demo.controller;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
import org.springframework.integration.mqtt.support.MqttHeaders;
@Component
@MessagingGateway(defaultRequestChannel = "mqttOutboundChannel")
public interface MqttGateway {
	void sendToMqtt(String data, @Header(MqttHeaders.TOPIC) String topic);
	void sendToMqtt(String data);
	
}
