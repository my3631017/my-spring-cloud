package com.service.consumer.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2018-12-24 14:05
 */
@Slf4j
@Service
public class KafkaConsumer {
    /**
     * 监听test主题,有消息就读取
     *
     * @param message 消息
     */
    @KafkaListener(topics = "${kafka.topic}")
    public void consumer(@Payload String message, @Headers MessageHeaders headers) {
        log.info("message : {},headers : {}", message, headers);
    }
}
