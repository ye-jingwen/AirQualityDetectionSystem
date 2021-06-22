package com.example.demo.config;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;

import org.springframework.messaging.*;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;


import java.util.HashMap;
import java.util.Map;
@Configuration
@IntegrationComponentScan
@Slf4j
public class MqttReceiveConfig {
	public static MqttPahoMessageDrivenChannelAdapter adapter = null;
	public static Map<String, String> map = new HashMap<String, String>(); 
    @Value("${spring.mqtt.username}")
    private String username;

    @Value("${spring.mqtt.password}")
    private String password;

    @Value("${spring.mqtt.url}")
    private String hostUrl;

    @Value("${spring.mqtt.client.id}")
    private String clientId;

    @Value("${spring.mqtt.default.topic}")
    private String defaultTopic;

    @Value("${spring.mqtt.completionTimeout}")
    private int completionTimeout;   //连接超时

    @Bean
    public MqttPahoClientFactory mqttClientFactory() {
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
        mqttConnectOptions.setUserName(username);
        mqttConnectOptions.setPassword(password.toCharArray());
        // 设置是否清空session,这里如果设置为false表示服务器会保留客户端的连接记录，
        // 把配置里的 cleanSession 设为false，客户端掉线后 服务器端不会清除session，
        // 当重连后可以接收之前订阅主题的消息。当客户端上线后会接受到它离线的这段时间的消息
        mqttConnectOptions.setCleanSession(false);
        mqttConnectOptions.setServerURIs(new String[]{hostUrl});
        // 设置会话心跳时间 单位为秒 服务器会每隔1.5*20秒的时间向客户端发送个消息判断客户端是否在线，但这个方法并没有重连的机制
        mqttConnectOptions.setKeepAliveInterval(20);
        factory.setConnectionOptions(mqttConnectOptions);
        return factory;
    }

    //接收通道
    @Bean
    public MessageChannel mqttInputChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageProducer inbound() {
       // MqttPahoMessageDrivenChannelAdapter adapter =
        //        new MqttPahoMessageDrivenChannelAdapter(clientId, mqttClientFactory(), "yourTopic");
    	adapter = new MqttPahoMessageDrivenChannelAdapter(clientId, mqttClientFactory(),defaultTopic);
        adapter.setCompletionTimeout(completionTimeout);
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setQos(1);
        adapter.setOutputChannel(mqttInputChannel());
        adapter.setTaskScheduler(new ConcurrentTaskScheduler());
        return adapter;
    }

    //通过通道获取数据
    @Bean
    @ServiceActivator(inputChannel = "mqttInputChannel")
    public MessageHandler handler() {
        return new MessageHandler() {
            @Override
            public void handleMessage(Message<?> message) throws MessagingException {
                System.out.println("message ==> " + message.getPayload());
                MessageHeaders headers = message.getHeaders();
                
                System.out.println("headers ==> " + headers);
                //String topic = headers.get(MqttHeaders.TOPIC).toString();
                String topic = headers.get("mqtt_receivedTopic").toString();
                System.out.println("topic ==> " + topic);
                String str= message.getPayload().toString();
                if (!str.isEmpty()) {
                    System.out.println("string ==> " + str);
                    map.put(topic, str);
                    
                }
            }
        };
    }
   
    
}

