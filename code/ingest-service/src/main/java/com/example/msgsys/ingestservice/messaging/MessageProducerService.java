package com.example.msgsys.ingestservice.messaging;

import com.example.msgsys.sharedlib.model.IngestMessage;

public interface MessageProducerService {

    void sendMessage(IngestMessage ingestMessage);
}
