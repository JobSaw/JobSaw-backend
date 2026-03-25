package com.jobsaw.jobsaw.kafka.consumer;

import com.jobsaw.jobsaw.kafka.model.DocumentResponse;
import com.jobsaw.jobsaw.logging.Loggable;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.util.Base64;

@Service
public class DocumentKafkaConsumer {

    @Loggable("Received generated document")
    @KafkaListener(topics = "${kafka.topics.document-response}")
    public void consumeDocumentResponse(DocumentResponse response) {
        if (response != null) {
            System.out.println("Received text: " + response.getText());
            if (response.getPdfBase64() != null) {
                try {
                    byte[] pdfBytes = Base64.getDecoder().decode(response.getPdfBase64());
                    System.out.println("Successfully decoded PDF, size: " + pdfBytes.length + " bytes.");
                    // In a real application, you would handle the PDF bytes here
                } catch (IllegalArgumentException e) {
                    System.err.println("Failed to decode base64 PDF: " + e.getMessage());
                }
            }
        }
    }
}
