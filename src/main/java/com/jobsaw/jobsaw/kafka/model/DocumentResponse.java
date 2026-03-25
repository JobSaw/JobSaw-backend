package com.jobsaw.jobsaw.kafka.model;

public class DocumentResponse {
    private String text;
    private String pdfBase64;
    private String correlationId;

    public DocumentResponse() {}

    public DocumentResponse(String text, String pdfBase64, String correlationId) {
        this.text = text;
        this.pdfBase64 = pdfBase64;
        this.correlationId = correlationId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPdfBase64() {
        return pdfBase64;
    }

    public void setPdfBase64(String pdfBase64) {
        this.pdfBase64 = pdfBase64;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }
}
