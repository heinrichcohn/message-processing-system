package com.example.msgsys.monitoringservice.service;

import com.example.msgsys.monitoringservice.exception.MessageStatusNotFoundException;

public interface MessageMonitor {
    String getMessageStatus(String messageId) throws MessageStatusNotFoundException;
}
