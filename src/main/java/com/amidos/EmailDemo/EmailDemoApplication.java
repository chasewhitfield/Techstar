package com.amidos.EmailDemo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootApplication
public class EmailDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailDemoApplication.class, args);
	}
	
	@Autowired
    private JavaMailSender javaMailSender;

    public void run(String... args) {

        System.out.println("Sending Email...");
        //sendEmail();
        System.out.println("Done");

    }
    
    private void sendEmail() {
    	System.out.println("Putting in a default email...");
    	sendEmail("interest.finder.for.ukg.members@gmail.com");
    }

    private void sendEmail(String toSomeone) {
    	try {
    		SimpleMailMessage msg = new SimpleMailMessage();
        
    		msg.setTo(toSomeone);
    		msg.setSubject("Testing from Spring Boot");
    		msg.setText("Hello World \n Spring Boot Email");
    		
    		System.out.println("Now sending the email...");
    		
    		javaMailSender.send(msg);
    		
    		System.out.println("Email sending was a success!");
    	}
    	catch(MailAuthenticationException e) {
    		System.out.println("Authentication was wrong! " + e.toString());
    	}
    	catch(IllegalStateException i) {
    		System.out.println("We reached a weird illegal state: " + i.toString());
    	}
    	catch(Exception x) {
    		System.out.println("Some other exception was caught: " + x.toString());
    	}
    }
    
    public void pie() {
    	System.out.println("Pie!");
    }
	

	//Copy and pasted from Spring.io guide
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			sendEmail();
		};
	}
	
	
}
