package com.example.msgsys.monitoringservice.controller;

import com.example.msgsys.monitoringservice.controller.response.MessageStatusResponse;
import com.example.msgsys.monitoringservice.service.MessageMonitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/message-statuses")
public class MonitorControllerImpl implements MonitorController {

    @Autowired
    MessageMonitor messageMonitor;

    @Override
    @GetMapping("/{messageId}")
    public @ResponseBody MessageStatusResponse getMessageStatus(@PathVariable String messageId) {
        String status = messageMonitor.getMessageStatus(messageId);
        MessageStatusResponse response = new MessageStatusResponse();
        response.setMessageId(messageId);
        response.setStatus(status);

        return response;
    }
}
