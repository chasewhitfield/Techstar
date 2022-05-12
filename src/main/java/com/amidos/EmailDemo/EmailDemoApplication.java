package com.amidos.EmailDemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.amidos.EmailDemo.Intern.Intern;

@SpringBootApplication
public class EmailDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailDemoApplication.class, args);
	}
	
	
	 public ArrayList<String> generateCSV () throws FileNotFoundException {
		System.out.println("Now generating csv...");
        ArrayList<Intern> TechStar = generateList("intern.csv");

        Intern a = new Intern("Chase Whitfield", 5, 5, 5, 5, 5, 5, 5,
                5, 5, 5, 5, 5, 5, 5, 5, 5, 5
        , 5, 5);
        
        System.out.println("Going through for loop...");
        List<Intern> partners = a.getClosestInterns(TechStar, 2);
        ArrayList<String> emails = new ArrayList<>();
        for (Intern partner : partners) {
        	String partEmail = partner.generateEmail();
            System.out.println(partEmail);
            emails.add(partEmail);
            System.out.println("Distance from you: " + partner.distanceToOtherIntern(a));
        }
        return emails;
    }

    static ArrayList<Intern> generateList(String filePath) throws FileNotFoundException {
        ArrayList<Intern> interns = new ArrayList<Intern>();
        File csv = new File(filePath); //might have to change to filepath
        try {
            Scanner sc = new Scanner(csv);
            while (sc.hasNextLine()) {
                String curRow = sc.nextLine();
                String[] cols = curRow.split(","); //Need to parse out whitespace
                Intern curIntern = new Intern(cols[0], Integer.parseInt(cols[1]), Integer.parseInt(cols[2]), Integer.parseInt(cols[3]), Integer.parseInt(cols[4]), Integer.parseInt(cols[5]),
                        Integer.parseInt(cols[6]), Integer.parseInt(cols[7]), Integer.parseInt(cols[8]), Integer.parseInt(cols[9]),
                        Integer.parseInt(cols[10]), Integer.parseInt(cols[11]), Integer.parseInt(cols[12]), Integer.parseInt(cols[13]),
                        Integer.parseInt(cols[14]), Integer.parseInt(cols[15]), Integer.parseInt(cols[16]), Integer.parseInt(cols[17]),
                        Integer.parseInt(cols[18]), Integer.parseInt(cols[19]));
                interns.add(curIntern);
                System.out.println(curIntern.getName() + " has been added!");
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
            throw e;
        }
        return interns;
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
    
    private void sendEmail(ArrayList<String> inEmails) {
    	for(int i = 0; i < inEmails.size(); i++) {
    		sendEmail(inEmails.get(i));
    	}
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
			ArrayList<String> internEmails = generateCSV();
			
			if(internEmails == null) {
				//Uhh what do we do here
			}
			else if(internEmails.size() == 1) {
				sendEmail(internEmails.get(0));
			}
			else {
				sendEmail(internEmails);
			}
		};
	}
	
	
}
