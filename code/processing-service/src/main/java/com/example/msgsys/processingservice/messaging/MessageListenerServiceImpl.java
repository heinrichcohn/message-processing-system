package com.example.msgsys.processingservice.messaging;

import com.example.msgsys.processingservice.service.Processor;
import com.example.msgsys.sharedlib.model.IngestMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageListenerServiceImpl implements MessageListenerService {

    @Autowired
    Processor processor;

    //This is the method that will be called each time there is a message in the queue
    //Concurrency property can be defined so several messages can be handled in parallel
    @RabbitListener(queues = RabbitMqConfig.MESSAGES_INGEST_QUEUE)    //concurrency is defined in the application.properties file
    public void receiveMessage(IngestMessage ingestMessage) {
        processor.process(ingestMessage);
    }
}
