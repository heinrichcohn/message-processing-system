package com.example.msgsys.monitoringservice.service;

import com.example.msgsys.monitoringservice.exception.MessageStatusNotFoundException;
import com.example.msgsys.monitoringservice.exception.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.MessageFormat;
import java.util.UUID;

@Service
public class MessageMonitorImpl implements MessageMonitor {
    private final Logger logger = LoggerFactory.getLogger(MessageMonitorImpl.class);
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public String getMessageStatus(String messageId) {
        if (!isMessageIdValid(messageId)) {
            logger.error("Invalid messageId parameter. The value must be a string that represents valid UUID");
            throw new ValidationException("Invalid messageId parameter. The value must be a string that represents valid UUID");
        }

        String messageStatus = stringRedisTemplate.opsForValue().get(messageId);

        if (messageStatus == null) {  //no status found for the given message id
            logger.error(MessageFormat.format("Status was not found for messageId:{0}",messageId));
            throw new MessageStatusNotFoundException(MessageFormat.format("Status was not found for messageId:{0}",messageId));
        }

        logger.info(MessageFormat.format("Message status found. messageId:{0} messageStatus:{1}",messageId, messageStatus));

        return messageStatus;
    }

    private boolean isMessageIdValid(String messageId) {
        if (StringUtils.isEmpty(messageId)) {
            return false;
        }
        try {
            UUID.fromString(messageId);
        }
        catch (IllegalArgumentException iae) {
            return false;
        }

        return true;
    }

}
