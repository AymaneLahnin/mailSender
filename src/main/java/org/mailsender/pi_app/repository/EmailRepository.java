package org.mailsender.pi_app.repository;



import org.mailsender.pi_app.entities.Email;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepository extends MongoRepository<Email, String> {
    List<Email> findByEmailSender(String emailsender);
    void deleteByDestination(String destination);
}
