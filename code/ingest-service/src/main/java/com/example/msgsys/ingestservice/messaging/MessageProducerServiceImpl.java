package com.example.msgsys.ingestservice.messaging;

import com.example.msgsys.sharedlib.model.IngestMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageProducerServiceImpl implements MessageProducerService {

    @Autowired
    private  RabbitTemplate rabbitTemplate;

    @Override
    public void sendMessage(IngestMessage ingestMessage) {

        CorrelationData correlationData = new CorrelationData(ingestMessage.getId());
        rabbitTemplate.convertAndSend( RabbitMqConfig.MESSAGES_INGEST_EXCHANGE, RabbitMqConfig.MESSAGES_INGEST_QUEUE, ingestMessage, correlationData);
    }
}
