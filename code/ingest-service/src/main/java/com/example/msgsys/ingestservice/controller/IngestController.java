package com.example.msgsys.ingestservice.controller;

import com.example.msgsys.ingestservice.controller.request.IngestMessageRequest;
import com.example.msgsys.ingestservice.controller.response.IngestMessageResponse;

public interface IngestController {

    IngestMessageResponse ingest(IngestMessageRequest request);
}
