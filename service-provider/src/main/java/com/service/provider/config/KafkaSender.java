package com.service.provider.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2018-12-24 14:02
 */
@Component
public class KafkaSender {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaSender(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Value("${kafka.topic}")
    String topic;

    /*
     * 发送消息到kafka,主题为test
     */
    public void sendTest() {
        kafkaTemplate.send(topic, "hello,kafka  " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
    }
}
