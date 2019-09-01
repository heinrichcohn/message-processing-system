package com.example.msgsys.ingestservice.service;

import com.example.msgsys.ingestservice.exception.ValidationException;
import com.example.msgsys.ingestservice.messaging.MessageProducerService;
import com.example.msgsys.sharedlib.cache.MessageStatus;
import com.example.msgsys.sharedlib.cache.StatusService;
import com.example.msgsys.sharedlib.model.IngestMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.MessageFormat;
import java.util.UUID;

@Service
public class IngestServiceImpl implements IngestService {
    private final Logger logger = LoggerFactory.getLogger(IngestServiceImpl.class);

    @Autowired
    private MessageProducerService messageProducerService;
    @Autowired
    private StatusService messageStatusService;

    @Override
    public String ingest(String messagePayload) {

        if(!isMessageValid(messagePayload)){
            throw new ValidationException("Invalid ingest message payload");
        }
        IngestMessage ingestMessage = new IngestMessage();
        ingestMessage.setBody(messagePayload);
        String generatedId = UUID.randomUUID().toString();
        ingestMessage.setId(generatedId);
        messageStatusService.setMessageStatus(ingestMessage.getId(), MessageStatus.ACCEPTED);

        try {
            messageProducerService.sendMessage(ingestMessage);
            logger.info(MessageFormat.format("Message was ingested successfully. messagedId:{0}", ingestMessage.getId()));
            return ingestMessage.getId();

        }catch (Exception e) {
            logger.error(MessageFormat.format("An error occurred while trying to ingest message. messageId:{0} error:{1}", ingestMessage.getId(), e.getMessage()));
            messageStatusService.setMessageStatus(ingestMessage.getId(), MessageStatus.ERROR);
            throw e;
        }
    }

    private boolean isMessageValid(String messagePayload) {
        //Since in this demo the payload is a String object, we're doing a basic String validation.
        return !StringUtils.isEmpty(messagePayload);
    }
}
