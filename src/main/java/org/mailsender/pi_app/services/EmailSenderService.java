package org.mailsender.pi_app.services;

import org.mailsender.pi_app.entities.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender javaMailSender;
    public void sendEmail(Email email){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(email.getEmailSender());
        message.setTo(email.getDestination());
        message.setText(email.getBody());

        javaMailSender.send(message);

        System.out.println("Mail is send successfully!!");
    }
}
