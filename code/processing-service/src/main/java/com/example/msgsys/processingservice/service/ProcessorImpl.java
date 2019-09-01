package com.example.msgsys.processingservice.service;

import com.example.msgsys.sharedlib.cache.MessageStatus;
import com.example.msgsys.sharedlib.cache.StatusService;
import com.example.msgsys.sharedlib.model.IngestMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
public class ProcessorImpl implements Processor {
    private  final Logger logger = LoggerFactory.getLogger(ProcessorImpl.class);

    @Autowired
    private StatusService statusService;

    @Override
    public void process(IngestMessage ingestMessage) {

        try {
            statusService.setMessageStatus(ingestMessage.getId(), MessageStatus.PROCESSING);
            logger.info(MessageFormat.format("Start processing ingested message. messageId:{0}",ingestMessage.getId()));
            simulateProcessing();
            statusService.setMessageStatus(ingestMessage.getId(), MessageStatus.COMPLETED);
            logger.info(MessageFormat.format("Finished processing ingested message. messageId:{0}", ingestMessage.getId()));
        }
        catch (Exception e) {
            logger.error(MessageFormat.format("Processing failed for ingested message. messageId:{0} error:{2}",ingestMessage.getId(), e.getMessage()));
            statusService.setMessageStatus(ingestMessage.getId(), MessageStatus.ERROR);
        }
    }
    private void simulateProcessing() {
        try {
            Thread.sleep(5000);
            //do nothing - simulating long processing
        }catch (Exception e) {
            //do nothing
        }
    }
}
