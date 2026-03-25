package com.jobsaw.jobsaw.kafka.producer;

import com.jobsaw.jobsaw.kafka.model.TextRequest;
import com.jobsaw.jobsaw.logging.Loggable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class DocumentKafkaProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${kafka.topics.document-request}")
    private String requestTopic;

    public DocumentKafkaProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Loggable("Sending document generation request")
    public void sendDocumentRequest(TextRequest request) {
        kafkaTemplate.send(requestTopic, request);
    }
}
