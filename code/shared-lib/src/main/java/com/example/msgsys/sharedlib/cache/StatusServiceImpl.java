package com.example.msgsys.sharedlib.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.concurrent.TimeUnit;

@Service
public class StatusServiceImpl implements StatusService {
    private final Logger logger = LoggerFactory.getLogger(StatusServiceImpl.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void setMessageStatus(String messageId, MessageStatus messageStatus) {
        try {
            stringRedisTemplate.opsForValue().set(messageId, messageStatus.toString(), 20, TimeUnit.MINUTES);
            logger.info(MessageFormat.format("Set message status. messageId:{0} messageStatus:{1}", messageId, messageStatus));
        } catch(Exception e) {
            //For the purpose of this demo we are not going to throw and exception when trying to update a message status
            //so we don't fail the whole ingest process in order to NOT lose any message.
            logger.error(MessageFormat.format("Unable to set status for message. messageId:{0} messageStatus:{1}", messageId, messageStatus));
        }
    }
}
