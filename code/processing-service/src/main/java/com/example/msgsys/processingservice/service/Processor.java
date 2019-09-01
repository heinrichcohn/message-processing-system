package com.example.msgsys.processingservice.service;

import com.example.msgsys.sharedlib.model.IngestMessage;

public interface Processor {
    void process(IngestMessage ingestMessage);
}
