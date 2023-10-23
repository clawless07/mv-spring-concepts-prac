package com.mv.MVActiveMQExample.controller;

import com.mv.MVActiveMQExample.jms.JmsProducer;
import com.mv.MVActiveMQExample.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProduceMessageController {
    private static final Logger LOG = LoggerFactory.getLogger(ProduceMessageController.class);

    @Autowired
    JmsProducer jmsProducer;

    @PostMapping(value="/api/employee")
    public Employee sendMessage(@RequestBody Employee employee){
        jmsProducer.sendMessage(employee);
        return employee;
    }
}
