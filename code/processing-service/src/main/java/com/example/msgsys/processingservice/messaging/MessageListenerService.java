package com.example.msgsys.processingservice.messaging;

import com.example.msgsys.sharedlib.model.IngestMessage;

public interface MessageListenerService {

    void receiveMessage(IngestMessage ingestMessage);
}
