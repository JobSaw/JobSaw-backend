package com.jobsaw.jobsaw.kafka;

import com.jobsaw.jobsaw.kafka.model.TextRequest;
import com.jobsaw.jobsaw.kafka.producer.DocumentKafkaProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@EmbeddedKafka(partitions = 1, topics = {"${kafka.topics.document-request}", "${kafka.topics.document-response}"})
@DirtiesContext
public class DocumentKafkaIntegrationTest {

    @Autowired
    private DocumentKafkaProducer producer;

    @Test
    public void testSendMessage() {
        // Send a mock request to verify producer JSON serialization and Kafka template works
        TextRequest request = new TextRequest("Generate PDF for this text", "test-corr-id");
        producer.sendDocumentRequest(request);
    }
}
