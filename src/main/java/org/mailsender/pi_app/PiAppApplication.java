package org.mailsender.pi_app;

import org.mailsender.pi_app.controller.EmailController;
import org.mailsender.pi_app.entities.Email;
import org.mailsender.pi_app.services.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class PiAppApplication implements CommandLineRunner {
@Autowired
private EmailSenderService emailSenderService;
@Autowired
private EmailController emailController;
    public static void main(String[] args) {
        SpringApplication.run(PiAppApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        Boolean repeat = true;
        while(repeat){
            System.out.println("Enter Email Sender:");
            String emailSender = scanner.nextLine();

            System.out.println("Enter Destination Email:");
            String destination = scanner.nextLine();

            System.out.println("Enter Email Subject:");
            String emailSubject = scanner.nextLine();

            System.out.println("Enter Email Body:");
            String body = scanner.nextLine();

            // Create Email object
            Email email = new Email(emailSender, destination, emailSubject, body);
            emailController.createEmail(email);

            // Send email using EmailSenderService (assuming implementation is present)
            emailSenderService.sendEmail(email);

            System.out.println("Email sent successfully!");
            System.out.println("do you want to send another email:(y/n)");
            String response=scanner.nextLine().toLowerCase();
            if(response == "n"){
                repeat=false;
            }

        }

        System.out.println("Exiting email sending program.");

        scanner.close();
    }
}
