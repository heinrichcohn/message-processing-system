package com.example.msgsys.monitoringservice.controller;

import com.example.msgsys.monitoringservice.controller.response.MessageStatusResponse;
import org.springframework.web.bind.annotation.PathVariable;

public interface MonitorController {
    MessageStatusResponse getMessageStatus(@PathVariable String messageId);
}
