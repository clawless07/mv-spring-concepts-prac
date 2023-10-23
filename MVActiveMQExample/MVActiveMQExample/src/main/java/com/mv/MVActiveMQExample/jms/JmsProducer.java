package com.mv.MVActiveMQExample.jms;

import com.mv.MVActiveMQExample.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.JMSProducer;

@Component
public class JmsProducer {
    Logger LOG = LoggerFactory.getLogger(JMSProducer.class);

    @Autowired
    JmsTemplate jmsTemplate;

    @Value("${activemq.topic-name}")
    private String topic;

    public void sendMessage(Employee message){
        try{
            LOG.info("Attempting to send message to topic : " + topic);
            jmsTemplate.convertAndSend(topic, message);
        }catch (Exception e){
            LOG.error("Received exception during  send message", e);
        }
    }
}
