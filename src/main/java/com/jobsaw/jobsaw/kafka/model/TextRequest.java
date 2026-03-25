package com.jobsaw.jobsaw.kafka.model;

public class TextRequest {
    private String text;
    private String correlationId;

    public TextRequest() {}

    public TextRequest(String text, String correlationId) {
        this.text = text;
        this.correlationId = correlationId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }
}
