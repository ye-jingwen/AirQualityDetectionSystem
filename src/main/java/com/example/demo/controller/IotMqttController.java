package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.MqttReceiveConfig;  

@RestController
@RequestMapping("/mqtt")
public class IotMqttController {
	 @Autowired
	 private MqttGateway mqttGateway;

    @RequestMapping("/sendmsg")  
    public String sendmsg(@RequestParam(value = "topic") String topic, @RequestParam(value = "message") String message) {
       // mqttGateway.sendMessage2Mqtt(message);
    	System.out.println(topic);
    	System.out.println(message);
    	mqttGateway.sendToMqtt(message,  topic);
    	//mqttGateway.sendToMqtt(message);
        return "SUCCESS";
    }
    
    @RequestMapping("/setmqtttopic")   
    public String setMqtttopic(@RequestParam(value = "topic") String topic) {      
    	System.out.println(topic);
    	String[] topics = MqttReceiveConfig.adapter.getTopic();
    	boolean isexisting = false;
    	for(int i = 0;i < topics.length; i ++) {
    		if(topics[i].equals(topic)) {
    			isexisting = true;
    			break;
    		}
    	}
    	if(!isexisting) {
    		MqttReceiveConfig.adapter.addTopic(topic);    	
    		return "success";
    	}else {
    		return "already";
    	}
    }
    
    @RequestMapping("/gettopicval")
    @ResponseBody
    public String gettopicval(@RequestParam(value = "topic") String topic) {       
    	System.out.println(topic);    	
        return MqttReceiveConfig.map.get(topic);
    }
}
