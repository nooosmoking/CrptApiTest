package org.example;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Product {
    @JsonProperty("certificate_document")
    private String certificateDocument;

    @JsonProperty("certificate_document_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date certificateDocumentDate;

    @JsonProperty("certificate_document_number")
    private String certificateDocumentNumber;

    @JsonProperty("owner_inn")
    private String ownerInn;

    @JsonProperty("producer_inn")
    private String producerInn;

    @JsonProperty("production_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date productionDate;

    @JsonProperty("tnved_code")
    private String tnvedCode;

    @JsonProperty("uit_code")
    private String uitCode;

    @JsonProperty("uitu_code")
    private String uituCode;

    public Product(String certificateDocument, Date certificateDocumentDate, String certificateDocumentNumber, String ownerInn, String producerInn, Date productionDate, String tnvedCode, String uitCode, String uituCode) {
        this.certificateDocument = certificateDocument;
        this.certificateDocumentDate = certificateDocumentDate;
        this.certificateDocumentNumber = certificateDocumentNumber;
        this.ownerInn = ownerInn;
        this.producerInn = producerInn;
        this.productionDate = productionDate;
        this.tnvedCode = tnvedCode;
        this.uitCode = uitCode;
        this.uituCode = uituCode;
    }

    public String getCertificateDocument() {
        return certificateDocument;
    }

    public void setCertificateDocument(String certificateDocument) {
        this.certificateDocument = certificateDocument;
    }

    public Date getCertificateDocumentDate() {
        return certificateDocumentDate;
    }

    public void setCertificateDocumentDate(Date certificateDocumentDate) {
        this.certificateDocumentDate = certificateDocumentDate;
    }

    public String getCertificateDocumentNumber() {
        return certificateDocumentNumber;
    }

    public void setCertificateDocumentNumber(String certificateDocumentNumber) {
        this.certificateDocumentNumber = certificateDocumentNumber;
    }

    public String getOwnerInn() {
        return ownerInn;
    }

    public void setOwnerInn(String ownerInn) {
        this.ownerInn = ownerInn;
    }

    public String getProducerInn() {
        return producerInn;
    }

    public void setProducerInn(String producerInn) {
        this.producerInn = producerInn;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public String getTnvedCode() {
        return tnvedCode;
    }

    public void setTnvedCode(String tnvedCode) {
        this.tnvedCode = tnvedCode;
    }

    public String getUitCode() {
        return uitCode;
    }

    public void setUitCode(String uitCode) {
        this.uitCode = uitCode;
    }

    public String getUituCode() {
        return uituCode;
    }

    public void setUituCode(String uituCode) {
        this.uituCode = uituCode;
    }
}
