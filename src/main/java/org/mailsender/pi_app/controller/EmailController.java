package org.mailsender.pi_app.controller;


import org.mailsender.pi_app.entities.Email;
import org.mailsender.pi_app.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emails")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    public Email createEmail(@RequestBody Email email) {
        return emailService.save(email);
    }

    @GetMapping("/{id}")
    public Email getEmailById(@PathVariable String id) {
        return emailService.findById(id);
    }

    @GetMapping
    public List<Email> getAllEmails() {
        return emailService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteEmail(@PathVariable String id) {
        emailService.deleteById(id);
    }

    @GetMapping("/sender/{emailSender}")
    public List<Email> getEmailByEmailSender(@PathVariable String emailSender) {
        return emailService.findByEmailSender(emailSender);
    }

    @DeleteMapping("/delete/{destination}")
    public void deleteEmailBydestination(@PathVariable String destination){
        emailService.deleteByDestination(destination);
    }
    @DeleteMapping("/delete/All")
    public void clearAll(){
        emailService.deleteAll();
    }
}
