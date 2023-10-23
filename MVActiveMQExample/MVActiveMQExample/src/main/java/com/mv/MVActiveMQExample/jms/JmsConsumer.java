package com.mv.MVActiveMQExample.jms;

import com.mv.MVActiveMQExample.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

@Component
public class JmsConsumer implements MessageListener {

    private static final Logger LOG = LoggerFactory.getLogger(JmsConsumer.class);
    @Override
    @JmsListener(destination = "${activemq.topic-name}")
    public void onMessage(Message message){
        try{
            ObjectMessage objectMessage = (ObjectMessage) message;
            Employee employee = (Employee) objectMessage.getObject();
            LOG.info("Received message: " + employee.toString());
        }catch (Exception e){
            LOG.error("Received Exception : " + e);
        }
    }
}
