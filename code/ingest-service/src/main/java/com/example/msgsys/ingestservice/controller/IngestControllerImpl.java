package com.example.msgsys.ingestservice.controller;

import com.example.msgsys.ingestservice.controller.request.IngestMessageRequest;
import com.example.msgsys.ingestservice.controller.response.IngestMessageResponse;
import com.example.msgsys.ingestservice.service.IngestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/ingest-messages")
public class IngestControllerImpl implements IngestController {

    @Autowired
    private IngestService ingestService;

    @Override
    @PostMapping
    public @ResponseBody IngestMessageResponse ingest(@RequestBody IngestMessageRequest request) {

        String messageId = ingestService.ingest(request.getBody());
        IngestMessageResponse response = new IngestMessageResponse();
        response.setMessageId(messageId);
        return response;
    }
}
