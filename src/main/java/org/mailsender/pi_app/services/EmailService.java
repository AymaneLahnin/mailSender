package org.mailsender.pi_app.services;


import org.mailsender.pi_app.entities.Email;
import org.mailsender.pi_app.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    public Email save(Email email) {
        return emailRepository.save(email);
    }

    public Email findById(String id) {
        return emailRepository.findById(id).orElse(null);
    }

    public List<Email> findByEmailSender(String emailsender){
        return emailRepository.findByEmailSender(emailsender);
    }
    public List<Email> findAll() {
        return emailRepository.findAll();
    }

    public void deleteById(String id) {
        emailRepository.deleteById(id);
    }
    public void deleteByDestination(String destination){
        emailRepository.deleteByDestination(destination);
    }
    public void deleteAll(){
        emailRepository.deleteAll();
    }
}
