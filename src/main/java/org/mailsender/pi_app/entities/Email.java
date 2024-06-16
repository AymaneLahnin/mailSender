package org.mailsender.pi_app.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.processing.Generated;

@Document(collection ="emails")
public class Email {

    private String emailSender;
    private String destination;
    private String emailSubject;
    private String body;

    public Email() {
    }

    public Email(String emailSender, String destination, String emailSubject, String body) {
        this.emailSender = emailSender;
        this.destination = destination;
        this.emailSubject = emailSubject;
        this.body = body;
    }

    public String getEmailSender() {
        return emailSender;
    }

    public void setEmailSender(String emailSender) {
        this.emailSender = emailSender;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
